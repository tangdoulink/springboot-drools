package com.zpb.drools.response;

/**
 * @author       pengbo.zhao
 * @description  响应枚举-抽象接口
 * @createDate   2022/6/7 23:14
 * @updateDate   2022/6/7 23:14
 * @version      1.0
 */
public interface ResponseEnum {

    /**
     * code
     * @return code
     */
    Integer code();

    /**
     * message
     * @return message
     */
    String message();

}
