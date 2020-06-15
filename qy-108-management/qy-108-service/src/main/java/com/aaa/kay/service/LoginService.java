package com.aaa.kay.service;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.mapper.UserMapper;
import com.aaa.kay.model.User;
import com.aaa.kay.redis.RedisService;
import com.aaa.kay.utils.GetIPAndTime;
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
    public static void main(String[] args) {
//        Integer integer = new Integer(9);
////        Integer integer1 =9;
////        int integer2=9;
////        System.out.println(integer.equals(integer1));
////        System.out.println(integer==integer2);
        String ss = "hello_world";
        String[] s = ss.split("_");
        int i = ss.indexOf("_");
        char c = ss.charAt(i);
        StringBuilder result = new StringBuilder().append(s[1]).append(c).append(s[0]);
        System.out.println(result);
    }
/*    @Autowired
    private LoginLogMapper loginLogMapper;*/
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
//                LoginLog loginLog = new LoginLog();
                // 将用户的基本信息放入到session中
//                session.setAttribute("user",u);
                // 将用户的ip 登录时间
                // 放入到日志表中
                // 获取用户的ip
                /*String ip = GetIPAndTime.getIpAddress(request);
                System.out.println("获取到的ip为："+ip);
                // 获取当前时间
                String time = GetIPAndTime.getTime();
                System.out.println("获取到的时间为："+time);
                loginLog.setIp(ip).setLoginTime(time).setUsername(u.getUsername()).setLocation("内网IP|0|0|内网IP|内网IP");
                loginLogMapper.insert(loginLog);*/

                // 登录成功 获取UUID
                String token = IDUtils.getUUID();
                System.out.println("获取到的token值为"+token);
                // 将token放入user对象中
                u.setToken(token);
                String dateTime = GetIPAndTime.getTime();
                u.setLastLoginTime(dateTime);
                System.out.println("此时的user对象中为"+u);
                // 将token放入到user表中
                int updateResult = userMapper.updateByPrimaryKey(u);
                // 4判断数据库是否更新成功
                if (updateResult>0){
                    // 数据库更新成功 放入到redis服务器中
                    // 设置一个失效时间 30分钟
                    String setResult = redisService.set(String.valueOf(u.getUserId()), token, NX, EX, 1800);
                    if ("OK".equals(setResult.toUpperCase())||"1".equals(setResult)){
                        return tokenVo.setIfSuccess(true).setToken(token).setRedisKey(String.valueOf(u.getUserId()));
                    }

                }
            }
        }
        return tokenVo;

    }
}
