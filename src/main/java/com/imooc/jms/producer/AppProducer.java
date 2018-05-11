package com.imooc.jms.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/5/10.
 */
public class AppProducer {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService  producerServiceImpl = (ProducerService) ctx.getBean("producerService");
//        for (int i=0; i<10; i++) {
//            producerServiceImpl.sendMessage("test");
//        }

        producerServiceImpl.sendMessage("一段测试消息");

    }

}
