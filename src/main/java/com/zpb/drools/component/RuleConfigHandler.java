package com.zpb.drools.component;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.zpb.drools.constants.DroolsConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author       pengbo.zhao
 * @description  rule-config-handler
 * @createDate   2022/8/23 19:09
 * @updateDate   2022/8/23 19:09
 * @version      1.0
 */
@Slf4j
@Component
public class RuleConfigHandler {

    @NacosInjected
    private com.alibaba.nacos.api.config.ConfigService configService;

    /**
     * 获取规则配置
     * @param dateId 规则名
     * @return 规则内容
     */
    public String getRuleConfig(String dateId){
        try {
            String config = configService.getConfig(dateId, DroolsConstant.RULE_GROUP, DroolsConstant.NACOS_CONFIG_TIMEOUT);
            log.info("==============================");
            log.info(config);
            log.info("==============================");
            return config;
        } catch (NacosException e) {
            e.printStackTrace();
            return null;
        }
    }

}
