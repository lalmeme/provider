package com.zpc.mq;

import com.alibaba.fastjson.JSONObject;
import com.zpc.entity.MailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by zpc on 16/12/28.
 */
@Service("mqProducer")
public class MQProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * <B>方法名称：</B>发送邮件信息对象<BR>
     * <B>概要说明：</B>发送邮件信息对象<BR>
     * @param mail
     */
    public void sendMessage(final MailEntity mail) {
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(JSONObject.toJSONString(mail));
            }
        });
    }
}
