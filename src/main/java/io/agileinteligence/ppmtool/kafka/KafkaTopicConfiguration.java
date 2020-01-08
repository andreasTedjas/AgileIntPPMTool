//package io.agileinteligence.ppmtool.kafka;
//
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.KafkaAdmin;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaTopicConfiguration {
//    @Value("${kafka.bootstrapAddress}")
//    private String bootstrapAddress;
//
//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        return new KafkaAdmin(configs);
//    }
//
//    @Bean
//    public Map<String, NewTopic> topic1() {
//        Map<String, NewTopic> newTopic = new HashMap();
//        newTopic.put("1", new NewTopic("topic1", 2, (short) 1));
//        newTopic.put("2", new NewTopic("topic2", 2, (short) 1));
//        newTopic.put("3", new NewTopic("topic3", 2, (short) 1));
//        return newTopic;
//    }
//}
