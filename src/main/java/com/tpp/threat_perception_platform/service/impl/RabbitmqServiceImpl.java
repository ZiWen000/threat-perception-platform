package com.tpp.threat_perception_platform.service.impl;

import com.tpp.threat_perception_platform.service.RabbitmqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqServiceImpl implements RabbitmqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 创建队列
     * @param exchange ：需要绑定的交换机
     * @param queueName ：队列名称
     * @param routingKey ：路由键
     */
    public void createAgentQueue(String exchange, String queueName, String routingKey) {
        //创建队列
        rabbitTemplate.execute(channel -> {
            //声明队列
            channel.queueDeclare(queueName, true, false, false, null);
            //绑定队列
            channel.queueBind(queueName, exchange, routingKey);
            return null;
        });
    }

    /**
     * 发送消息
     * @param exchange ： 交换机
     * @param routingKey ： 路由键
     * @param message ： 数据
     */
    public void sendMessage(String exchange, String routingKey, String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
