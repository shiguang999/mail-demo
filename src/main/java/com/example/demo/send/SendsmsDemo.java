package com.example.demo.send;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SendsmsDemo {

    private static final String SERVER_URL = "https://api.netease.im/sms/sendcode.action";//请求的URL
   /* private static final String APP_KEY = appkey;//网易云分配的账号
    private static final String APP_SECRET = appsecret;//密码*/
    // private static final String MOULD_ID="3057527";//模板ID
//    private static final String NONCE = "123456";//随机数
    //验证码长度，范围4～10，默认为4
    private static final String CODELEN = "6";

    public static boolean sendSms(String sendMsg, String phone, Map<String, String> map) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(SERVER_URL);

        String curTime = String.valueOf((new Date().getTime() / 1000L));
        String checkSum = CheckSumBuilder.getCheckSum(map.get("APP_SECRET"), map.get("NONCE"), curTime);

//设置请求的header
        post.addHeader("AppKey", map.get("APP_KEY"));
        post.addHeader("Nonce", map.get("NONCE"));
        post.addHeader("CurTime", curTime);
        post.addHeader("CheckSum", checkSum);
        post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//设置请求参数
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("mobile", phone));
        nameValuePairs.add(new BasicNameValuePair("authCode", sendMsg));

        post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

//执行请求
        HttpResponse response = httpclient.execute(post);
        String responseEntity = EntityUtils.toString(response.getEntity(), "utf-8");

//判断是否发送成功，发送成功返回true  {"code":200,"msg":"302","obj":"2222"}
        String code = JSON.parseObject(responseEntity).getString("code");
        if (code.equals("200")) {
            return true;
        }
//System.out.println(re);
        return false;
    }

}