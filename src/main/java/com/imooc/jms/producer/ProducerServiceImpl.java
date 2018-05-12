package com.imooc.jms.producer;

import com.imooc.jms.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.File;

/**
 * Created by Administrator on 2018/5/10.
 */
public class ProducerServiceImpl implements ProducerService{

    @Autowired
    JmsTemplate jmsTemplate;
    @Resource(name="queueDestination")
    Destination destination;

    //发送消息
    public void sendMessage(final String message) {

        //jmsTemplate提供的发送消息方法,指定消息目的地和具体要发送的消息
        jmsTemplate.send(destination, new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {


                //将文件储存到byte[]数组中
                byte[] bytes = Tools.getBytes(message);

                //创建ObjectMessage类型的消息,用于发送任意类型消息
                ObjectMessage objectMessage = session.createObjectMessage(bytes);
                //通过setXXXProperty方法可以向消息中存储信息一起传递, 类似Map,在接收方通过getXXXProperty获取
                objectMessage.setStringProperty("FILE.NAME", new File(message).getName()); //文件名称
                objectMessage.setLongProperty("FILE.LENGTH", new File(message).length()); //文件长度

                //发送消息
                return objectMessage;

            }
        });
    }
}
