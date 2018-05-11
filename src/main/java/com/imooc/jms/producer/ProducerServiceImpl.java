package com.imooc.jms.producer;

import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.BlobMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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


        jmsTemplate.send(destination, new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {

                File file = new File("D:\\wbz.jpeg");
                ObjectMessage objectMessage = session.createObjectMessage(file);
                objectMessage.setStringProperty("FILE.NAME", file.getName()); //文件名称
                objectMessage.setLongProperty("FILE.LENGTH", file.length()); //文件长度

                return objectMessage;

            }
        });
    }
}
