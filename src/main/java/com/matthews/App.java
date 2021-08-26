package com.matthews;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.matthews.json.HostOneOfDeserializer;
import com.matthews.json.PortOneOfDeserializer;
import com.matthews.model.Endpoint;
import com.matthews.model.HostOneOf;
import com.matthews.model.HostString;
import com.matthews.model.HostVar;
import com.matthews.model.PortNumber;
import com.matthews.model.PortOneOf;
import com.matthews.model.PortVar;
import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
public class App
{
    public static void main( String[] args )
    {
        String portOneOfAsNum = "8080";
        String portOneOfAsVar = "{\"var\": \"$foo\", \"description\": \"hello world\", \"value\": 8080}";
        String hostOneOfAsStr = "\"test.example.com\"";
        String hostOneOfAsVar = "{\"var\": \"$foo\", \"description\": \"hello world\", \"value\": \"default.example.com\"}";

        String endPointWithVars = "{\"host\":" + hostOneOfAsVar + ", \"port\": " + portOneOfAsVar + "}";
        String endPointWithValues  = "{\"host\":" + hostOneOfAsStr + ", \"port\": " + portOneOfAsNum + "}";

        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(PortOneOf.class, new PortOneOfDeserializer());
        module.addDeserializer(HostOneOf.class, new HostOneOfDeserializer());
        mapper.registerModule(module);

        try {
            log.info(mapper.readValue(portOneOfAsNum, PortNumber.class).toString());
            log.info(mapper.readValue(portOneOfAsNum, PortOneOf.class).toString());

            log.info(mapper.readValue(portOneOfAsVar, PortVar.class).toString());
            log.info(mapper.readValue(portOneOfAsVar, PortOneOf.class).toString());

            log.info(mapper.readValue(hostOneOfAsStr, HostString.class).toString());
            log.info(mapper.readValue(hostOneOfAsStr, HostOneOf.class).toString());

            log.info(mapper.readValue(hostOneOfAsVar, HostVar.class).toString());
            log.info(mapper.readValue(hostOneOfAsVar, HostOneOf.class).toString());

            log.info(mapper.readValue(endPointWithVars, Endpoint.class).toString());
            log.info(mapper.readValue(endPointWithValues, Endpoint.class).toString());
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}
