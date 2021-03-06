package com.bjike.goddess.moneyside.action.moneyside;

import com.bjike.goddess.common.api.exception.ActException;
import com.bjike.goddess.common.api.exception.SerException;
import com.bjike.goddess.common.api.restful.Result;
import com.bjike.goddess.common.consumer.restful.ActResult;
import com.bjike.goddess.common.utils.bean.BeanTransform;
import com.bjike.goddess.moneyside.api.CustomerInfoCollectAPI;
import com.bjike.goddess.moneyside.bo.CustomerInfoCollectBO;
import com.bjike.goddess.moneyside.dto.CustomerInfoCollectDTO;
import com.bjike.goddess.moneyside.service.CustomerInfoCollectSer;
import com.bjike.goddess.moneyside.vo.CustomerInfoCollectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户信息汇总
 *
 * @Author: [ xiazhili ]
 * @Date: [ 2017-06-07 10:11 ]
 * @Description: [ 客户信息汇总 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@RestController
@RequestMapping("customerinfocollect")
public class CustomerInfoCollectAction {
    @Autowired
    private CustomerInfoCollectAPI customerInfoCollectAPI;
    /**
     * 客户信息汇总
     *
     * @param dto
     * @return class CustomerInfoCollectVO
     * @des 客户信息汇总
     * @version v1
     */
    @GetMapping("v1/collect")
    public Result collect(CustomerInfoCollectDTO dto) throws ActException {
        try {
            List<CustomerInfoCollectVO> customerInfoCollectVOS = BeanTransform.copyProperties(
                    customerInfoCollectAPI.collect(dto), CustomerInfoCollectVO.class);
            return ActResult.initialize(customerInfoCollectVOS);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }


}