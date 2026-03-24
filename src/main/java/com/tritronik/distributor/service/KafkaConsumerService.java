package com.tritronik.distributor.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tritronik.distributor.dto.ParsedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final KafkaProducerService kafkaProducerService;

    @KafkaListener(
        topics = "#{kafkaProperties.consumer.topicParsed}", 
        groupId = "#{kafkaProperties.consumer.groupId}"
    )
    public void consumeParsed(ParsedEvent event) {
        log.info("Distributor menerima data ter-parse dari IMEI: {}", event.getImei());
        
        kafkaProducerService.distribute(event);
    }

    @KafkaListener(
        topics = "#{kafkaProperties.consumer.topicRaw}", 
        groupId = "#{kafkaProperties.consumer.groupId}"
    )
    public void consumeRaw(String rawData) {
        log.warn("Distributor menerima data mentah (fail-parse): {}", rawData);
    }
}