package com.imooc.jms.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/5/11.
 */
public class AppConsumer {

    public static void main(String[] args) {
        //加载监听
        new ClassPathXmlApplicationContext("consumer.xml");
    }

}
