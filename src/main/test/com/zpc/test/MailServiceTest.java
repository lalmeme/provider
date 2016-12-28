package com.zpc.test;

import com.zpc.entity.MailEntity;
import com.zpc.mq.MQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zpc on 16/12/28.
 */
@ContextConfiguration(locations = {"classpath:spring-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MailServiceTest {
    @Autowired
    private MQProducer mqProducer;

    @Test
    public void sendMail() {
        MailEntity mail = new MailEntity();
        mail.setTo("690870659@qq.com");
        mail.setSubject("异步发送邮件");
        mail.setContent("Hi,This is a message!");

        this.mqProducer.sendMessage(mail);

        System.out.println("发送成功");
    }
}
