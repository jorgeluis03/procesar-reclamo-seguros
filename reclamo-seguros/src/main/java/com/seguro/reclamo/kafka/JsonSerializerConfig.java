package com.seguro.reclamo.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class JsonSerializerConfig {
    @Bean
    public JsonSerializer<Object> jsonSerializer() {
        return new JsonSerializer<>();
    }
}
