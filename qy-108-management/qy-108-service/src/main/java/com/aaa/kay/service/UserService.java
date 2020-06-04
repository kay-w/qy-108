package com.aaa.kay.service;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.model.User;

import org.springframework.stereotype.Service;



/**
 * @Author: York
 * @Date: 2020/5/29 0029  21:58
 * @Version:1.0
 * @Description: UserService用户的实现层
 */
@Service
public class UserService extends BaseService<User> {

    /*@Autowired
    private UserMapper userMapper;*/

   /* public Boolean addUser(User user){
        //获取时间
        Date date = new Date();
        //定义时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date);
        //获取前端数据

        User user1 = user.setUsername(user.getUsername())
                .setDeptId(user.getDeptId())
                .setStatus(user.getStatus());
        //判断user是否为空
        //如果user为空 返回错误
        if ("".equals(user1)&&user1==null){
            return false;
        }else {
            //从前端拿到数据
            int insert = userMapper.insert(user1);
            //判断我是否插入成功
            //添加数据成功 返回true
            if (insert>0){
                return true;
            }
            else{
                return false;
            }
        }
    }*/
}
