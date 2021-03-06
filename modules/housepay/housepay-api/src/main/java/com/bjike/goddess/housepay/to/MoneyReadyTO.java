package com.bjike.goddess.housepay.to;

import com.bjike.goddess.common.api.entity.ADD;
import com.bjike.goddess.common.api.entity.EDIT;
import com.bjike.goddess.common.api.to.BaseTO;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 资金准备审核表
 *
 * @Author: [ xiazhili ]
 * @Date: [ 2017-05-12 05:32 ]
 * @Description: [ 资金准备审核表 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class MoneyReadyTO extends BaseTO {
    /**
     * 年份
     */
    @NotNull(message = "年份不能为空")
    @Min(value = 0, groups = {ADD.class, EDIT.class}, message = "年份必须大于0")
    private Integer year;

    /**
     * 月份
     */
    @NotNull(groups = {ADD.class, EDIT.class}, message = "月份不能为空")
    @Min(value = 1, groups = {ADD.class, EDIT.class}, message = "月份必须大于等于1")
    @Max(value = 12, groups = {ADD.class, EDIT.class}, message = "月份必须小于等于12")
    private Integer month;

    /**
     * 类别
     */
    @NotBlank(message = "类别不能为空")
    private String category;

    /**
     * 科目
     */
    @NotBlank(message = "科目不能为空")
    private String subject;

    /**
     * 总准备金
     */
    @NotNull(message = "总准备金不能为空")
    private Double totalReserves;

    /**
     * 项目组
     */
    @NotBlank(message = "项目组不能为空")
    private String projectGroup;

    /**
     * 比例分配
     */
    @NotBlank(message = "比例分配不能为空")
    private String prorate;

    /**
     * 准备金
     */
    @NotNull(message = "准备金不能为空")
    private Double reserves;


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getTotalReserves() {
        return totalReserves;
    }

    public void setTotalReserves(Double totalReserves) {
        this.totalReserves = totalReserves;
    }

    public String getProjectGroup() {
        return projectGroup;
    }

    public void setProjectGroup(String projectGroup) {
        this.projectGroup = projectGroup;
    }

    public String getProrate() {
        return prorate;
    }

    public void setProrate(String prorate) {
        this.prorate = prorate;
    }

    public Double getReserves() {
        return reserves;
    }

    public void setReserves(Double reserves) {
        this.reserves = reserves;
    }
}