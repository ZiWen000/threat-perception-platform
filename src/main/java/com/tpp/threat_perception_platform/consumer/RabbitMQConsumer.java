package com.tpp.threat_perception_platform.consumer;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.log.Log;
import com.rabbitmq.client.Channel;
import com.tpp.threat_perception_platform.pojo.*;
import com.tpp.threat_perception_platform.pojo.Process;
import com.tpp.threat_perception_platform.service.*;
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
    @Autowired
    private ProcessService processService;
    @Autowired
    private AppService appService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private HotfixService hotfixService;
    @Autowired
    private HostVulService hostVulService;
    @Autowired
    private WeakPwdService weakPwdService;
    @Autowired
    private LogsService logsService;

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

    /**
     * 接收账号探测信息
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = {"account_queue"})
    public void account(String message, @Headers Map<String,Object> headers,
                        Channel channel) throws IOException {
        System.out.println("接收到消息: " + message);
        // 存储到数据库
        List<Account> accountList = JSON.parseArray(message, Account.class);
        int res = accountService.add(accountList);
        // 手动签收消息
        // 手动 ACK, 先获取 deliveryTag
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);
    }

    /**
     * 接收进程探测消息
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = {"process_queue"})
    public void process(String message, @Headers Map<String,Object> headers,
                        Channel channel) throws IOException {
        System.out.println("接收到消息: " + message);
        // 存储到数据库
        List<Process> processList = JSON.parseArray(message, Process.class);
        int res = processService.add(processList);
        // 手动签收消息
        // 手动 ACK, 先获取 deliveryTag
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);
    }

    /**
     * 接收应用探测消息
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = {"app_queue"})
    public void app(String message, @Headers Map<String,Object> headers,
                        Channel channel) throws IOException {
        System.out.println("接收到消息: " + message);
        // 存储到数据库
        List<App> appList = JSON.parseArray(message, App.class);
        System.out.println(appList);
        int res = appService.add(appList);
        // 手动签收消息
        // 手动 ACK, 先获取 deliveryTag
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);
    }

    /**
     * 接收服务探测信息
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = {"service_queue"})
    public void service(String message, @Headers Map<String,Object> headers,
                        Channel channel) throws IOException {
        System.out.println("接收到消息: " + message);
        // 存储到数据库
        List<Service> serviceList = JSON.parseArray(message, Service.class);
        int res = serviceService.add(serviceList);
        // 手动签收消息
        // 手动 ACK, 先获取 deliveryTag
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);
    }

    /**
     * 接收补丁探测信息
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = {"hotfix_queue"})
    public void hotfix(String message, @Headers Map<String,Object> headers,
                        Channel channel) throws IOException {
        System.out.println("接收到消息: " + message);
        // 存储到数据库
        List<Hotfix> hotfixList = JSON.parseArray(message, Hotfix.class);
        int res = hotfixService.add(hotfixList);
        // 手动签收消息
        // 手动 ACK, 先获取 deliveryTag
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);
    }

    /**
     * 接收主机漏洞信息
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = {"vul_queue"})
    public void hostVul(String message, @Headers Map<String,Object> headers,
                       Channel channel) throws IOException {
        System.out.println("接收到消息: " + message);
        // 存储到数据库
        List<HostVul> hostVulList = JSON.parseArray(message, HostVul.class);
        int res = hostVulService.add(hostVulList);
        // 手动签收消息
        // 手动 ACK, 先获取 deliveryTag
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);
    }

    /**
     * 接收弱口令探测信息
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = {"weakPwd_queue"})
    public void weakPwd(String message, @Headers Map<String,Object> headers,
                        Channel channel) throws IOException {
        System.out.println("接收到消息: " + message);
        // 存储到数据库
        List<WeakPwd> weakPwdList = JSON.parseArray(message, WeakPwd.class);
        int res = weakPwdService.add(weakPwdList);
        // 手动签收消息
        // 手动 ACK, 先获取 deliveryTag
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);
    }

    /**
     * 接收系统日志信息
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = {"logs_queue"})
    public void logs(String message, @Headers Map<String,Object> headers,
                        Channel channel) throws IOException {
        System.out.println("接收到消息: " + message);
        // 存储到数据库
        List<Logs> logsList = JSON.parseArray(message, Logs.class);
        int res = logsService.add(logsList);
        // 手动签收消息
        // 手动 ACK, 先获取 deliveryTag
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);
    }
}
