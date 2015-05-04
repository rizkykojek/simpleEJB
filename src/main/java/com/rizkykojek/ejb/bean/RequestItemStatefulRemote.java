package com.rizkykojek.ejb.bean;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RequestItemStatefulRemote {

	public void addItem(String item);
	
	public List<String> getItems();
	
}
