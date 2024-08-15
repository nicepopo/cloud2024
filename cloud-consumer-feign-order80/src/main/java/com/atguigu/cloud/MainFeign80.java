package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/7/15 17:29
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //表示开启openfeign功能并激活
public class MainFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(MainFeign80.class,args);
        System.out.println("Hello feign80!");
    }
}