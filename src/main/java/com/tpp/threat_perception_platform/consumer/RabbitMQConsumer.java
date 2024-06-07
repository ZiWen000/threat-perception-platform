package com.tpp.threat_perception_platform.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.service.HostService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Map;

@Component
public class RabbitMQConsumer {
    @Autowired
    private HostService hostService;

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
}
