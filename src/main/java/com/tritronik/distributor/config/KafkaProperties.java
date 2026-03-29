package com.tritronik.distributor.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {
    private String bootstrapServers;
    private Consumer consumer = new Consumer();
    private Producer producer = new Producer();

    @Data
    public static class Consumer {
        private String topicEvent = "processed_logs";
        private String groupId = "distributor-group";
    }

    @Data
    public static class Producer {
        private String parsedTopic = "parsed_event";
        private String rawLog = "rawlog";
    }
}