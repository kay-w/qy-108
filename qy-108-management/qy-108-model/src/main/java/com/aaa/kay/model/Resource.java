package com.aaa.kay.model;

import  com.aaa.kay.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author xyg
 * @Date 23:11 2020\6\3 0003
 * @Param 
 * @return 
 **/
@Table(name = "t_resource")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Resource implements Serializable {


    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源大小
     */
    private Long size;

    /**
     * 资源路径
     */
    private String path;

    /**
     * 资源文件类型
     */
    private String type;

    /**
     * 资源后缀名
     */
    @Column(name = "ext_name")
    private String extName;

    /**
     * 文件业务类型
     */
    @Column(name = "ref_biz_type")
    private String refBizType;

    /**
     * 文件关联编号
     */
    @Column(name = "ref_biz_id")
    private Long refBizId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * 备注
     */
    private String memo;

}