package com.rizkykojek.ejb.messaging.consumer;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.rizkykojek.ejb.entity.ShippingObject;

/**
 * Message-Driven Bean implementation class for: VendorRizkyShippingTopicMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
							 @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jboss/exported/jms/topic/testtopic")
		})
public class VendorRizkyShippingTopicMDB implements MessageListener {

    /**
     * Default constructor. 
     */
    public VendorRizkyShippingTopicMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        try {
	    	ObjectMessage om = (ObjectMessage) message;			
			ShippingObject object = (ShippingObject) om.getObject();
			System.out.println("=======PROCESS SHIPPING REQUEST of VENDOR RIZKY======= \n"
					+ "Nama Barang = " + object.getItem() + "\n"
					+ "Dikirim ke alamat = " + object.getAddress() + "\n"
					+ "Berapa Banyak = " + object.getAmount() + "\n");
    	} catch (JMSException ex) {
			ex.printStackTrace();
		}
        
    }

}
