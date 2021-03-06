package com.bjike.goddess.interiorrecommend.service;

import com.bjike.goddess.common.api.exception.SerException;
import com.bjike.goddess.common.api.service.Ser;
import com.bjike.goddess.interiorrecommend.bo.AwardStandardBO;
import com.bjike.goddess.interiorrecommend.dto.AwardStandardDTO;
import com.bjike.goddess.interiorrecommend.entity.AwardStandard;
import com.bjike.goddess.interiorrecommend.to.AwardStandardTO;

import java.util.List;

/**
 * 推荐奖励要求标准业务接口
 *
 * @Author: [ Jason ]
 * @Date: [ 2017-04-10 11:39 ]
 * @Description: [ 推荐奖励要求标准业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface AwardStandardSer extends Ser<AwardStandard, AwardStandardDTO> {

    /**
     * 新增推荐奖励要求
     *
     * @param to 推荐奖励要求
     * @return 推荐奖励要求
     */
    AwardStandardBO insertModel(AwardStandardTO to) throws SerException;

    /**
     * 编辑推荐奖励要求
     *
     * @param to 推荐奖励要求
     * @return 推荐奖励要求
     */
    AwardStandardBO updateModel(AwardStandardTO to) throws SerException;


    /**
     * 分页查询推荐奖励要求
     *
     * @param dto 分页条件
     * @return 推荐奖励要求结果集
     */
    List<AwardStandardBO> pageList(AwardStandardDTO dto) throws SerException;

}