package com.bjike.goddess.qualifications.service;

import com.bjike.goddess.common.api.exception.SerException;
import com.bjike.goddess.common.api.service.Ser;
import com.bjike.goddess.qualifications.bo.CompanyInfoBO;
import com.bjike.goddess.qualifications.dto.CompanyInfoDTO;
import com.bjike.goddess.qualifications.entity.CompanyInfo;
import com.bjike.goddess.qualifications.to.CompanyInfoTO;

/**
 * 公司基本信息业务接口
 *
 * @Author: [ dengjunren ]
 * @Date: [ 2017-03-31 06:38 ]
 * @Description: [ 公司基本信息业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface CompanyInfoSer extends Ser<CompanyInfo, CompanyInfoDTO> {

    default CompanyInfoBO save(CompanyInfoTO to) throws SerException {
        return null;
    }

    default CompanyInfoBO update(CompanyInfoTO to) throws SerException {
        return null;
    }

    default CompanyInfoBO delete(String id) throws SerException {
        return null;
    }

}