package com.lsy.kafka.producer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UiTopicConsumer {

    @KafkaListener(topics = "ui-topic", groupId = "spring-local")
    public void listen(String  message) {
        log.info("[consumed] {}", message);
    }
}
