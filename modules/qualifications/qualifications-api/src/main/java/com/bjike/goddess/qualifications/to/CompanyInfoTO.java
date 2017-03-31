package com.bjike.goddess.qualifications.to;

import com.bjike.goddess.common.api.to.BaseTO;

/**
 * 公司基本信息
 *
 * @Author: [ dengjunren ]
 * @Date: [ 2017-03-31 06:38 ]
 * @Description: [ 公司基本信息 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class CompanyInfoTO extends BaseTO {

    /**
     * 公司注册地址
     */
    private String address;

    /**
     * 公司经营地址
     */
    private String operate;

    /**
     * 传真号
     */
    private String fax;

    /**
     * 基本信息
     */
    private String baseInfo;

    /**
     * 证件信息
     */
    private String certificate;

    /**
     * 企业法人营业执照副本
     */
    private String license;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(String baseInfo) {
        this.baseInfo = baseInfo;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}