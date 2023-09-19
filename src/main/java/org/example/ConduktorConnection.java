package org.example;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.streams.StreamsConfig;

import java.util.Properties;

public class ConduktorConnection {

    static Properties getConsumerProperties(){
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG,"My_Stream_APP");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"cluster.playground.cdkt.io:9092");
        properties.put(StreamsConfig.SECURITY_PROTOCOL_CONFIG,"SASL_SSL");
        properties.put("sasl.jaas.config","org.apache.kafka.common.security.plain.PlainLoginModule required username=\"2SrY1ltyFWgx5Vio7vZOwz\" password=\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY29uZHVrdG9yLmlvIiwic291cmNlQXBwbGljYXRpb24iOiJhZG1pbiIsInVzZXJNYWlsIjpudWxsLCJwYXlsb2FkIjp7InZhbGlkRm9yVXNlcm5hbWUiOiIyU3JZMWx0eUZXZ3g1VmlvN3ZaT3d6Iiwib3JnYW5pemF0aW9uSWQiOjc2NzE0LCJ1c2VySWQiOjg5MjUxLCJmb3JFeHBpcmF0aW9uQ2hlY2siOiI4ZGNkMjgzNC0wODIzLTQxZDktODcyMC04MTg5ZmExZmZkOGIifX0.SNa4Kie6W48DLlJM9_JkP8grxtfOPbLEglbETAHPYn0\";");
        properties.put("sasl.mechanism","PLAIN");

        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());
        //properties.setProperty("group.id","my-app");
        properties.put("auto.offset.reset","earliest");
        return properties;
    }
}
