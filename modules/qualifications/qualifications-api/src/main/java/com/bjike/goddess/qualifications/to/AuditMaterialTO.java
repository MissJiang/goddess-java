package com.bjike.goddess.qualifications.to;

import com.bjike.goddess.common.api.to.BaseTO;

/**
 * 审核资料
 *
 * @Author: [ dengjunren ]
 * @Date: [ 2017-03-31 06:44 ]
 * @Description: [ 审核资料 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class AuditMaterialTO extends BaseTO {

    /**
     * 备案书
     */
    private String record;

    /**
     * 其他(附件)
     */
    private String other;


    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}