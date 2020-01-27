package io.agileinteligence.ppmtool.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Value("${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    private String groupId = "foo";

//    @KafkaListener(topics = "topic1, topic2, topic3", groupId = "foo")
//    public void listen(String message) {
//        System.out.println("Received Messasge in group foo: " + message);
//    }

    //    @KafkaListener(topics = "topic1")
//    public void listenWithHeaders(
//            @Payload String message,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        System.out.println("Received Message: " + message + "from partition: " + partition);
//    }
//    @KafkaListener(
//            topicPartitions = @TopicPartition(topic = "topic1",
//                    partitionOffsets = {
//                            @PartitionOffset(partition = "0", initialOffset = "0"),
//                            @PartitionOffset(partition = "1", initialOffset = "0")
//                    }))
//    public void listenToParition(
//            @Payload String message,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        System.out.println(
//                "Received Messasge: " + message
//                        + "from partition: " + partition);
//    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                groupId);
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String>
    kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
