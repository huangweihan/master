package com.han;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.han.utils.mail.pojo.Mail;
import com.han.utils.mail.tool.MailUtils;
import com.han.utils.sms.config.SmsProperties;
import com.han.utils.sms.tool.SmsUtils;
import com.han.utils.sms.tool.SmsUtils2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;

@SpringBootTest
class JokerApplicationTests {

    @Resource
    private SmsUtils smsUtils;
    @Resource
    private SmsProperties smsProperties;
    @Resource
    private SmsUtils2 smsUtils2;
    @Resource
    private MailUtils mailUtils;

    // 阿里短信
    @Test
    void contextLoads() throws ClientException {
        String phone = "15359777902";
        String code = "123456";
        // 发送消息
        SendSmsResponse resp = this.smsUtils.sendSms(phone, code,
                "陌路逢",
                smsProperties.getVerifyCodeTemplate());
        System.out.println("------------------------");
        System.out.println("resp.getCode() = " + resp.getCode());
        System.out.println("resp.getMessage() = " + resp.getMessage());
        System.out.println("resp.getBizId() = " + resp.getBizId());
        System.out.println("resp.getRequestId() = " + resp.getRequestId());
    }

    // 互亿无线
    @Test
    void sendSms(){
        smsUtils2.sendSms("13666949364", 666666);
    }

    @Test
    public void sendMail(){
        Mail mail = new Mail();
        mail.setFrom("75746540@qq.com");
        mail.setTo("1606571441@qq.com");
        mail.setSubject("标题");
        mail.setContent("内容");
        mail.setFile(new File("C:\\Users\\75746\\Desktop\\work\\学习整理\\demo\\Joker\\src\\main\\resources\\data\\img\\load.jpg"));
        mailUtils.sendMail(mail);
    }
}
