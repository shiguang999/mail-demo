package com.example.demo.util;

public enum BackCommonsEnum {
    SUCCESS(200,"成功"),
    ERROR(500,"失败"),

    LOGIN_USER_SUCCESS(200,"登录成功！"),
    LOGIN_ISNOT_USERNAMEORPWD(50001,"用户名或者密码不能为空！"),
    LOGIN_USER_ERROR(50002,"用户名不存在，请注册！"),
    LOGIN_PWD_ERROR(50003,"密码错误！"),
    LOGIN_STATUS(50004,"账号已被锁定，请明天登录！"),
    LOGIN_CODE_ERROR(50006,"验证码错误！"),
    LOGIN_PHONECODE_ERROR(50007,"短信验证码错误！"),
    LOGIN_MAILCODE_ERROR(50008,"邮件验证码错误！");

    private Integer code;

    private String msg;

    private BackCommonsEnum(){

    }

    private BackCommonsEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}