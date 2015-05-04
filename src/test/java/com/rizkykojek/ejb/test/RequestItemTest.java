package com.rizkykojek.ejb.test;

import javax.naming.Context;
import javax.naming.NamingException;

import com.rizkykojek.ejb.bean.RequestItemSingleton;
import com.rizkykojek.ejb.bean.RequestItemSingletonRemote;
import com.rizkykojek.ejb.bean.RequestItemStateful;
import com.rizkykojek.ejb.bean.RequestItemStatefulRemote;
import com.rizkykojek.ejb.bean.RequestItemStateless;
import com.rizkykojek.ejb.bean.RequestItemStatelessRemote;

public class RequestItemTest {

	private static Context ctx;
	
	public static void main(String[] args) {	
		try {
			ctx =  ContextUtility.getInitialContext();
			singletonTest(ctx);
			statelessTest(ctx);
			statefulTest(ctx);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void singletonTest(Context ctx) throws NamingException{
		String lookupName = ContextUtility.getLookupName(RequestItemSingleton.class.getSimpleName(), RequestItemSingletonRemote.class.getName(), Boolean.FALSE);
		
		RequestItemSingletonRemote requestItemSingletonRemote = (RequestItemSingletonRemote) ctx.lookup(lookupName);
		requestItemSingletonRemote.addItem("book");
		requestItemSingletonRemote.addItem("car");
		
		System.out.println("======SINGLETON=====");
		System.out.println(requestItemSingletonRemote.getItems().toString());
		System.out.println("");
	}
	
	private static void statelessTest(Context ctx) throws NamingException{
		String lookupName = ContextUtility.getLookupName(RequestItemStateless.class.getSimpleName(), RequestItemStatelessRemote.class.getName(), Boolean.FALSE);
		
		RequestItemStatelessRemote requestItemStatelessRemote = (RequestItemStatelessRemote) ctx.lookup(lookupName);
		requestItemStatelessRemote.addItem("book");
		requestItemStatelessRemote.addItem("car");
		
		System.out.println("======STATELESS=====");
		System.out.println(requestItemStatelessRemote.getItems().toString());
		System.out.println("");
	}
	
	private static void statefulTest(Context ctx) throws NamingException{
		String lookupName = ContextUtility.getLookupName(RequestItemStateful.class.getSimpleName(), RequestItemStatefulRemote.class.getName(), Boolean.TRUE);
		
		RequestItemStatefulRemote requestItemStatefulRemote = (RequestItemStatefulRemote) ctx.lookup(lookupName);
		requestItemStatefulRemote.addItem("book");
		requestItemStatefulRemote.addItem("car");
		
		System.out.println("======STATEFUL calling 1=====");
		System.out.println(requestItemStatefulRemote.getItems().toString());
		System.out.println("");
		
		requestItemStatefulRemote = (RequestItemStatefulRemote) ctx.lookup(lookupName);
		requestItemStatefulRemote.addItem("window");
		requestItemStatefulRemote.addItem("door");
		
		System.out.println("======STATEFUL calling 2=====");
		System.out.println(requestItemStatefulRemote.getItems().toString());
		System.out.println("");
	}

}
