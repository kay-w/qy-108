package com.aaa.kay.config;


import com.aaa.kay.properties.RedisClusterProperties;
import io.netty.util.HashingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName RedisClusterConfig
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/14
 * @Version V1.0
 **/
@Configuration
public class RedisClusterConfig {
    @Autowired
    private RedisClusterProperties redisClusterProperties;
    /**
     * @MethodName: getJedisCluster
     * @Description: 注入redis为java提供的API(jedisCLuster)
     * @Param: []
     * @Return: redis.clients.jedis.JedisCluster
     * @Author: 59983
     * @Date: 2020/5/14
    **/
    @Bean
    public JedisCluster getJedisCluster(){
        // 1 获取redis的IP地址以及端口号信息(192.168.23.166:6380,192.168.23.166:6381...6385)
        String nodes= redisClusterProperties.getModes();
        String[] nodeArr = nodes.split(",");
        Set<HostAndPort> hostAndPortSet = new HashSet();
        for (String node : nodeArr){
            String[] hostport=node.split(":");
            HostAndPort hostAndPort = new HostAndPort(hostport[0],Integer.parseInt(hostport[1]));
            hostAndPortSet.add(hostAndPort);
        }
        JedisCluster jedisCluster = new JedisCluster(hostAndPortSet, redisClusterProperties.getCommandTimeout(), redisClusterProperties.getMaxAttempts());
        return jedisCluster;
    }
}
