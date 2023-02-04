package com.zpb.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author       pengbo.zhao
 * @description  科目二
 * @createDate   2022/8/25 11:38
 * @updateDate   2022/8/25 11:38
 * @version      1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Subject2 extends BusinessRule {

    /**
     * 课目一是否完成
     */
    private boolean subject1;

    /**
     * 课时
     */
    private int schoolHours;

    /**
     * 间隔天数
     */
    private int intervalDays;

    /**
     * 审核结果
     */
    public boolean valid;

}
