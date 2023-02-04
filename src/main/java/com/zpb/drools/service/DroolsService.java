package com.zpb.drools.service;

import com.zpb.drools.component.RuleConfigHandler;
import com.zpb.drools.constants.DroolsConstant;
import com.zpb.drools.model.BusinessRule;
import com.zpb.drools.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.common.DefaultFactHandle;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author       pengbo.zhao
 * @description  drools-service
 * @createDate   2022/8/23 16:25
 * @updateDate   2022/8/23 16:25
 * @version      1.0
 */
@Slf4j
@Service
public class DroolsService {

    @Resource
    private RuleConfigHandler ruleConfigHandler;

    public Result<Boolean> ruleHandler(BusinessRule rule, String drlName){

        // 创建Kie对象
        KieHelper helper = new KieHelper();

        // 获取规则文件
        String ruleConfig = ruleConfigHandler.getRuleConfig(drlName);

        // 设置规则
        helper.addContent(ruleConfig, ResourceType.DRL);

        // 构建KieSession对象
        KieSession kieSession = helper.build().newKieSession();

        // 插入规则数据
        kieSession.insert(rule);

        // 执行规则
        kieSession.fireAllRules();

        // 获取执行引擎结果
        Result<Boolean> result = getResult(kieSession);

        // 关闭资源
        kieSession.dispose();

        // 响应结果
        return result;

    }

    /**
     * 获取执行结果
     * @param kieSession {@link KieSession}
     * @return Result<Boolean>
     */
    public Result<Boolean> getResult(KieSession kieSession){
        List<Result<Boolean>> resultList = new ArrayList<>();
        List<FactHandle> collect = kieSession.getFactHandles().stream()
                .filter(factHandle -> {
                    if (factHandle instanceof DefaultFactHandle) {
                        DefaultFactHandle defaultFactHandle = (DefaultFactHandle) factHandle;
                        String className = defaultFactHandle.getObjectClassName();
                        Object object = defaultFactHandle.getObject();
                        if (DroolsConstant.RESULT_PACKAGE_PATH.equals(className) && object instanceof Result) {
                            resultList.add(result((Result) object));
                            return true;
                        }
                    }
                    return false;
                }).collect(Collectors.toList());

        if(!CollectionUtils.isEmpty(resultList)){
            log.info("[ 执行规则内置对象共 {} 个 ]",collect.size());
            return Result.ok(resultList.get(0).getCode(),resultList.get(0).getMsg(),Boolean.TRUE);
        }
        return Result.fail(resultList.get(0).getCode(),resultList.get(0).getMsg(),Boolean.FALSE);
    }

    public Result<Boolean> result(Result result){
        return  200 == result.getCode() ? Result.ok(result.getCode(),result.getMsg(),Boolean.TRUE) :
                Result.fail(result.getCode(),result.getMsg(),Boolean.FALSE);
    }

}
