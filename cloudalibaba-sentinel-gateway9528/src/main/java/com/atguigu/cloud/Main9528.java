package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/8/7 17:24
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Main9528 {
    public static void main(String[] args) {
        SpringApplication.run(Main9528.class, args);
        System.out.println("Hello Main9528!");
    }
}