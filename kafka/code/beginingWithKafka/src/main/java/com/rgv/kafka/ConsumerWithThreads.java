package com.rgv.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class ConsumerWithThreads {

    public static void main(String[] args) {

        String topic = "first-topic";
        String bootstrapServer = "localhost:9092";
        String groupId = "javaApplication2";
        List<String> OFFSET_RESET_CONFIG_types = new ArrayList<String>();
        OFFSET_RESET_CONFIG_types.add("earliest"); // means you want to read from the beginning of the topic
        OFFSET_RESET_CONFIG_types.add("latest"); // means you want to read from the new messages onwards
        OFFSET_RESET_CONFIG_types.add("none"); // if no offsets are being saved

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Runnable myConsumerThread =
                new ConsumerThread(bootstrapServer, groupId, topic, OFFSET_RESET_CONFIG_types.get(0), countDownLatch);

    }

    public static class ConsumerThread implements Runnable {

        private CountDownLatch latch;
        private KafkaConsumer<String, String> consumer;
        private Logger logger = LoggerFactory.getLogger(ConsumerWithThreads.class.getName());

        public ConsumerThread(String bootstrapServer,
                              String groupId,
                              String topic,
                              String offsetResetConfig,
                              CountDownLatch latch){

            this.latch = latch;

            // create consumer properties:
            Properties props = new Properties();
            props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
            props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            // Byte values are to be received by consumer and represented in original form, so Deserializer is set in config
            props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetResetConfig);

            consumer = new KafkaConsumer<String, String>(props);

        }

        @Override
        public void run() {
            try{
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
            } catch(WakeupException ex){
                logger.error("Received Shutdown Signal...");
            } finally {
                consumer.close();
                // tell our main that we are done with the consumer
                latch.countDown();
            }
        }

        public void shutDown(){
            // wakeup() is a special method to interrupt the consumer.poll()
            // this method throws an exception that is- WakeUpException
            consumer.wakeup();
        }
    }
}
// next: 
