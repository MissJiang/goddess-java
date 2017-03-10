package com.bjike.goddess.user.service.rbac;

import com.bjike.goddess.common.api.exception.SerException;
import com.bjike.goddess.common.api.service.Ser;
import com.bjike.goddess.user.dto.rbac.RoleDTO;
import com.bjike.goddess.user.entity.rbac.Role;
import com.bjike.goddess.user.bo.rbac.RoleBO;
import com.bjike.goddess.user.bo.rbac.RoleTreeBO;

import java.util.List;

/**
 * 角色业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface RoleAPI extends Ser<Role, RoleDTO> {
    /**
     * 逐层查询,逐层加载
     * @param id
     * @return
     */
    default List<RoleTreeBO> treeData(String id)throws SerException{
        return null;
    }


    default RoleBO saveByBO(RoleBO bo) throws SerException {
       return  null;
    }

}