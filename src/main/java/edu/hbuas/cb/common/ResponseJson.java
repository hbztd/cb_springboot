package edu.hbuas.cb.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 18:31
 **/

//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) Jackson 1.9
@JsonInclude(JsonInclude.Include.NON_NULL) // Jackson 2.x
public class ResponseJson<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    private ResponseJson(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ResponseJson(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.status == Const.ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static  ResponseJson createDefaultSuccess(){
        return new ResponseJson(Const.ResponseCode.SUCCESS.getCode(), Const.ResponseCode.SUCCESS.getDesc());
    }

    public static  ResponseJson createSuccessNoData(String msg){
        return new ResponseJson(Const.ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ResponseJson createSuccessWithData(String msg, T data){
        return new ResponseJson<>(Const.ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static  ResponseJson createDefaultError(){
        return new ResponseJson(Const.ResponseCode.ERROR.getCode(), Const.ResponseCode.SUCCESS.getDesc());
    }

    public static  ResponseJson createErrorNoData(String msg){
        return new ResponseJson(Const.ResponseCode.ERROR.getCode(), msg);
    }

    public static <T> ResponseJson createErrorWithData(String msg, T data){
        return new ResponseJson<>(Const.ResponseCode.ERROR.getCode(), msg, data);
    }
}
