package com.zpb.drools.model.insert1;

import com.zpb.drools.model.BusinessRule;
import lombok.*;

/**
 * @author       pengbo.zhao
 * @description  person
 * @createDate   2022/8/22 17:15
 * @updateDate   2022/8/22 17:15
 * @version      1.0
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Person extends BusinessRule {

    private String name;

    private Integer age;

}
