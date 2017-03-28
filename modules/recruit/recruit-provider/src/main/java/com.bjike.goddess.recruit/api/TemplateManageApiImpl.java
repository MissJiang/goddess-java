package com.bjike.goddess.recruit.api;

import com.bjike.goddess.common.api.exception.SerException;
import com.bjike.goddess.recruit.bo.TemplateManageBO;
import com.bjike.goddess.recruit.dto.TemplateManageDTO;
import com.bjike.goddess.recruit.service.TemplateManageSer;
import com.bjike.goddess.recruit.to.TemplateManageTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 模板管理
 *
 * @Author: [sunfengtao]
 * @Date: [2017-03-13 17:42]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service("templateManageApiImpl")
public class TemplateManageApiImpl implements TemplateManageAPI {

    @Autowired
    private TemplateManageSer templateManageSer;

    /**
     * 分页查询模板管理
     *
     * @param templateManageDTO
     * @return
     * @throws SerException
     */
    @Override
    public List<TemplateManageBO> list(TemplateManageDTO templateManageDTO) throws SerException {
        return templateManageSer.list(templateManageDTO);
    }

    /**
     * 保存模板管理
     *
     * @param templateManageTO
     * @return
     * @throws SerException
     */
    @Override
    public TemplateManageBO save(TemplateManageTO templateManageTO) throws SerException {
        return templateManageSer.save(templateManageTO);
    }

    /**
     * 根据id删除模板管理
     *
     * @param id
     * @throws SerException
     */
    @Override
    public void remove(String id) throws SerException {
        templateManageSer.remove(id);
    }

    /**
     * 更新模板管理
     *
     * @param templateManageTO
     * @throws SerException
     */
    @Override
    public void update(TemplateManageTO templateManageTO) throws SerException {
        templateManageSer.update(templateManageTO);
    }
}
