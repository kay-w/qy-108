package com.aaa.kay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName ApplicationRun6082
 * @Description: TODO
 * @Author 59983
 * @Date 2020/6/4
 * @Version V1.0
 **/
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class,
        //DataSourceAutoConfiguration.class
})
@MapperScan("com.aaa.kay.mapper")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ApplicationRun6082 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6082.class,args);
    }
}
