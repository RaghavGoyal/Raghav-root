package com.rgv.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Consumer {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Consumer.class.getName());
        String bootstrapServer = "localhost:9092";
        String groupId = "javaApplication1";
        String topic = "first-topic";
        List<String> OFFSET_RESET_CONFIG_types = new ArrayList<String>();
        OFFSET_RESET_CONFIG_types.add("earliest"); // means you want to read from the beginning of the topic
        OFFSET_RESET_CONFIG_types.add("latest"); // means you want to read from the new messages onwards
        OFFSET_RESET_CONFIG_types.add("none"); // if no offsets are being saved

        // create consumer properties:
        Properties props = new Properties();
        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // Byte values are to be received by consumer and represented in original form, so Deserializer is set in config
        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OFFSET_RESET_CONFIG_types.get(0));


        // create consumer instance using properties created above:
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // Subscribe consumer to topic(s)
        consumer.subscribe(Collections.singleton(topic));

        // once subscribed to topic(s), you can start reading that will return the consumerRecord Objects as:
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String, String> record : records){
                logger.info("Consumer got the record from: Topic: "+ record.topic() + "key: "+record.key() + "Value: "+record.value());
                System.out.println(
                        "Consumer got the record." +
                        " Topic: "+ record.topic() +
                        " key: "+record.key() +
                        " Value: "+record.value()
                );
            }
        }
    }
}
// next: ConsumerGroup
