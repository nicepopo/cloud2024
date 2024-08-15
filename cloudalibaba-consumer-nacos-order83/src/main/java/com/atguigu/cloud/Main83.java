package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/8/5 17:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//表示开启openfeign功能并激活
public class Main83 {
    public static void main(String[] args) {
        SpringApplication.run(Main83.class, args);
        System.out.println("Hello Main83!");
    }
}