package com.rizkykojek.ejb.messaging.producer;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;

import com.rizkykojek.ejb.entity.ShippingObject;

/**
 * Session Bean implementation class ShippingTopic
 */
@Stateful
public class ShippingTopic implements ShippingTopicRemote {

	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	private JMSContext context;

	@Resource(name = "java:/jboss/exported/jms/topic/testtopic")
	private Destination destination;
	
    /**
     * Default constructor. 
     */
    public ShippingTopic() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void requestShipping(String address, String item, Integer amount) {
		try {
			ShippingObject object =  new ShippingObject();
			object.setItem(item);
			object.setAddress(address);
			object.setAmount(amount);
			
			ObjectMessage om = context.createObjectMessage();
			om.setObject(object);

			JMSProducer producer = context.createProducer();
			producer.send(destination, om);
			
			System.out.println("MESSAGE SEND SUCCESSFULLY TO MOM --- TOPIC TYPE MESSAGE");
		} catch (JMSException e){
			e.printStackTrace();
		}
		
	}

}
