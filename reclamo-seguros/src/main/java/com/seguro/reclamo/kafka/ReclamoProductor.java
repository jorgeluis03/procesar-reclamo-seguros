package com.seguro.reclamo.kafka;

import com.seguro.reclamo.modelo.Reclamo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReclamoProductor {
    private final KafkaTemplate<String, Reclamo> kafkaTemplate;

    @Value("${spring.kafka.topic.reclamos}")
    private String topicReclamos;

    public ReclamoProductor(KafkaTemplate<String, Reclamo> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarReclamo(Reclamo reclamo) {
        kafkaTemplate.send(topicReclamos,reclamo);
        System.out.println("📤 Reclamo enviado a Kafka: " + reclamo);
    }
}
