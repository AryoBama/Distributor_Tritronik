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
        private String topicParsed = "parsed_event";
        private String topicRaw = "rawlog";
        private String groupId = "distributor-group";
    }

    @Data
    public static class Producer {
        private String finalDestination = "final_output_topic";
    }
}