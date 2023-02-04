package com.zpb.drools.model;

import lombok.Data;

/**
 * @author       pengbo.zhao
 * @description  业务规则-顶层父类
 * @createDate   2022/8/25 13:59
 * @updateDate   2022/8/25 13:59
 * @version      1.0
 */
@Data
public class BusinessRule {

    /**
     * 规则名
     */
    private String name;

    /**
     * 规则审核原因
     */
    private String cause;


    /**
     * 规则结果
     */
    private boolean result;

}
