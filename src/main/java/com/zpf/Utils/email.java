package com.zpf.Utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :发送验证码邮件工具
 * @date :2017/5/8 22:35
 */
public class email {

    public boolean sendEmail(String to,String IC) throws Exception{

        boolean isOk = true;

        // 邮箱账号
        final String userName = "example@163.com";
        // 邮箱授权码
        final String password = "***";
        String fromAddress = "example@163.com";
        String toAddress = to;
        String subject = "忘记密码验证码";
        String content = "您邮箱为: " + to+ "的账号,此次验证码为: "+ IC +".";

        //配置参数
        Properties props = new Properties();
        // 用户密码验证
        props.setProperty("mail.smtp.auth","true");
        // 指定协议
        props.setProperty("mail.transport.protocol","smtp");
        // 主机
        props.setProperty("mail.host","smtp.163.com");

        // 创建会话对象
        Session session = Session.getInstance(props);
        session.setDebug(true);

        // 邮箱对象
        Message message = new MimeMessage(session);
        // 设置收件人
        message.setFrom(new InternetAddress(fromAddress));
        // 设置主题
        message.setSubject(subject);
        // 设置内容
        message.setText(content);

        // 主题
        Transport transport = session.getTransport();
        transport.connect(userName,password);
        transport.sendMessage(message,new InternetAddress[]{ new InternetAddress(toAddress)});
        transport.close();

        return isOk;
    }
}
