package com.imooc.jms.consumer;

import javax.jms.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 消息监听容器
 * Created by Administrator on 2018/5/11.
 */
public class ConsumerMessageListener implements MessageListener{

    //接收到消息后
    @Override
    public void onMessage(Message message) {

        try {
            TextMessage textMessagesage = (TextMessage) message;
            String text = textMessagesage.getText();
            System.out.println(text);
        } catch (JMSException e) {
            e.printStackTrace();
        }

//        ObjectMessage objectMessage = (ObjectMessage) message;
//        try {
//            File file = (File) objectMessage.getObject();
//            System.out.println(file.getName());
//
//            FileInputStream fis = new FileInputStream(file);
//            FileOutputStream fos = new FileOutputStream(new File("E:\\" + file.getName()));
//            byte[] b = new byte[1024];
//            int len;
//            while ( (len = fis.read(b)) != - 1){
//                fos.write(b, 0, len);
//            }
//
//            fos.close();;
//            fis.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
