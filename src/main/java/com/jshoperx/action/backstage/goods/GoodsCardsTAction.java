package com.jshoperx.action.backstage.goods;

import com.jshoperx.action.backstage.base.BaseTAction;
import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshoperx.action.backstage.utils.enums.BaseEnums.GoodsType;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.GoodsCardsPasswordT;
import com.jshoperx.entity.GoodsCardsT;
import com.jshoperx.entity.GoodsT;
import com.jshoperx.service.GoodsCardsPasswordTService;
import com.jshoperx.service.GoodsCardsTService;
import com.jshoperx.service.GoodsTService;
import com.jshoperx.service.impl.Serial;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.util.*;

@Namespace("")
@ParentPackage("jshoperx")
public class GoodsCardsTAction extends BaseTAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5671746085626726227L;
	@Resource
	private GoodsCardsTService goodsCardsTService;
	@Resource
	private GoodsCardsPasswordTService goodsCardsPasswordTService;
	@Resource
	private GoodsTService goodsTService;
	private String id;
	private String goodsid;
	private String goodsname;
	private int amount;
	private String status;
	private String creatorid;
	private Date createtime;
	private Date updatetime;
	private String cardname;
	private GoodsCardsT bean = new GoodsCardsT();	
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public GoodsCardsT getBean() {
		return bean;
	}

	public void setBean(GoodsCardsT bean) {
		this.bean = bean;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * 保存购物卡类和商品中虚拟商品的关系
	 * 
	 * @return
	 */
	@Action(value = "saveGoodsCardsT", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String saveGoodsCardsT() {
		GoodsCardsT gct = new GoodsCardsT();
		gct.setId(this.getSerial().Serialid(Serial.GOODSCARDS));
		gct.setGoodsid(this.getGoodsid());
		gct.setGoodsname(this.getGoodsname());
		gct.setAmount(this.getAmount());
		gct.setStatus(DataUsingState.USING.getState());
		gct.setCreatetime(BaseTools.getSystemTime());
		gct.setCreatorid(BaseTools.getAdminCreateId());
		gct.setUpdatetime(BaseTools.getSystemTime());
		gct.setCardname(this.getCardname());
		goodsCardsTService.save(gct);
		buildCardsPassword(gct.getId(),gct.getAmount());
		this.setSucflag(true);
		return JSON;
	}
	
	@Action(value = "findAllGoodsCards", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String findAllGoodsCards(){
		if(StaticKey.SC.equals(this.getQtype())){
			findDefaultAllGoodsCards();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return JSON;
			}
		}
		return JSON;
	}

	private void findDefaultAllGoodsCards() {
		int currentPage=page;
		int lineSize=rp;
		total=goodsCardsTService.countfindAll(GoodsCardsT.class);
		List<GoodsCardsT>list=goodsCardsTService.findAll(GoodsCardsT.class, currentPage, lineSize);
		processGoodsCardsList(list);
	}

	private void processGoodsCardsList(List<GoodsCardsT> list) {
		for(Iterator<GoodsCardsT>it=list.iterator();it.hasNext();){
			GoodsCardsT gct=it.next();
			Map<String,Object>cellMap=new HashMap<String,Object>();
			cellMap.put("id", gct.getId());
			cellMap.put("cell", new Object[]{
					gct.getCardname(),
					gct.getAmount(),
					gct.getGoodsname(),
					BaseTools.formateDbDate(gct.getCreatetime())
			});
			rows.add(cellMap);
		}
	}
	
	
	@Action(value = "updateGoodsCards", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String updateGoodsCards(){
		if(StringUtils.isBlank(this.getId())){
			return JSON;
		}
		bean=goodsCardsTService.findByPK(GoodsCardsT.class, this.getId());
		bean.setAmount(this.getAmount());
		bean.setCardname(this.getCardname());
		bean.setGoodsid(this.getGoodsid());
		bean.setGoodsname(this.getGoodsname());
		bean.setCreatorid(BaseTools.getAdminCreateId());
		bean.setUpdatetime(BaseTools.getSystemTime());
		goodsCardsTService.update(bean);
		this.setSucflag(true);
		return JSON;
	}
	
		@Action(value = "findGoodsCardsById", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
		public String findGoodsCardsById(){
			if(StringUtils.isBlank(this.getId())){
				return JSON;
			}
			bean=goodsCardsTService.findByPK(GoodsCardsT.class, this.getId());
			this.setSucflag(true);
			return JSON;
		}
		
		@Action(value = "delGoodsCards", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
		public String delGoodsCards(){
			if(StringUtils.isBlank(this.getId())){
				return JSON;
			}
			String ids[]=StringUtils.split(this.getId(), StaticKey.SPLITDOT);
			for(String s:ids){
				bean=goodsCardsTService.findByPK(GoodsCardsT.class, s);
				goodsCardsTService.delete(bean);
			}
			this.setSucflag(true);
			return JSON;
		}
	
		/**
		 * 生成卡类密钥
		 * @param goodsCardsId
		 * @param amount
		 */
		private void buildCardsPassword(String goodsCardsId,int amount){
			int radomNum=0;
			List<GoodsCardsPasswordT> pwdlists=new ArrayList<GoodsCardsPasswordT>();
			for(int i=0;i<amount;i++){
				synchronized (this) {
					radomNum=(int)(Math.random()*10000);
					GoodsCardsPasswordT gcp=new GoodsCardsPasswordT();
					gcp.setId(this.getSerial().Serialid(Serial.GOODSCARDS));
					gcp.setGoodsCardsId(goodsCardsId);
					gcp.setMemberid(StaticKey.EMPTY);
					gcp.setPassword(String.valueOf(System.currentTimeMillis()+radomNum));
					gcp.setStatus(DataUsingState.UNUSING.getState());//0未绑定，1已绑定，2未使用，3已使用，4无效
					gcp.setCreatetime(BaseTools.getSystemTime());
					gcp.setUpdatetime(BaseTools.getSystemTime());
					pwdlists.add(gcp);
				}
			}
			goodsCardsPasswordTService.saveOrUpdateAll(pwdlists);
			
		}
		
		/**
		 * 获取所有虚拟商品
		 * @return
		 */
		@Action(value = "findAllVirtualGoods", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
		public String findAllVirtualGoods(){
			if(StaticKey.SC.equals(this.getQtype())){
				finddefaultAllVirtualGoods();
			}else{
				if(StringUtils.isBlank(this.getQtype())){
					return JSON;
				}
			}
			return JSON;
		}

		private void finddefaultAllVirtualGoods() {
			int currentPage=page;
			int lineSize=rp;
			//statickey.one标识虚拟商品
			Criterion criterion=Restrictions.eq("isvirtualsale", GoodsType.VIRTUALGOODS.getState());
			Order order=Order.desc("updatetime");
			total=goodsTService.count(GoodsT.class, criterion).intValue();
			List<GoodsT>list=goodsTService.findByCriteriaByPage(GoodsT.class, criterion, order, currentPage, lineSize);
			processVirtualGoodsT(list);
		}

		private void processVirtualGoodsT(List<GoodsT> list) {
			for(Iterator<GoodsT>it=list.iterator();it.hasNext();){
				GoodsT gt=it.next();
				Map<String,Object>cellMap=new HashMap<String, Object>();
				cellMap.put("id", gt.getGoodsid());
				cellMap.put("cell", new Object[]{
					gt.getGoodsname(),
					gt.getNname()+"-"+gt.getLname()+"-"+gt.getSname(),
					BaseTools.formateDbDate(gt.getCreatetime())
				});
				rows.add(cellMap);
			}
			
		}
		
		
		
		
	

}
