package com.bjike.goddess.marketactivitymanage.api;

import com.bjike.goddess.common.api.exception.SerException;
import com.bjike.goddess.marketactivitymanage.bo.CustomerInfoBO;
import com.bjike.goddess.marketactivitymanage.dto.CustomerInfoDTO;
import com.bjike.goddess.marketactivitymanage.to.CustomerInfoTO;

import java.util.List;

/**
 * 客户信息业务接口
 *
 * @Author: [ sunfengtao ]
 * @Date: [ 2017-03-21 07:03 ]
 * @Description: [  ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface CustomerInfoAPI {

    /**
     * 分页查询客户信息
     *
     * @param dto 客户信息dto
     * @return class CustomerInfoBO
     * @throws SerException
     */
    List<CustomerInfoBO> list(CustomerInfoDTO dto) throws SerException;

    /**
     * 保存客户信息
     *
     * @param to 客户信息to
     * @return class CustomerInfoBO
     * @throws SerException
     */
    CustomerInfoBO save(CustomerInfoTO to) throws SerException;

    /**
     * 根据id删除客户信息
     *
     * @param id 客户信息唯一标识
     * @throws SerException
     */
    void remove(String id) throws SerException;

    /**
     * 更新客户信息
     *
     * @param to 客户信息to
     * @throws SerException
     */
    void update(CustomerInfoTO to) throws SerException;
}