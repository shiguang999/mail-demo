//package com.example.demo.send;
//
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//
///**
// * 一、登录这个网站，注册登录。    http://www.ihuyi.com/product.php  可以免费使用10次。
// *
// *
// *二、找到他的代码示例。在下面会有图片说明
// *
// *
// *三、根据自己的需要，可以对示例代码进行修改。下面的代码是来自于对            https://blog.csdn.net/qq_17025903/article/details/73331091  的编辑。
// *
// *
// *四、jar包管理。
// *     1. 点击他的接口下载，里面提供的有jar包。
// *     2.maven项目需要直接去搜索
// *
// *     <dependencies>
// *     <!-- https://mvnrepository.com/artifact/commons-codec/commons-codec -->
// *     <dependency>
// *         <groupId>commons-codec</groupId>
// *         <artifactId>commons-codec</artifactId>
// *         <version>1.3</version>
// *     </dependency>
// *
// *
// *     <!-- https://mvnrepository.com/artifact/dom4j/dom4j -->
// *     <dependency>
// *         <groupId>dom4j</groupId>
// *         <artifactId>dom4j</artifactId>
// *         <version>1.6.1</version>
// *     </dependency>
// *
// *
// *
// *     <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient -->
// *     <dependency>
// *         <groupId>org.apache.httpcomponents</groupId>
// *         <artifactId>httpclient</artifactId>
// *         <version>4.5.6</version>
// *     </dependency>
// *
// *     <!-- https://mvnrepository.com/artifact/commons-httpclient/commons-httpclient -->
// *     <dependency>
// *         <groupId>commons-httpclient</groupId>
// *         <artifactId>commons-httpclient</artifactId>
// *         <version>3.0-rc4</version>                                        我的这个jar包导不进来，maven项目没有搞定。
// *     </dependency>
// *
// *
// */
//
//public class SendsmsDemo {
//
//    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";                //直接将示例代码中的URL 拿过来用就行。
//
//    public static int sendSms(String phone) {
//
//        HttpClient client = new HttpClient();
//        PostMethod method = new PostMethod(Url);
//
//        client.getParams().setContentCharset("GBK");
//        method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=GBK");
//
//        int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);
//
//        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
//
//        //提交短信
//        NameValuePair[] data = {
//
//                //  name 和 password 需要自行修改。
//                new NameValuePair("account", "C51843367"), //查看用户名                是登录用户中心->验证码短信->产品总览->APIID
//                new NameValuePair("password", "4839f1a37f6e5240109e6bf1cc8fd647"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
//                new NameValuePair("mobile", phone),
//                new NameValuePair("content", content),
//        };
//        method.setRequestBody(data);
//
//        try {
//            client.executeMethod(method);
//
//            String SubmitResult = method.getResponseBodyAsString();
//
//            System.out.println(SubmitResult);
//
//            Document doc = DocumentHelper.parseText(SubmitResult);
//            Element root = doc.getRootElement();
//
//            String code = root.elementText("code");
//            String msg = root.elementText("msg");
//            String smsid = root.elementText("smsid");
//
//            System.out.println(code);
//            System.out.println(msg);
//            System.out.println(smsid);
//
//            if ("2".equals(code)) {
//                System.out.println("短信提交成功");
//
//                return mobile_code;  //验证码
//            } else return 0;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//
//        }
//    }
//}