package com.rizkykojek.ejb.messaging.consumer;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.rizkykojek.ejb.entity.ShippingObject;

/**
 * Message-Driven Bean implementation class for: ShippingQueueMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
							 @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jboss/exported/jms/queue/testqueue") 
		})
public class ShippingQueueMDB implements MessageListener {

    /**
     * Default constructor. 
     */
    public ShippingQueueMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	try {
	    	ObjectMessage om = (ObjectMessage) message;			
			ShippingObject object = (ShippingObject) om.getObject();
			System.out.println("=======PROCESS SHIPPING REQUEST=======");
			System.out.println("Nama Barang = " + object.getItem());
			System.out.println("Dikirim ke alamat = " + object.getAddress());
			System.out.println("Berapa Banyak = " + object.getAmount());
    	} catch (JMSException ex) {
			ex.printStackTrace();
		}
        
    }

}
