package com.rizkykojek.ejb.bean;

import javax.ejb.Remote;

@Remote
public interface HelloWorldBeanRemote {

	public String sayHello();

}
