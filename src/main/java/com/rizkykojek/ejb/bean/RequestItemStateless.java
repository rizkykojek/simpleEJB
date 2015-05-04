package com.rizkykojek.ejb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class RequestItem
 */
@Stateless
public class RequestItemStateless implements RequestItemStatelessRemote {

	private List<String> items;
    /**
     * Default constructor. 
     */
    public RequestItemStateless() {
    	System.out.println("initial");
        items = new ArrayList<String>();
    }
    
    public void addItem(String item){
    	System.out.println("add " + item);
    	items.add(item);
    }
    
    public List<String> getItems(){
    	System.out.println("list");
    	return items;
    }

}
