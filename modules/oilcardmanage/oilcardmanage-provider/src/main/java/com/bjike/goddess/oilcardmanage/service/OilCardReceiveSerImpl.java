package com.bjike.goddess.oilcardmanage.service;

import com.bjike.goddess.common.api.exception.SerException;
import com.bjike.goddess.common.jpa.service.ServiceImpl;
import com.bjike.goddess.common.provider.utils.RpcTransmit;
import com.bjike.goddess.common.utils.bean.BeanTransform;
import com.bjike.goddess.contacts.api.InternalContactsAPI;
import com.bjike.goddess.message.api.MessageAPI;
import com.bjike.goddess.message.enums.SendType;
import com.bjike.goddess.message.to.MessageTO;
import com.bjike.goddess.oilcardmanage.bo.OilCardReceiveBO;
import com.bjike.goddess.oilcardmanage.dto.OilCardReceiveDTO;
import com.bjike.goddess.oilcardmanage.entity.OilCardBasic;
import com.bjike.goddess.oilcardmanage.entity.OilCardReceive;
import com.bjike.goddess.oilcardmanage.enums.GuideAddrStatus;
import com.bjike.goddess.oilcardmanage.enums.OilCardReceiveResult;
import com.bjike.goddess.oilcardmanage.enums.OilCardStatus;
import com.bjike.goddess.oilcardmanage.to.GuidePermissionTO;
import com.bjike.goddess.oilcardmanage.to.OilCardReceiveTO;
import com.bjike.goddess.user.api.UserAPI;
import com.bjike.goddess.user.bo.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 油卡领用业务处理类
 *
 * @Author: [Jason]
 * @Date: [17-3-14 下午5:13]
 * @Package:[ com.bjike.goddess.oilcardmanage.service ]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class OilCardReceiveSerImpl extends ServiceImpl<OilCardReceive, OilCardReceiveDTO> implements OilCardReceiveSer {

    @Autowired
    private OilCardBasicSer oilCardBasicSer;
    @Autowired
    private UserAPI userAPI;
    @Autowired
    private MessageAPI messageAPI;
    @Autowired
    private InternalContactsAPI internalContactsAPI;

    @Autowired
    private CusPermissionSer cusPermissionSer;

    /**
     * 核对查看权限（层级别）
     */
    private void checkSeeIdentity() throws SerException {
        Boolean flag = false;
        String userToken = RpcTransmit.getUserToken();
        UserBO userBO = userAPI.currentUser();
        RpcTransmit.transmitUserToken(userToken);
        String userName = userBO.getUsername();
        if (!"admin".equals(userName.toLowerCase())) {
            flag = cusPermissionSer.getCusPermission("1");
            if (!flag) {
                throw new SerException("您不是相应部门的人员，不可以操作");
            }
        }
        RpcTransmit.transmitUserToken(userToken);
    }

    /**
     * 核对添加修改删除审核权限（层级别）
     */
    private void checkAddIdentity() throws SerException {
        Boolean flag = false;
        String userToken = RpcTransmit.getUserToken();
        UserBO userBO = userAPI.currentUser();
        RpcTransmit.transmitUserToken(userToken);
        String userName = userBO.getUsername();
        if (!"admin".equals(userName.toLowerCase())) {
            flag = cusPermissionSer.busCusPermission("2");
            if (!flag) {
                throw new SerException("您不是相应部门的人员，不可以操作");
            }
        }
        RpcTransmit.transmitUserToken(userToken);
    }

    /**
     * 核对查看权限（层级别）
     */
    private Boolean guideSeeIdentity() throws SerException {
        Boolean flag = false;
        String userToken = RpcTransmit.getUserToken();
        UserBO userBO = userAPI.currentUser();
        RpcTransmit.transmitUserToken(userToken);
        String userName = userBO.getUsername();
        if (!"admin".equals(userName.toLowerCase())) {
            flag = cusPermissionSer.getCusPermission("1");
        } else {
            flag = true;
        }
        return flag;
    }

    /**
     * 核对添加修改删除审核权限（层级别）
     */
    private Boolean guideAddIdentity() throws SerException {
        Boolean flag = false;
        String userToken = RpcTransmit.getUserToken();
        UserBO userBO = userAPI.currentUser();
        RpcTransmit.transmitUserToken(userToken);
        String userName = userBO.getUsername();
        if (!"admin".equals(userName.toLowerCase())) {
            flag = cusPermissionSer.busCusPermission("2");
        } else {
            flag = true;
        }
        return flag;
    }

    @Override
    public Boolean sonPermission() throws SerException {
        String userToken = RpcTransmit.getUserToken();
        Boolean flagSee = guideSeeIdentity();
        RpcTransmit.transmitUserToken(userToken);
        Boolean flagAdd = guideAddIdentity();
        if (flagSee || flagAdd) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean guidePermission(GuidePermissionTO guidePermissionTO) throws SerException {
        String userToken = RpcTransmit.getUserToken();
        GuideAddrStatus guideAddrStatus = guidePermissionTO.getGuideAddrStatus();
        Boolean flag = true;
        switch (guideAddrStatus) {
            case LIST:
                flag = guideSeeIdentity();
                break;
            case ADD:
                flag = guideAddIdentity();
                break;
            case EDIT:
                flag = guideAddIdentity();
                break;
            case AUDIT:
                flag = guideAddIdentity();
                break;
            case DELETE:
                flag = guideAddIdentity();
                break;
            case CONGEL:
                flag = guideAddIdentity();
                break;
            case THAW:
                flag = guideAddIdentity();
                break;
            case COLLECT:
                flag = guideAddIdentity();
                break;
            case IMPORT:
                flag = guideAddIdentity();
                break;
            case EXPORT:
                flag = guideAddIdentity();
                break;
            case UPLOAD:
                flag = guideAddIdentity();
                break;
            case DOWNLOAD:
                flag = guideAddIdentity();
                break;
            case SEE:
                flag = guideSeeIdentity();
                break;
            case SEEFILE:
                flag = guideSeeIdentity();
                break;
            default:
                flag = true;
                break;
        }

        RpcTransmit.transmitUserToken(userToken);
        return flag;
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public OilCardReceiveBO insertModel(OilCardReceiveTO to) throws SerException {
        checkSeeIdentity();
        //油卡
        OilCardBasic oilCardBasic = oilCardBasicSer.findById(to.getOilCardBasicId());
        if (oilCardBasic != null) {
            UserBO userBO = userAPI.currentUser();
            String username = userBO.getUsername();
            String userid = userBO.getId();

            if (oilCardBasic.getCardStatus() == OilCardStatus.IDLE) {
                OilCardReceive model = BeanTransform.copyProperties(to, OilCardReceive.class, true);
                model.setOilCardBasic(oilCardBasic);
                model.setReceiveUser(username);
                super.save(model);
                to.setId(model.getId());

                String content = username + "申请油卡领用，请在3天内审批，请在三天内审批，否则油卡领用无效";
                MessageTO messageTO = new MessageTO(username + "申请油卡领用，请批准", "");
                messageTO.setSendType(SendType.EMAIL);
                String[] users = new String[]{internalContactsAPI.findByUser(userid).getEmail()};
                messageTO.setReceivers(users);
                messageAPI.send(messageTO);

                return BeanTransform.copyProperties(to, OilCardReceiveBO.class);
            } else {
                throw new SerException("该油卡非闲置状态,无法领用!");
            }
        } else {
            throw new SerException("非法oilCardBasicId,油卡不存在!");
        }
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public OilCardReceiveBO updateModel(OilCardReceiveTO to) throws SerException { //油卡
        checkSeeIdentity();
        OilCardBasic oilCardBasic = oilCardBasicSer.findById(to.getOilCardBasicId());
        if (oilCardBasic != null) {
            if (oilCardBasic.getCardStatus() != OilCardStatus.IDLE) {
                throw new SerException("该油卡非闲置状态,无法领用!");
            }
            OilCardReceive model = super.findById(to.getId());
            if (model != null) {
                BeanTransform.copyProperties(to, model, true);
                model.setModifyTime(LocalDateTime.now());
                super.update(model);
            } else {
                throw new SerException("非法Id,领用对象不能为空");
            }
        } else {
            throw new SerException("非法oilCardBasicId,油卡不存在!");
        }
        return BeanTransform.copyProperties(to, OilCardReceiveBO.class);
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void returnOilCardReceive(String id) throws SerException {
        checkSeeIdentity();
        OilCardReceive model = super.findById(id);
        if (model != null) {
            OilCardBasic oilCardBasic = model.getOilCardBasic();
            //设置油卡状态-闲置
            oilCardBasic.setCardStatus(OilCardStatus.IDLE);
            oilCardBasic.setModifyTime(LocalDateTime.now());
            oilCardBasicSer.update(oilCardBasic);
        } else {
            throw new SerException("非法Id,油卡领用对象不能为空!");
        }
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public List<OilCardReceiveBO> pageList(OilCardReceiveDTO dto) throws SerException {
        dto.getSorts().add("createTime=desc");
        List<OilCardReceive> list = super.findByPage(dto);
        if (!CollectionUtils.isEmpty(list)) {
            List<OilCardReceiveBO> boList = new ArrayList<OilCardReceiveBO>();
            for (OilCardReceive model : list) {
                OilCardReceiveBO bo = BeanTransform.copyProperties(model, OilCardReceiveBO.class);
                bo.setOilCardNumber(model.getOilCardBasic().getOilCardNumber());
                bo.setOilCardCode(model.getOilCardBasic().getOilCardCode());
                bo.setMainOrDeputy(model.getOilCardBasic().getMainOrDeputy());
                bo.setBelongMainCard(model.getOilCardBasic().getBelongMainCard());
                boList.add(bo);
            }
            return boList;
        } else {
            return null;
        }
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void audit(String id, String auditSuggestion, OilCardReceiveResult oilCardReceiveResult) throws SerException {
        OilCardReceive model = super.findById(id);
        if (model != null) {

            if (LocalDateTime.now().minusDays(3).compareTo(model.getReceiveDate()) > 0) {
                throw new SerException("该记录已经超出了审核期限");
            }
            UserBO userBO = userAPI.currentUser();
            if (userBO.getUsername().equals(model.getAuditUser())) {
                model.setAuditResult(oilCardReceiveResult);
                model.setAuditSuggestion(auditSuggestion);
                super.update(model);

                OilCardBasic oilCardBasic = model.getOilCardBasic();
                //设置油卡状态-正在使用
                oilCardBasic.setCardStatus(OilCardStatus.USE);
                oilCardBasic.setModifyTime(LocalDateTime.now());
                oilCardBasicSer.update(oilCardBasic);
            } else {
                throw new SerException("请联系审核人进行审核!");
            }
        } else {
            throw new SerException("非法Id,油卡领用对象不能为空!");
        }
    }

}
