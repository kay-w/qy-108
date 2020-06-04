package com.aaa.kay.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName DBProperties
 * @Description: TODO
 * @Author 59983
 * @Date 2020/6/1
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DBProperties implements Serializable {
    private String pollName; // 称之为唯一标识的名字 这个标识来转载mysql,oralce,sqlserver

    private String driverClassName;

    private String url;

    private String username;

    private String password;

    private String type;
}

