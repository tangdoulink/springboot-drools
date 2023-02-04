package com.zpb.drools.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @author       pengbo.zhao
 * @description  返回结果
 * @createDate   2022/5/7 21:36
 * @updateDate   2022/5/7 21:36
 * @version      1.0
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 3626398474579988292L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * traceId
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String traceId;

    /**
     * 返回结果
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    /**
     * 成功码
     */
    public static final int SUCCESS_CODE = 20000;

    /**
     * 成功信息
     */
    public static final String SUCCESS_MESSAGE = "成功";

    /**
     * 失败码
     */
    public static final int FAIL_CODE = 50000;

    /**
     * 失败码
     */
    public static final int PARAMS_FAIL_CODE = 40000;

    /**
     * 失败信息
     */
    public static final String FAIL_MESSAGE = "失败";
    public static final String SERVICE_EXCEPTION_PREFIX = "service";


    private static final String STRING_NULL = null;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg, String traceId, T data) {
        this.code = code;
        this.msg = msg;
        this.traceId = traceId;
        this.data = data;
    }

    public static <T> Result<T> ok(){
        return ok(SUCCESS_CODE,SUCCESS_MESSAGE,null);
    }

    public static <T> Result<T> ok(T data){
        return ok(SUCCESS_CODE,SUCCESS_MESSAGE,data);
    }

    public static <T> Result<T> ok(int code, String msg){
        return ok(code,msg,null);
    }

    public static <T> Result<T> ok(int code, String msg, T data){
        return new Result<>(code,msg,data);
    }

    public static <T> Result<T> fail(){
        return new Result<>(FAIL_CODE, FAIL_MESSAGE, STRING_NULL, null);
    }

    public static <T> Result<T> fail(String traceId){
        return fail(FAIL_CODE,FAIL_MESSAGE,traceId,null);
    }

    public static <T> Result<T> fail(int code, String message){
        return fail(code,message,null,null);
    }

    public static <T> Result<T> fail(String message, String traceId){
        return fail(FAIL_CODE,message,traceId,null);
    }

    public static <T> Result<T> fail(T data){
        return fail(FAIL_CODE,FAIL_MESSAGE,STRING_NULL,data);
    }

    public static <T> Result<T> fail(String traceId, T data){
        return fail(FAIL_CODE,FAIL_MESSAGE,traceId,data);
    }

    public static <T> Result<T> fail(int code, String msg, String traceId){
        return fail(code,msg,traceId, null);
    }

    public static <T> Result<T> fail(int code, String msg, T data){
        return fail(code,msg,null, data);
    }

    public static <T> Result<T> fail(int code, String msg, String traceId, T data){
        return new Result<>(code,msg,traceId,data);
    }

    public static <T> Result<T> fail(ResponseEnum responseCode, String traceId){
        return fail(responseCode.code(),responseCode.message(),traceId,null);
    }

    public static <T> Result<T> exection(ResponseEnum responseCode, String traceId){
        return fail(responseCode.code(),responseCode.message(),traceId,null);
    }

    public static <T> Result<T> exection(Integer code,String message,String traceId){
        return fail(code,message,traceId,null);
    }

    public static <T> Result<T> exection(String message,String traceId){
        return fail(FAIL_CODE,message,traceId,null);
    }

}
