package com.lsy.kafka.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void send(String topic, String message) {
        try {
            String json = objectMapper.writeValueAsString(message);
            kafkaTemplate.send(topic, json);
        } catch(JsonProcessingException json) {
            throw new IllegalArgumentException("EventMessage JSON serialize failed", json);
        }
    }
}
