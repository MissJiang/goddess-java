package com.bjike.goddess.organize.to;

import com.bjike.goddess.common.api.to.BaseTO;
import com.bjike.goddess.common.api.type.Status;

/**
 * 角度展示对象
 *
 * @Author: [dengjunren]
 * @Date: [17-3-8 上午11:23]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class AngleTO extends BaseTO {

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;


    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 使用状态
     */
    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

