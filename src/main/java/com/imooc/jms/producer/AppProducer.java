package com.imooc.jms.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * Created by Administrator on 2018/5/10.
 */
public class AppProducer {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService  producerServiceImpl = (ProducerService) ctx.getBean("producerService");
        String filePath = "D:\\mytest";
        String fileName = "test.txt";
        producerServiceImpl.sendMessage(filePath + File.separator + fileName);

    }

}
