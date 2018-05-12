package com.imooc.jms.consumer;

import com.imooc.jms.util.Tools;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * 消息监听容器
 * Created by Administrator on 2018/5/11.
 */
public class ConsumerMessageListener implements MessageListener{

    //接收到消息后
    @Override
    public void onMessage(Message message) {

        try {
            //将接收到的消息强转为ObjectMessage类型
            ObjectMessage objectMessage = (ObjectMessage) message;
            System.out.println("接收到了文件:" + objectMessage.getStringProperty("FILE.NAME") + "...文件大小:" + objectMessage.getStringProperty("FILE.LENGTH"));

            String tempPath = "C:\\mytest";
//            File file = new File(tempPath);
//            if(!file.exists() || !file.isDirectory()){
//                file.mkdirs();
//            }
            byte[] bytes = (byte[]) objectMessage.getObject();
            //将文件存放到C:/mytest路径下
            Tools.getFile(bytes, tempPath ,objectMessage.getStringProperty("FILE.NAME"));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
