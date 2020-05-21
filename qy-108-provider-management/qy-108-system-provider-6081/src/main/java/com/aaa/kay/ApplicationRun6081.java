package com.aaa.kay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @ClassName ApplicationRun6081
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/12
 * @Version V1.0
 **/
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class
})
@MapperScan("com.aaa.kay.mapper")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ApplicationRun6081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6081.class,args);
    }
}
