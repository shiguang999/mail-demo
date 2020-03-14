package com.example.demo.util;

public class BackMessage {
    private Integer code;

    private String msg;

    private Object data;

    public static BackMessage success(BackCommonsEnum backEnum){
        return new BackMessage(backEnum.getCode(),backEnum.getMsg());
    }

    public static BackMessage error(BackCommonsEnum backEnum){
        return new BackMessage(backEnum.getCode(),backEnum.getMsg());
    }

    public static BackMessage success(){
        return new BackMessage(200,"成功");
    }

    public static BackMessage success(Object data){
        return new BackMessage(200,"成功",data);
    }

    public static BackMessage error(){
        return new BackMessage(500,"失败");
    }


    private BackMessage(){

    }

    private BackMessage(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private BackMessage(Integer code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}