package com.example.demo.send;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class SendsmsDemo {

    private static String Url = "https://api.netease.im/sms/sendcode.action";                //直接将示例代码中的URL 拿过来用就行。

    public static String sendSms(String sendMsg ,String phone) {

        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);

        client.getParams().setContentCharset("utf-8");
        method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=utf-8");

        //提交短信
        NameValuePair[] data = {

                //  name 和 password 需要自行修改。
                new NameValuePair("account", "C51843367"), //查看用户名                是登录用户中心->验证码短信->产品总览->APIID
                new NameValuePair("password", "4839f1a37f6e5240109e6bf1cc8fd647"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                new NameValuePair("mobile", phone),
                new NameValuePair("authCode", sendMsg),
        };
        method.setRequestBody(data);

        try {
            client.executeMethod(method);

            String SubmitResult = method.getResponseBodyAsString();

            System.out.println(SubmitResult);

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("obj");

            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if ("200".equals(code)) {
                System.out.println("短信提交成功");
                return sendMsg;
            } else return "";

        } catch (Exception e) {
            e.printStackTrace();
            return "";

        }
    }
}