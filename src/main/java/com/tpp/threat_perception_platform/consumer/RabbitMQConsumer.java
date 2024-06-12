package com.tpp.threat_perception_platform.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.tpp.threat_perception_platform.pojo.Account;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.service.AccountService;
import com.tpp.threat_perception_platform.service.HostService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class RabbitMQConsumer {
    @Autowired
    private HostService hostService;

    @Autowired
    private AccountService accountService;

    /**
     * 消费者，消费系统信息
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = "sysinfo_queue")
    public void receive(String message, @Headers Map<String,Object> headers,
                        Channel channel) throws IOException {
        System.out.println("接收到消息: " + message);
        // 将数据存储到数据库
        Host host = JSON.parseObject(message, Host.class);
        // 存储到数据库
        int res = hostService.save(host);
        // 手动签收消息
        if (res > 0) {
            // 手动 ACK, 先获取 deliveryTag
            Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
            channel.basicAck(deliveryTag, false);
        }
    }

    /**
     * 接收主机心跳消息并更新
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = {"status_queue"})
    public void status(String message, @Headers Map<String,Object> headers,
                        Channel channel) throws IOException {
        System.out.println("接收到消息: " + message);
        // 将数据存储到数据库
        Host host = JSON.parseObject(message, Host.class);
        // 存储到数据库
        int res = hostService.updateByMac(host);
        // 手动签收消息
        // 手动 ACK, 先获取 deliveryTag
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = {"account_queue"})
    public void account(String message, @Headers Map<String,Object> headers,
                        Channel channel) throws IOException {
        System.out.println("接收到消息: " + message);
        // 存储到数据库
        List<Account> accountList = JSON.parseArray(message, Account.class);
        int res = accountService.add(accountList);
        //这里在python中设置了不用主动ack
        // 手动签收消息
        // 手动 ACK, 先获取 deliveryTag
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);
    }
}
