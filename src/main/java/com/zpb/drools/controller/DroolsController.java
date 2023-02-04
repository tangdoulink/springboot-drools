package com.zpb.drools.controller;

import com.zpb.drools.model.Rule;
import com.zpb.drools.model.Subject2;
import com.zpb.drools.model.insert1.Person;
import com.zpb.drools.response.Result;
import com.zpb.drools.service.DroolsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author       pengbo.zhao
 * @description  
 * @createDate   2022/8/22 17:21
 * @updateDate   2022/8/22 17:21
 * @version      1.0
 */
@RestController
public class DroolsController {

    @Resource
    private DroolsService droolsService;

    @GetMapping("d")
    public String droolsAction(){
        return LocalDateTime.now().toString();
    }

    @GetMapping("index")
    public String localDateTime(){
        return LocalDateTime.now().toString();
    }

    @PostMapping("r")
    public Result<Boolean> rule(@RequestBody Rule rule){
        return droolsService.ruleHandler(rule, "rule");
    }

    @PostMapping("s2")
    public Result<Boolean> subject(@RequestBody Subject2 subject2){
        return droolsService.ruleHandler(subject2, "subject_2");
    }

    @PostMapping("p")
    public Result<Boolean> person(@RequestBody Person person){
        return droolsService.ruleHandler(person, "logicalRule1");
    }


}
