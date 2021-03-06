package com.bjike.goddess.buyticket.api;

import com.bjike.goddess.buyticket.bo.BasicInfoBO;
import com.bjike.goddess.buyticket.dto.BasicInfoDTO;
import com.bjike.goddess.buyticket.to.BasicInfoTO;
import com.bjike.goddess.common.api.exception.SerException;

import java.util.List;

/**
 * 基本信息设置业务接口
 *
 * @Author: [ xiazhili ]
 * @Date: [ 2017-04-25 03:14 ]
 * @Description: [ 基本信息设置业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface BasicInfoAPI {
    /**
     * 基本信息设置列表总条数
     */
    default Long countBasicInfo(BasicInfoDTO basicInfoDTO) throws SerException {
        return null;
    }
    /**
     * 一个基本信息设置
     * @return class BasicInfoBO
     */
    default BasicInfoBO getOne(String id) throws SerException {return null;}

    /**
     * 基本信息设置
     *
     * @param basicInfoDTO 基本信息设置dto
     * @return class BasicInfoBO
     * @throws SerException
     */
    default List<BasicInfoBO> findListBasicInfo(BasicInfoDTO basicInfoDTO) throws SerException {
        return null;
    }

    /**
     * 添加基本信息设置
     *
     * @param basicInfoTO 基本信息设置数据to
     * @return class BasicInfoBO
     * @throws SerException
     */
    default BasicInfoBO insertBasicInfo(BasicInfoTO basicInfoTO) throws SerException {
        return null;
    }

    /**
     * 编辑基本信息设置
     *
     * @param basicInfoTO 基本信息设置数据to
     * @return class BasicInfoBO
     * @throws SerException
     */
    default BasicInfoBO editBasicInfo(BasicInfoTO basicInfoTO) throws SerException {
        return null;
    }

    /**
     * 根据id删除基本信息设置
     *
     * @param id
     * @throws SerException
     */
    default void removeBasicInfo(String id) throws SerException {

    }

}