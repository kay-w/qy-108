package com.aaa.kay.mapper;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.model.User;
import com.aaa.kay.redis.RedisService;
import com.aaa.kay.utils.IDUtils;
import com.aaa.kay.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.aaa.kay.staticstatus.RedisProperties.*;
/**
 * @ClassName LoginService
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/16
 * @Version V1.0
 **/
@Service
public class LoginService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;
    public TokenVo doLogin(User user, RedisService redisService){
        TokenVo tokenVo = new TokenVo();
        tokenVo.setIfSuccess(false);// 此时的token没有放入值 false
        // 1判断 前端用户的的账号密码是否为空
        if (null !=user){
            // 如果不为空 执行
            // 2验证用户的账号密码是否正确
            User u = userMapper.selectOne(user);
            // 3 判断查到的是否为空
            if (null!=u){
                // 登录成功 获取UUID
                String token = IDUtils.getUUID();
                // 将token放入user对象中
                u.setToken(token);
                // 将token放入到user表中
                int updateResult = userMapper.updateByPrimaryKey(u);
                // 4判断数据库是否更新成功
                if (updateResult>0){
                    // 数据库更新成功 放入到redis服务器中
                    // 设置一个失效时间 30分钟
                    String setResult = redisService.set(String.valueOf(u.getId()), token, XX, EX, 1800);
                    if ("Ok".equals(setResult.toUpperCase())||"1".equals(setResult)){
                        return tokenVo.setIfSuccess(true).setToken(token).setRedisKey(String.valueOf(u.getId()));
                    }
                }
            }
        }
        return tokenVo;

    }
}
