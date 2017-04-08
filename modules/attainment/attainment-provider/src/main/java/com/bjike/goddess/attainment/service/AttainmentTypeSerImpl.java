package com.bjike.goddess.attainment.service;

import com.bjike.goddess.attainment.bo.AttainmentTypeBO;
import com.bjike.goddess.attainment.dto.AttainmentTypeDTO;
import com.bjike.goddess.attainment.entity.AttainmentType;
import com.bjike.goddess.attainment.to.AttainmentTypeTO;
import com.bjike.goddess.common.api.dto.Restrict;
import com.bjike.goddess.common.api.exception.SerException;
import com.bjike.goddess.common.api.type.Status;
import com.bjike.goddess.common.jpa.service.ServiceImpl;
import com.bjike.goddess.common.utils.bean.BeanTransform;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 调研类型业务实现
 *
 * @Author: [ dengjunren ]
 * @Date: [ 2017-04-06 09:49 ]
 * @Description: [ 调研类型业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "attainmentSerCache")
@Service
public class AttainmentTypeSerImpl extends ServiceImpl<AttainmentType, AttainmentTypeDTO> implements AttainmentTypeSer {

    @Override
    public AttainmentTypeBO save(AttainmentTypeTO to) throws SerException {
        AttainmentType entity = BeanTransform.copyProperties(to, AttainmentType.class);
        entity.setStatus(Status.THAW);
        super.save(entity);
        return BeanTransform.copyProperties(entity, AttainmentTypeBO.class);
    }

    @Override
    public AttainmentTypeBO update(AttainmentTypeTO to) throws SerException {
        if (StringUtils.isNotBlank(to.getId())) {
            try {
                AttainmentType entity = super.findById(to.getId());
                BeanTransform.copyProperties(to, entity, true);
                entity.setModifyTime(LocalDateTime.now());
                super.update(entity);
                return BeanTransform.copyProperties(entity, AttainmentTypeBO.class);
            } catch (SerException e) {
                throw new SerException("数据对象不能为空");
            }

        } else
            throw new SerException("数据ID不能为空");
    }

    @Override
    public AttainmentTypeBO delete(String id) throws SerException {
        AttainmentType entity = super.findById(id);
        super.remove(entity);
        return BeanTransform.copyProperties(entity, AttainmentTypeBO.class);
    }

    @Override
    public AttainmentTypeBO congeal(String id) throws SerException {
        AttainmentType entity = super.findById(id);
        entity.setStatus(Status.CONGEAL);
        entity.setModifyTime(LocalDateTime.now());
        super.update(entity);
        return BeanTransform.copyProperties(entity, AttainmentTypeBO.class);
    }

    @Override
    public AttainmentTypeBO thaw(String id) throws SerException {
        AttainmentType entity = super.findById(id);
        entity.setStatus(Status.THAW);
        entity.setModifyTime(LocalDateTime.now());
        super.update(entity);
        return BeanTransform.copyProperties(entity, AttainmentTypeBO.class);
    }

    @Override
    public List<AttainmentTypeBO> findThaw() throws SerException {
        AttainmentTypeDTO dto = new AttainmentTypeDTO();
        dto.getConditions().add(Restrict.eq(STATUS, Status.THAW));
        List<AttainmentType> list = super.findByCis(dto);
        return BeanTransform.copyProperties(list, AttainmentTypeBO.class);
    }

    @Override
    public List<AttainmentTypeBO> findRegular(Boolean regular) throws SerException {
        AttainmentTypeDTO dto = new AttainmentTypeDTO();
        dto.getConditions().add(Restrict.eq("is_regular", regular));
        List<AttainmentType> list = super.findByCis(dto);
        return BeanTransform.copyProperties(list, AttainmentTypeBO.class);
    }
}