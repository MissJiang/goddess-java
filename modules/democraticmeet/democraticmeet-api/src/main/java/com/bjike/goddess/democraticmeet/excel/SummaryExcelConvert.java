package com.bjike.goddess.democraticmeet.excel;

import com.bjike.goddess.common.api.to.BaseTO;
import com.bjike.goddess.common.utils.excel.ExcelHeader;

import java.time.LocalDateTime;


/**
 * 会议纪要
 *
 * @Author: [ tanghaixiang ]
 * @Date: [ 2017-05-19 09:11 ]
 * @Description: [ 会议纪要 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class SummaryExcelConvert extends BaseTO {

    /**
     * 自定义序号
     */
    private String seriNumber;



    /**
     * 实际参会人员
     */
    private String actualPerson;

    /**
     * 新增参会人员
     */
    private String newPerson;

    /**
     * 未参会人员
     */
    private String nonePerson;

    /**
     * 参会人数
     */
    private Double personNum;

    /**
     * 自我批评的内容
     */
    private String selfCritic;


    /**
     * 他人给予的建议
     */
    private String advice;

    /**
     * 建议人
     */
    private String advicer;

    /**
     * 自我总结
     */
    private String selfsummery;

    /**
     * 会议记录人
     */
    private String recorder;

    /**
     * 实际会议时间:处理实际时间转成string型
     */
    private String dealTime;

    public String getSeriNumber() {
        return seriNumber;
    }

    public void setSeriNumber(String seriNumber) {
        this.seriNumber = seriNumber;
    }


    public String getActualPerson() {
        return actualPerson;
    }

    public void setActualPerson(String actualPerson) {
        this.actualPerson = actualPerson;
    }

    public String getNewPerson() {
        return newPerson;
    }

    public void setNewPerson(String newPerson) {
        this.newPerson = newPerson;
    }

    public String getNonePerson() {
        return nonePerson;
    }

    public void setNonePerson(String nonePerson) {
        this.nonePerson = nonePerson;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public Double getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Double personNum) {
        this.personNum = personNum;
    }

    public String getSelfCritic() {
        return selfCritic;
    }

    public void setSelfCritic(String selfCritic) {
        this.selfCritic = selfCritic;
    }

    public String getSelfsummery() {
        return selfsummery;
    }

    public void setSelfsummery(String selfsummery) {
        this.selfsummery = selfsummery;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getAdvicer() {
        return advicer;
    }

    public void setAdvicer(String advicer) {
        this.advicer = advicer;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }
}
