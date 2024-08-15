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
public class PayMicrometerController {
    //=========Micrometer 链路追踪的例子
    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id) {
        return "Hello, micrometer! inputId:  " + id + " \t " + IdUtil.simpleUUID();
    }
}
