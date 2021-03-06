package com.bjike.goddess.contractquotemanager.api;

import com.bjike.goddess.common.api.exception.SerException;
import com.bjike.goddess.common.utils.bean.BeanTransform;
import com.bjike.goddess.contractquotemanager.bo.ContractProjectInfoBO;
import com.bjike.goddess.contractquotemanager.bo.ContractQuoteDataBO;
import com.bjike.goddess.contractquotemanager.dto.ContractProjectInfoDTO;
import com.bjike.goddess.contractquotemanager.dto.ContractQuoteDataDTO;
import com.bjike.goddess.contractquotemanager.entity.ContractProjectInfo;
import com.bjike.goddess.contractquotemanager.service.ContractProjectInfoSer;
import com.bjike.goddess.contractquotemanager.to.ContractProjectInfoTO;
import com.bjike.goddess.contractquotemanager.to.ContractQuoteDataTO;
import com.bjike.goddess.contractquotemanager.to.GuidePermissionTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 合同项目基本信息(临时表存放数据商务模块获取数据)业务接口实现
 *
 * @Author: [ yewenbo ]
 * @Date: [ 2017-03-21 07:18 ]
 * @Description: []
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Service("contractProjectInfoApiImpl")
public class ContractProjectInfoApiImpl implements ContractProjectInfoAPI {

    @Override
    public Boolean sonPermission() throws SerException {
        return contractProjectInfoSer.sonPermission();
    }

    @Override
    public Boolean guidePermission(GuidePermissionTO guidePermissionTO) throws SerException {
        return contractProjectInfoSer.guidePermission(guidePermissionTO);
    }

    @Autowired
    private ContractProjectInfoSer contractProjectInfoSer;

    /**
     * 根据id查询合同项目基本信息
     *
     * @param id 合同项目基本信息唯一标识
     * @return class ContractProjectInfoBO
     * @throws SerException
     */
    @Override
    public ContractProjectInfoBO findById(String id) throws SerException {
        ContractProjectInfo model = contractProjectInfoSer.findById(id);
        return BeanTransform.copyProperties(model, ContractProjectInfoBO.class);
    }

    /**
     * 计算总条数
     *
     * @param dto 合同项目基本信息dto
     * @throws SerException
     */
    @Override
    public Long count(ContractProjectInfoDTO dto) throws SerException {
        return contractProjectInfoSer.count(dto);
    }

    /**
     * 添加合同项目基本信息
     *
     * @param to 合同项目基本信息to
     * @return class ContractProjectInfoBO
     * @throws SerException
     */
    @Override
    public ContractProjectInfoBO save(ContractProjectInfoTO to) throws SerException {
        return contractProjectInfoSer.save(to);
    }

    /**
     * 分页查询合同项目基本信息
     *
     * @param dto 合同项目基本信息
     * @return class ContractProjectInfoBO
     * @throws SerException
     */
    @Override
    public List<ContractProjectInfoBO> list(ContractProjectInfoDTO dto) throws SerException {
        return contractProjectInfoSer.list(dto);
    }

    /**
     * 编辑合同项目基本信息
     *
     * @param to 合同项目基本信息to
     * @throws SerException
     */
    @Override
    public void update(ContractProjectInfoTO to) throws SerException {
        contractProjectInfoSer.update(to);
    }

    /**
     * 根据id删除合同项目基本信息
     *
     * @param id 合同项目基本信息唯一标识
     * @throws SerException
     */
    @Override
    public void remove(String id) throws SerException {
        contractProjectInfoSer.remove(id);
    }

    @Override
    public byte[] exportExcel(ContractProjectInfoDTO contractProjectInfoDTO) throws SerException {
        return contractProjectInfoSer.exportExcel(contractProjectInfoDTO);
    }

    @Override
    public void importExcel(List<ContractProjectInfoTO> contractProjectInfoTOS) throws SerException {
        contractProjectInfoSer.importExcel(contractProjectInfoTOS);
    }

    @Override
    public byte[] templateExport() throws SerException {
        return contractProjectInfoSer.templateExport();
    }

    @Override
    public List<String> findAllAreas() throws SerException {
        return contractProjectInfoSer.findAllAreas();
    }
}