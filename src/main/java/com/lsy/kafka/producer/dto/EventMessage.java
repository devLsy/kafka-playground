package com.lsy.kafka.producer.dto;


public record EventMessage(
    String eventType,
    String payload,
    long occurredAt
) {}
