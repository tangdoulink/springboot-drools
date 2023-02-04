package com.zpb.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author       pengbo.zhao
 * @description  规则引擎
 * @createDate   2022/8/23 16:31
 * @updateDate   2022/8/23 16:31
 * @version      1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Rule extends BusinessRule {

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 当前值
     */
    private Integer currentValue;

    /**
     * 规则值
     */
    private Integer ruleValue;

}
