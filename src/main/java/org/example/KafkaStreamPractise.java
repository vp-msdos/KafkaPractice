package org.example;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Aggregator;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class KafkaStreamPractise {

    private static final Logger Log = LoggerFactory.getLogger(KafkaStreamPractise.class);
    private static String INPUT_TOPIC = "Aggre_Test";
    private static String OUTPUT_TOPIC = "Aggregation_Output";
    public static void main(String[] args) {
        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String,String> kstream = streamsBuilder.stream(INPUT_TOPIC);
        Log.info("KStream build using StreamsBuilder for INPUT_TOPIC : "+INPUT_TOPIC);

        try {
            Duration windowSize = Duration.ofSeconds(60);
            TimeWindows tumbleWindow = TimeWindows.of(windowSize);
            kstream.groupByKey().windowedBy(tumbleWindow).reduce((one,two)-> one+two, Materialized.with(Serdes.String(), Serdes.String()))
                    .toStream().to(OUTPUT_TOPIC);

            KafkaStreams streams = new KafkaStreams(streamsBuilder.build(), ConduktorConnection.getConsumerProperties());
            streams.start();

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
