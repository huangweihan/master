package com.han.utils.sms.tool;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;
import java.io.IOException;

// 互亿无线短信服务
@Component
public class SmsUtils2 {

    public void sendSms(String phone, int checkCode){
        HttpClient client = new HttpClient();
        String url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
        PostMethod method = new PostMethod(url);

        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

        String content = new String("您的验证码是：" + checkCode + "。请不要把验证码泄露给其他人。");

        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "C66781798"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
                new NameValuePair("password", "5ac1274e9af0570e105743653bf9affc  "),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", phone),
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);

        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");

            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if("2".equals(code)){
                System.out.println("短信提交成功");
            }

        } catch (IOException | DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
