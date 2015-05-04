package com.rizkykojek.ejb.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.ejb.client.ContextSelector;
import org.jboss.ejb.client.EJBClientConfiguration;
import org.jboss.ejb.client.EJBClientContext;
import org.jboss.ejb.client.PropertiesBasedEJBClientConfiguration;
import org.jboss.ejb.client.remoting.ConfigBasedEJBClientContextSelector;


public class ContextUtility {
	private static Context initialContext;
 
    public static Context getInitialContext() throws NamingException, FileNotFoundException, IOException {
    	
        if (initialContext == null) {
        	Properties clientProperties = new Properties();
		    clientProperties.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
		    clientProperties.put("remote.connections", "default");
		    clientProperties.put("remote.connection.default.port", "8080");
		    clientProperties.put("remote.connection.default.host", "localhost");
		    clientProperties.put("remote.connection.default.username", "root");
		    clientProperties.put("remote.connection.default.password", "sa1234");
		    clientProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");

		    EJBClientConfiguration ejbClientConfiguration = new PropertiesBasedEJBClientConfiguration(clientProperties);
		    ContextSelector<EJBClientContext> contextSelector = new ConfigBasedEJBClientContextSelector(ejbClientConfiguration);
		    EJBClientContext.setSelector(contextSelector);
		    
		    Properties properties = new Properties();
		    properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            initialContext = new InitialContext(properties);            
        }
        
        return initialContext;
    }
    
    /*public static Object doLookup(String beanName, String interfaceNameWithPackage, Boolean isStatefull) {
        Context context = null;
        String lookupName = "";
        try {
            // 1. Obtaining Context
            context = getInitialContext();
            // 2. Generate JNDI Lookup name
            lookupName = getLookupName(beanName, interfaceNameWithPackage, isStatefull);
            // 3. Lookup and cast
            return context.lookup(lookupName);
 
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }*/
 
    public static String getLookupName(String beanName, String remoteClassName, Boolean isStatefull) {
        /*
         * The app name is the EAR name of the deployed EJB without .ear suffix.
         * Since we haven't deployed the application as a .ear, the app name for
         * us will be an empty string
         */
        String appName = "";
 
        /*
         * The module name is the JAR name of the deployed EJB without the .jar
         * suffix.
         */
        String moduleName = "simpleEJB-1.0.FINAL";
 
        /*
         * AS7 allows each deployment to have an (optional) distinct name. This
         * can be an empty string if distinct name is not specified.
         */
        String distinctName = "";        
 
        // Create a look up string name
        String lookupName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + remoteClassName + (isStatefull ? "?stateful" : "");
        
        return lookupName;
        
    }
    
    
}
