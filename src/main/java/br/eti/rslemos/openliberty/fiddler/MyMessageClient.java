package br.eti.rslemos.openliberty.fiddler;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/message")
public class MyMessageClient {
    @Inject @JMSConnectionFactory("jms/ConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "jndi/MyQueue")
    private Queue queue;

    @GET
    @Path("/post")
    @Produces("text/plain")
    public Response postAMessage() throws JMSException {
        Message message = context.createTextMessage("text");
        context.createProducer().send(queue, message);
        return Response.ok().build();
    }
}