package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/7/17 15:26
 */
@RestController
public class PayCircuitController
{
    //=========Resilience4j CircuitBreaker 的例子
    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id)
    {
        try {
            TimeUnit.SECONDS.sleep(11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(id == -4) throw new RuntimeException("----circuit id 不能负数");
        if(id == 9999){
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        return "Hello, circuit! inputId:  "+id+" \t " + IdUtil.simpleUUID();
    }
}
