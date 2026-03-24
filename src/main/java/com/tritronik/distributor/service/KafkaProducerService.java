package com.tritronik.distributor.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tritronik.distributor.config.KafkaProperties;
import com.tritronik.distributor.dto.ParsedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void distribute(ParsedEvent event) {
        if (event.getOutput() != null && event.getOutput().contains("parsed_event")) {
            String targetTopic = kafkaProperties.getProducer().getFinalDestination();
            
            String key = event.getImei(); 
            
            log.info("Mendistribusikan data IMEI {} ke {}", key, targetTopic);
            kafkaTemplate.send(targetTopic, key, event);
        } else {
            log.warn("Data dengan IMEI {} tidak memiliki instruksi output 'parsed_event'", event.getImei());
        }
    }
}