package com.aaa.kay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName MappingProject
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/25
 * @Version V1.0
 **/
@Table(name = "t_mapping_project")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MappingProject {
    // 项目id
    private Long id;
    // 项目类型
    private String projectType;
    // 项目名称
    private String projectName;
    // 项目金额
    private Double projectAmount;
    // 项目负责人
    private String projectLeader;
    // 项目开工日期
    private Date startDate;
    // 项目完工日期
    private Date endDate;
    // 项目完成日期
    private String completeTime;
    // 项目验收机构
    private String acceptanceDepartment;
    // 验收报告文号
    private String acceptanceReport;
    // 任务来源
    private String taskSource;
    // 项目面积
    private Double projectArea;
    // 比例尺
    private String scale;
    // 图幅数据
    private String sheetNumber;
    // 颁奖单位
    private String awardsDepartment;
    // 获奖类型等级
    private String prizeLevel;
    // 项目质量认证
    private String projectQualityApproval;
    // 获奖时间
    private Date winningTime;
    // 验收时间
    private Date acceptanceTime;
    // 基本内容
    private String basicContent;
    // 履约情况
    private String creditStatus;
    // 向测绘主管部门汇交成果情况
    private String submitStatus;
    //单位用户编号
    private Long userId;
    // 进度 百分比
    private Integer schedule;
    // 创建时间
    private Date createTime;
    // 更改时间
    private Date modifyTime;
    // 备注
    private String memo;
    // 项目运行状态 2 未完成 3 已完成
    private Integer status;
    // 项目审核成果 0 通过 1 未提交 2 已提交 3 未提交
    private Integer auditStatus;
    // 项目审核结果 0通过 1 未通过 2 已提交 3 未提交
    private Integer resultsStatus;
    // 中央子午线
    private String meridian;
    // 坐标系
    private String coordinateSystem;
    // 管理级别
    private String managementLevel;
    // 资金来源
    private String fundingSource;
    // 委托单位
    private String entrustUnit;
    // 城建单位
    private String acceptUnit;
    // 手机号码
    private String mobilePhone;
    // 固定电话
    private String phone;
    // 项目所在地
    private String address;
    // 项目中心点
    private String centerPoint;
    // 同步状态 0已同步 1 未同步
    private Integer synchronizationStatus;
    // 创建时间
    private Date contractTime;
    // 坐标
    private String coordinate;
}
