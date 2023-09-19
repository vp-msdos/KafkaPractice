package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","cluster.playground.cdkt.io:9092");
        properties.setProperty("security.protocol","SASL_SSL");
        properties.setProperty("sasl.jaas.config","org.apache.kafka.common.security.plain.PlainLoginModule required username=\"2SrY1ltyFWgx5Vio7vZOwz\" password=\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY29uZHVrdG9yLmlvIiwic291cmNlQXBwbGljYXRpb24iOiJhZG1pbiIsInVzZXJNYWlsIjpudWxsLCJwYXlsb2FkIjp7InZhbGlkRm9yVXNlcm5hbWUiOiIyU3JZMWx0eUZXZ3g1VmlvN3ZaT3d6Iiwib3JnYW5pemF0aW9uSWQiOjc2NzE0LCJ1c2VySWQiOjg5MjUxLCJmb3JFeHBpcmF0aW9uQ2hlY2siOiI4ZGNkMjgzNC0wODIzLTQxZDktODcyMC04MTg5ZmExZmZkOGIifX0.SNa4Kie6W48DLlJM9_JkP8grxtfOPbLEglbETAHPYn0\";");
        properties.setProperty("sasl.mechanism","PLAIN");

        properties.setProperty("key","value");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer",StringSerializer.class.getName());

        KafkaProducer<String,String> producer = new KafkaProducer<>(properties);

        ProducerRecord<String,String> record = new ProducerRecord<>("demo","hello demo");

        producer.send(record);

        producer.flush();

        producer.close();
        log.info("Test succcesfull !");
    }
}