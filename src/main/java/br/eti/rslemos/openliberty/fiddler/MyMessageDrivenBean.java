package br.eti.rslemos.openliberty.fiddler;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.logging.log4j.Logger;

@MessageDriven(
    activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jndi/MyQueue")
    }
)
public class MyMessageDrivenBean implements MessageListener {

    @Inject
    private Logger log;

    @Override
    public void onMessage(Message message) {
        log.info("onMessage(%s)", message);
	}
}
