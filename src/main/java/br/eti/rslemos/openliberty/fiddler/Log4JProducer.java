package br.eti.rslemos.openliberty.fiddler;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JProducer {
    @Default @Produces
    public Logger produceLogger(InjectionPoint ip) {
        return LogManager.getFormatterLogger(ip.getMember().getDeclaringClass());
    }
}