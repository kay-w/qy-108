package com.aaa.kay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName ApplicationRun6081
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/18
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.aaa.kay.base"})
public class ApplicationRun8081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8081.class,args);
    }
}
