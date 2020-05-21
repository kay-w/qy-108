package com.aaa.kay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;

@Table(name = "t_login_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LoginLog {
    // 账号
    private String username;
    // 登录时间
    private String loginTime;
    // 登录ip地址
    private String location;
    // 登录ip
    private String ip;

}