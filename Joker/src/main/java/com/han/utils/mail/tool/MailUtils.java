package com.han.utils.mail.tool;

import com.han.utils.mail.pojo.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailUtils {

    @Resource
    private JavaMailSender javaMailSender;
    private final Logger LOGGER = LoggerFactory.getLogger(MailUtils.class);

    public void sendMail(Mail mail) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            // 这里使用 MimeMessageHelper 简化了邮件配置
            // 第二个参数true表示构造一个 multipart message 类型邮件
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getContent());
            // 添加附件
            if (mail.getFile() != null && mail.getFile().exists()){
                helper.addAttachment(mail.getFile().getName(), mail.getFile());
            }
            javaMailSender.send(message);
            LOGGER.info("发送邮件成功");
        } catch (MessagingException e) {
            e.printStackTrace();
            LOGGER.error("发送邮件异常");
        }
    }
}
