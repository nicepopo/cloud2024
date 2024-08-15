package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/7/31 9:48
 */
@SpringBootApplication
@EnableDiscoveryClient //服务注册与发现
public class Main9527 {
    public static void main(String[] args) {
        SpringApplication.run(Main9527.class,args);
        System.out.println("网关启动!");
    }
}