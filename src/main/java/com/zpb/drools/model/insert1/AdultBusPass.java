package com.zpb.drools.model.insert1;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author       pengbo.zhao
 * @description  
 * @createDate   2022/8/26 09:46
 * @updateDate   2022/8/26 09:46
 * @version      1.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
public class AdultBusPass  extends BusPass{

    public AdultBusPass(Person person) {
        super(person);
    }

}
