package com.tempo.challenge.calculation_service.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.math.BigDecimal;

@Configuration
public class RedisConfig {

    @Bean
    public ReactiveRedisTemplate<String, BigDecimal> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        RedisSerializationContext.RedisSerializationContextBuilder<String, BigDecimal> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, BigDecimal> context = builder
                .value(new org.springframework.data.redis.serializer.GenericToStringSerializer<>(BigDecimal.class))
                .build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
