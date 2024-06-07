package com.tpp.threat_perception_platform.config;


import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    /**
     * RabbitMQ的模板方法对象
     * @param factory
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory){
        return new RabbitTemplate(factory);
    }
}
