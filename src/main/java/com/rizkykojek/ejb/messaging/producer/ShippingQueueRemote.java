package com.rizkykojek.ejb.messaging.producer;

import javax.ejb.Remote;

@Remote
public interface ShippingQueueRemote {

	public void requestShipping(String address, String item, Integer amount);
	
}
