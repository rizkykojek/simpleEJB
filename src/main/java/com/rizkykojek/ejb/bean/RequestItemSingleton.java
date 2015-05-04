package com.rizkykojek.ejb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

/**
 * Session Bean implementation class RequestItemSingleton
 */
@Singleton
public class RequestItemSingleton implements RequestItemSingletonRemote {
    
    private List<String> items;
    /**
     * Default constructor. 
     */
    public RequestItemSingleton() {
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
