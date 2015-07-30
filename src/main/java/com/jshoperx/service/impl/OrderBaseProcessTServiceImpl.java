package com.jshoperx.service.impl;


import com.jshoperx.action.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshoperx.action.backstage.utils.enums.BaseEnums.LogisticsShowRange;
import com.jshoperx.dao.*;
import com.jshoperx.entity.*;
import com.jshoperx.service.OrderBaseProcessTService;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("orderBaseProcessTService")
@Scope("prototype")
public class OrderBaseProcessTServiceImpl implements OrderBaseProcessTService {
	@Resource
	private DeliverAddressTDao deliverAddressTDao;
	@Resource
	private LogisticsBTDao logisticsBTDao;
	@Resource
	private PaymentMDao paymentMDao;
	@Resource
	private CartTDao cartTDao;
	@Resource
	private LogisticsBAreaTDao logisticsBAreaTDao;
	@Resource
	private OrderTDao orderTDao;
	@Resource
	private ShippingAddressTDao shippingAddressTDao;
	@Override
	public List<DeliverAddressT> getMemberDeliverAddress(MemberT m) {
		Criterion criterion=Restrictions.eq("memberid", m.getId());
		return deliverAddressTDao.findByCriteria(DeliverAddressT.class, criterion);
	}


	@Override
	public List<LogisticsBusinessT> getLogisticstsBusiness(String state) {
		Criterion criterion=Restrictions.eq("state", LogisticsShowRange.FRONTSTAGE.getState());
		return logisticsBTDao.findByCriteria(LogisticsBusinessT.class, criterion);
	}


	@Override
	public List<PaymentM> getPaymentM(String state) {
		Criterion criterion=Restrictions.eq("state", DataUsingState.USING.getState());
		return paymentMDao.findByCriteria(PaymentM.class, criterion);
	}


	@Override
	public List<CartT> getMemberCart(String memberid, String state,
			String orderTag) {
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("memberid", memberid);
		params.put("state", state);
		params.put("orderTag", orderTag);
		Criterion criterion=Restrictions.allEq(params);
		return cartTDao.findByCriteria(CartT.class, criterion);
	}


	@Override
	public List<LogisticsBusinessT> getDefaultLogisticsBusinessT(String visible) {
		Criterion criterion=Restrictions.eq("visible", visible);
		return logisticsBTDao.findByCriteria(LogisticsBusinessT.class, criterion);
	}


	@Override
	public List<LogisticsbusinessareaT> getDefaultLogisticsbusinessareaT(
			String logisticsid) {
		Criterion criterion=Restrictions.eq("logisticsid", logisticsid);
		return logisticsBAreaTDao.findByCriteria(LogisticsbusinessareaT.class, criterion);
	}


	@Override
	public PaymentM getSelectedPayMent(String paymentid) {
		return paymentMDao.findByPK(PaymentM.class, paymentid);
	}


	@Override
	public DeliverAddressT getDeliverAddress(String addressid) {
		return deliverAddressTDao.findByPK(DeliverAddressT.class, addressid);
	}


	@Override
	public OrderT getOrder(String orderid) {
		return orderTDao.findByPK(OrderT.class, orderid);
	}


	@Override
	public ShippingAddressT getShippingAddress(String deliveraddressid,
			String state, String orderid) {
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("deliveraddressid", deliveraddressid);
		params.put("state", state);
		params.put("orderid", orderid);
		Criterion criterion=Restrictions.allEq(params);
		return shippingAddressTDao.findOneByCriteria(ShippingAddressT.class, criterion);
	}


	@Override
	public List<ShippingAddressT> getShippingAddress(String orderid) {
		Criterion criterion=Restrictions.eq("orderid", orderid);
		return shippingAddressTDao.findByCriteria(ShippingAddressT.class, criterion);
	}


	

}
