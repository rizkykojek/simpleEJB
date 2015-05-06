package com.rizkykojek.ejb.test;

import javax.naming.Context;
import javax.naming.NamingException;

import com.rizkykojek.ejb.messaging.producer.ShippingQueue;
import com.rizkykojek.ejb.messaging.producer.ShippingQueueRemote;
import com.rizkykojek.ejb.messaging.producer.ShippingTopic;
import com.rizkykojek.ejb.messaging.producer.ShippingTopicRemote;

public class ShippingTest {
	
	public static void main(String[] args) {
		try {
			Context ctx =  ContextUtility.getInitialContext();
			
			//ShippingQueueTest(ctx);
			ShippingTopicTest(ctx);
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void ShippingQueueTest(Context ctx) throws NamingException{
		String lookupName = ContextUtility.getLookupName(ShippingQueue.class.getSimpleName(), ShippingQueueRemote.class.getName(), Boolean.TRUE);
		
		ShippingQueueRemote shippingQueueRemote = (ShippingQueueRemote) ctx.lookup(lookupName);
		
		String address = "Haji Ambas no.25 JAKSEL";
		String item = "Zenfone 5";
		Integer amount = 1;
		shippingQueueRemote.requestShipping(address, item, amount);
	}
	
	private static void ShippingTopicTest(Context ctx) throws NamingException{
		String lookupName = ContextUtility.getLookupName(ShippingTopic.class.getSimpleName(), ShippingTopicRemote.class.getName(), Boolean.TRUE);
		
		ShippingTopicRemote shippingTopicRemote = (ShippingTopicRemote) ctx.lookup(lookupName);
		
		String address = "Jl. Graha Asih Raya no.35 Bandung";
		String item = "Samsung Galaxy S";
		Integer amount = 5;
		shippingTopicRemote.requestShipping(address, item, amount);
	}
}
