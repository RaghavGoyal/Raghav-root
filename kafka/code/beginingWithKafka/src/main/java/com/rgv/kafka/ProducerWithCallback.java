package com.rgv.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerWithCallback {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(ProducerWithCallback.class.getName());
        String bootstrapServer = "localhost:9092";

        // create producer properties:
        Properties props = new Properties();
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create producer using properties created above:
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        //create producer record:
        ProducerRecord<String, String> record = new ProducerRecord<>("first-topic", "Hello world");

        // send record created using the producer object:
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                // Executes everytime the record is sent or exception is thrown...
                if(e == null){
                    // record sent successfully
                    System.out.println("success");
                    logger.info("Received new Metadata. Topic:" +recordMetadata.topic());
                }
                else{
                    // record not sent successfully
                    System.out.println("failure");
                    logger.error("an error occured. "+e.getMessage());
                }
            }
        });

        //Flush data
        producer.flush();
        // flush and close producer
        producer.close();
    }
}
// next: producerWithKey
