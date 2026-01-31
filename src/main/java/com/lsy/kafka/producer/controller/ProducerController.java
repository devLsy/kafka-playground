package com.lsy.kafka.producer.controller;

import com.lsy.kafka.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping
    public ResponseEntity<Void> publish(@RequestParam(name = "topic", defaultValue = "ui-topic") String topic,
                                        @RequestBody String message) {
        producerService.send(topic, message);
        return ResponseEntity.accepted().build();
    }
}
