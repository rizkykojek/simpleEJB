package com.rizkykojek.ejb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class RequestItemStatefull
 */
@Stateful
public class RequestItemStateful implements RequestItemStatefulRemote {
    
    private List<String> items;
    /**
     * Default constructor. 
     */
    public RequestItemStateful() {
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
