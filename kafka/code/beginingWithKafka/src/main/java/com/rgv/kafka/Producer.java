package com.rgv.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

// first
public class Producer {
    public static void main(String[] args) {

        String bootstrapServer = "localhost:9092";

        // create producer properties:
        Properties props = new Properties();
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // serializer class is used to convert the data being sent to the server to bytes.

        // create producer using properties created above:
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        //create producer record:
        ProducerRecord<String, String> record = new ProducerRecord<>("first-topic", "Hello world");

        // send record created using the producer object:
        producer.send(record);

        //Flush data
        producer.flush();
        // flush and close producer
        producer.close();
    }
}
// next: producerWithCallback
