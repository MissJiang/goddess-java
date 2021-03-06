package com.bjike.goddess.interiorrecommend.service;

import com.bjike.goddess.common.api.dto.Restrict;
import com.bjike.goddess.common.api.exception.SerException;
import com.bjike.goddess.common.jpa.service.ServiceImpl;
import com.bjike.goddess.common.utils.bean.BeanTransform;
import com.bjike.goddess.common.utils.date.DateUtil;
import com.bjike.goddess.interiorrecommend.bo.RecommendContentBO;
import com.bjike.goddess.interiorrecommend.bo.RecommendInfoBO;
import com.bjike.goddess.interiorrecommend.bo.RecommendRequireBO;
import com.bjike.goddess.interiorrecommend.dto.RecommendContentDTO;
import com.bjike.goddess.interiorrecommend.dto.RecommendInfoDTO;
import com.bjike.goddess.interiorrecommend.entity.*;
import com.bjike.goddess.interiorrecommend.to.RecommendInfoTO;
import com.bjike.goddess.user.api.UserAPI;
import com.bjike.goddess.user.bo.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 推荐信息业务实现
 *
 * @Author: [ Jason ]
 * @Date: [ 2017-04-10 02:54 ]
 * @Description: [ 推荐信息业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "interiorrecommendSerCache")
@Service
public class RecommendInfoSerImpl extends ServiceImpl<RecommendInfo, RecommendInfoDTO> implements RecommendInfoSer {

    @Autowired
    private UserAPI userAPI;
    @Autowired
    private AwardInfoSer awardInfoSer;
    @Autowired
    private RecommendRequireSer recommendRequireSer;


    @Override
    public RecommendInfoBO insertModel(RecommendInfoTO to) throws SerException {
        UserBO userBO = userAPI.currentUser();
        RecommendRequire recommendRequire = recommendRequireSer.findById(to.getRequireId());
        if (recommendRequire != null) {
            RecommendInfo model = BeanTransform.copyProperties(to, RecommendInfo.class, true);
            //保存推荐考核内容
            if (!CollectionUtils.isEmpty(to.getContentList())) {
                Set<RecommendContent> contentSet = new HashSet<RecommendContent>();
                List<RecommendContent> contentList = BeanTransform.copyProperties(to.getContentList(), RecommendAssessDetail.class);
                contentSet.addAll(contentList);
                model.setContentSet(contentSet);
                model.setRecommendUser(userBO.getUsername());
                model.setRecommendRequire(recommendRequire);
                super.save(model);
                to.setId(model.getId());
                return BeanTransform.copyProperties(to, RecommendRequireBO.class);
            } else {
                throw new SerException("推荐考核内容不能为空!");
            }
        } else {
            throw new SerException("非法推荐要求Id,推荐要求对象不能为空!");
        }
    }

    @Override
    public RecommendInfoBO updateModel(RecommendInfoTO to) throws SerException {
        RecommendRequire recommendRequire = recommendRequireSer.findById(to.getRequireId());
        if (recommendRequire != null) {
            RecommendInfo model = super.findById(to.getId());
            if (model != null) {
                BeanTransform.copyProperties(to, model, true);
                model.setModifyTime(LocalDateTime.now());
                if (!CollectionUtils.isEmpty(to.getContentList())) {
                    Set<RecommendContent> contentSet = new HashSet<RecommendContent>();
                    List<RecommendContent> contentList = BeanTransform.copyProperties(to.getContentList(), RecommendAssessDetail.class);
                    contentSet.addAll(contentList);
                    model.setRecommendRequire(recommendRequire);
                    model.setContentSet(contentSet);
                }
                super.update(model);
                return BeanTransform.copyProperties(to, RecommendInfoBO.class);
            } else {
                throw new SerException("非法Id,推荐信息对象不能为空");
            }
        } else {
            throw new SerException("非法推荐要求Id,推荐要求对象不能为空!");
        }
    }

    @Override
    public void delete(String id) throws SerException {
        super.remove(id);
    }

    @Override
    public List<RecommendInfoBO> pageList(RecommendInfoDTO dto) throws SerException {
        dto.getSorts().add("createTime=desc");
        List<RecommendInfo> list = super.findByPage(dto);
        if (!CollectionUtils.isEmpty(list)) {
            List<RecommendInfoBO> boList = new ArrayList<RecommendInfoBO>();
            for (RecommendInfo model : list) {
                RecommendRequire recommendRequire = model.getRecommendRequire();
                RecommendInfoBO bo = BeanTransform.copyProperties(model, RecommendInfoBO.class);
                bo.setOpenTime(DateUtil.dateToString(recommendRequire.getRecommendScheme().getOpenTime()));
                bo.setCloseTime(DateUtil.dateToString(recommendRequire.getRecommendScheme().getCloseTime()));
                bo.setPurpose(recommendRequire.getRecommendScheme().getPurpose());
                bo.setTypeName(recommendRequire.getRecommendType().getTypeName());
                boList.add(bo);
            }
            return boList;
        } else {
            return null;
        }
    }

    @Override
    public void acceptAudit(String id, String reason, Boolean accept) throws SerException {
        RecommendInfo model = super.findById(id);
        if (model != null) {
            model.setReason(reason);
            model.setAccept(accept);
            super.update(model);
        } else {
            throw new SerException("非法Id,推荐信息对象不能为空");
        }
    }

    @Override
    public void conformAudit(String id, Boolean conform) throws SerException {
        RecommendInfo model = super.findById(id);
        if (model != null) {
            if (model.getAccept() != Boolean.TRUE) {
                throw new SerException("推荐信息审核未通过,无法进行奖励审核!");
            }
            if (model.getConform() == Boolean.FALSE) {
                throw new SerException("已经审核不符合!");
            }
            model.setConform(conform);
            if (conform) {
                AwardInfo awardInfo = new AwardInfo();
                awardInfo.setRecommendInfo(model);
                awardInfoSer.save(awardInfo);
            }
        } else {
            throw new SerException("非法Id,推荐信息对象不能为空");
        }
    }
}