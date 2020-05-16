package com.aaa.kay.redis;

import com.aaa.kay.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;
import static com.aaa.kay.staticstatus.RedisProperties.*;

/**
 * @ClassName RedisService
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/16
 * @Version V1.0
 **/
@Service
public class RedisService<T> {
    @Autowired
    private JedisCluster jedisCluster;
    /**
     * @MethodName: set
     * @Description: 向redis中保存数据设置失效时间
     *               key redis中的key
     *               value 向redis中保存的数据
     *               nxxx 这里的值是固定的 你先
     *                “nx" 如果redis中的key不存在 则可以存数据
     *                “xx" 如果redis中的key存在 则才可以存储数据
     *                    expx 时间的 单位
     *                     ex de 失效时间 shi 秒
     *                     px px的失效时间单位是毫秒
     *                 seconds 失效时间如果没有 则表示不设置失效时间
     * @Param: [key, value, nxxx, expx, seconds]
     * @Return: java.lang.String
     * @Author: 59983
     * @Date: 2020/5/16
    **/
    public  String set(String key, T value, String nxxx, String expx, Integer seconds) {
        if(null != seconds && 0 < seconds && (NX.equals(nxxx) || XX.equals(nxxx)) && (EX.equals(expx) || PX.equals(expx))) {
            // 说明需要设置失效时间
            return jedisCluster.set(key, JSONUtil.toJsonString(value), nxxx, expx, seconds);
        } else {
            // 说明不需要设置失效时间
            // 就算不需要失效时间，但是我也得知道最终你所传递的是nx还是xx，所以需要再次判断
            if(NX.equals(nxxx)) {
                return String.valueOf(jedisCluster.setnx(key, JSONUtil.toJsonString(value)));
            } else if(XX.equals(nxxx)) {
                return jedisCluster.set(key, JSONUtil.toJsonString(value));
            }
        }
        return NO;
    }
}
