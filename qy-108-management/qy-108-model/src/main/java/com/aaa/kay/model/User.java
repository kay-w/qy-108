package com.aaa.kay.model;

import com.aaa.kay.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NegativeOrZero;
import java.io.Serializable;

/**
 * @ClassName User
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/12
 * @Version V1.0
 **/
@Table(name = "t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User extends BaseModel {
    //账号
    private String username;
    //密码
    private String password;
    @Column(name="dept_id")
    // 部门id
    private Long deptId;
    // 邮箱
    private String email;
    // 联系电话
    private String mobile;
    //账号状态
    private String status;
    // 最后一次登录时间
    @Column(name="last_login_time")
    private String lastLoginTime;
    //性别 0男 1女 2 保密
    private String ssex;
    //描述
    private String description;
    // 用户头像
    private String avatar;
    // 用户类型 0 单位用户 1审核用户 2管理员
    private String type;
    // 无状态token
    private String token;

}
