package com.tpp.threat_perception_platform.service;

public interface RabbitmqService {
    /**
     * 动态创建队列
     * @param exchange ：需要绑定的交换机
     * @param queueName ：队列名称
     * @param routingKey ：路由键
     */
    void createAgentQueue(String exchange,String queueName,String routingKey);

    /**
     * 发送消息的方法
     * @param exchange ： 交换机
     * @param routingKey ： 路由键
     * @param message ： 数据
     */
    void sendMessage(String exchange,String routingKey,String message);
}
