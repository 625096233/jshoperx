package com.jshoperx.action.backstage.goods;


import com.jshoperx.action.backstage.base.BaseTAction;
import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.enums.BaseEnums;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.GoodsGroupDetailRpT;
import com.jshoperx.entity.GoodsGroupT;
import com.jshoperx.service.GoodsGroupTService;
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
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
@Namespace("")
@ParentPackage("jshoperx")
public class GoodsGroupTAction extends BaseTAction {

	private static final long serialVersionUID = 1L;
	@Resource
	private GoodsGroupTService goodsGroupTService;
	
	private String groupid;
	private String bargainprice;
	private String brandid;
	private String brandname;
	private String commoditylist;
	private BigDecimal cost;
	private Date createtime;
	private String creatorid;
	private String fname;
	private String goodsParameterValue;
	private String goodsTypeId;
	private String goodsTypeName;
	private String goodsid;
	private String goodsname;
	private String groupBeginTime;
	private String groupEndTime;
	private double groupNeedPointsLimit;
	private String groupname;
	private BigDecimal groupprice;
	private String hotsale;
	private String htmlPath;
	private String isNew;
	private String ismobileplatformgoods;
	private String isoutsite;
	private String isvirtualsale;
	private String keywords;
	private int limitBuy;
	private String lname;
	private String ltypeid;
	private String mainPicture;
	private String mainSmallPicture;
	private BigDecimal memberprice;
	private String metaDescription;
	private String metaKeywords;
	private String navid;
	private String nname;
	private String outsitelink;
	private String pictures;
	private double points;
	private BigDecimal price;
	private double readcount;
	private int realOrdersCount;
	private String recommended;
	private BigDecimal saleprice;
	private String salestate;
	private String shopid;
	private String shopname;
	private String smallPictures;
	private String sname;
	private int sort;
	private String stypeid;
	private String subgroupname;
	private int totalcomment;
	private int totalstar;
	private int totalstaruser;
	private Date updatetime;
	private String usersetnum;
	private int versiont;
	private int virtualOrdersCount;
	private String detail;
	private String goodsAttrsVals;
	private GoodsGroupT bean= new GoodsGroupT();
	private List<Map<String,Object>> rows= new ArrayList<Map<String,Object>>();
	private int total=0;
	private int page=1;
	private int rp;
	private String basepath;
	private boolean sucflag;
	
	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	public String getGoodsAttrsVals() {
		return goodsAttrsVals;
	}

	public void setGoodsAttrsVals(String goodsAttrsVals) {
		this.goodsAttrsVals = goodsAttrsVals;
	}

	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getBrandid() {
		return brandid;
	}
	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getCommoditylist() {
		return commoditylist;
	}
	public void setCommoditylist(String commoditylist) {
		this.commoditylist = commoditylist;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	public String getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
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
	
	
	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getGroupBeginTime() {
		return groupBeginTime;
	}

	public void setGroupBeginTime(String groupBeginTime) {
		this.groupBeginTime = groupBeginTime;
	}

	public String getGroupEndTime() {
		return groupEndTime;
	}

	public void setGroupEndTime(String groupEndTime) {
		this.groupEndTime = groupEndTime;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLtypeid() {
		return ltypeid;
	}

	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}

	public String getNavid() {
		return navid;
	}

	public void setNavid(String navid) {
		this.navid = navid;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getStypeid() {
		return stypeid;
	}

	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}

	public double getGroupNeedPointsLimit() {
		return groupNeedPointsLimit;
	}
	public void setGroupNeedPointsLimit(double groupNeedPointsLimit) {
		this.groupNeedPointsLimit = groupNeedPointsLimit;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public BigDecimal getGroupprice() {
		return groupprice;
	}
	public void setGroupprice(BigDecimal groupprice) {
		this.groupprice = groupprice;
	}
	public String getHtmlPath() {
		return htmlPath;
	}
	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}
	public String getIsmobileplatformgoods() {
		return ismobileplatformgoods;
	}
	public void setIsmobileplatformgoods(String ismobileplatformgoods) {
		this.ismobileplatformgoods = ismobileplatformgoods;
	}
	public String getIsoutsite() {
		return isoutsite;
	}
	public void setIsoutsite(String isoutsite) {
		this.isoutsite = isoutsite;
	}
	public String getIsvirtualsale() {
		return isvirtualsale;
	}
	public void setIsvirtualsale(String isvirtualsale) {
		this.isvirtualsale = isvirtualsale;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getMainPicture() {
		return mainPicture;
	}
	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}
	public String getMainSmallPicture() {
		return mainSmallPicture;
	}
	public void setMainSmallPicture(String mainSmallPicture) {
		this.mainSmallPicture = mainSmallPicture;
	}
	public BigDecimal getMemberprice() {
		return memberprice;
	}
	public void setMemberprice(BigDecimal memberprice) {
		this.memberprice = memberprice;
	}
	public String getMetaDescription() {
		return metaDescription;
	}
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	public String getMetaKeywords() {
		return metaKeywords;
	}
	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}
	public String getOutsitelink() {
		return outsitelink;
	}
	public void setOutsitelink(String outsitelink) {
		this.outsitelink = outsitelink;
	}
	public String getPictures() {
		return pictures;
	}
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public double getReadcount() {
		return readcount;
	}
	public void setReadcount(double readcount) {
		this.readcount = readcount;
	}
	public int getRealOrdersCount() {
		return realOrdersCount;
	}
	public void setRealOrdersCount(int realOrdersCount) {
		this.realOrdersCount = realOrdersCount;
	}

	public BigDecimal getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(BigDecimal saleprice) {
		this.saleprice = saleprice;
	}
	public String getSalestate() {
		return salestate;
	}
	public void setSalestate(String salestate) {
		this.salestate = salestate;
	}

	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getSmallPictures() {
		return smallPictures;
	}
	public void setSmallPictures(String smallPictures) {
		this.smallPictures = smallPictures;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getSubgroupname() {
		return subgroupname;
	}
	public void setSubgroupname(String subgroupname) {
		this.subgroupname = subgroupname;
	}
	public int getTotalcomment() {
		return totalcomment;
	}
	public void setTotalcomment(int totalcomment) {
		this.totalcomment = totalcomment;
	}
	public int getTotalstar() {
		return totalstar;
	}
	public void setTotalstar(int totalstar) {
		this.totalstar = totalstar;
	}
	public int getTotalstaruser() {
		return totalstaruser;
	}
	public void setTotalstaruser(int totalstaruser) {
		this.totalstaruser = totalstaruser;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getUsersetnum() {
		return usersetnum;
	}
	public void setUsersetnum(String usersetnum) {
		this.usersetnum = usersetnum;
	}
	public int getVersiont() {
		return versiont;
	}
	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}
	public int getVirtualOrdersCount() {
		return virtualOrdersCount;
	}
	public void setVirtualOrdersCount(int virtualOrdersCount) {
		this.virtualOrdersCount = virtualOrdersCount;
	}
	public GoodsGroupT getBean() {
		return bean;
	}
	public void setBean(GoodsGroupT bean) {
		this.bean = bean;
	}
	public List<Map<String, Object>> getRows() {
		return rows;
	}
	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	public String getBargainprice() {
		return bargainprice;
	}
	public void setBargainprice(String bargainprice) {
		this.bargainprice = bargainprice;
	}
	public String getHotsale() {
		return hotsale;
	}
	public void setHotsale(String hotsale) {
		this.hotsale = hotsale;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public int getLimitBuy() {
		return limitBuy;
	}
	public void setLimitBuy(int limitBuy) {
		this.limitBuy = limitBuy;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public String getRecommended() {
		return recommended;
	}
	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}
	
	public String getGoodsParameterValue() {
		return goodsParameterValue;
	}
	public void setGoodsParameterValue(String goodsParameterValue) {
		this.goodsParameterValue = goodsParameterValue;
	}
	@Override
	public void validate() {
		this.clearErrorsAndMessages();
	}
	/**
	 * 添加团购商品
	 * @return
	 * @throws ParseException 
	 */
	@Action(value="saveGoodsGroupT",results={@Result(name="json",type="json")})
	public String saveGoodsGroupT() throws ParseException{
		//构造goodsgroup
		GoodsGroupT ggt = new GoodsGroupT();		
		ggt.setGroupid(this.getSerial().Serialid(Serial.GOODSGROUPT));
		ggt.setBargainprice(this.getBargainprice());
		ggt.setBrandid(this.getBrandid());
		ggt.setBrandname(this.getBrandname());
		ggt.setCommoditylist(this.getCommoditylist());
		ggt.setCost(this.getCost());
		ggt.setCreatetime(BaseTools.getSystemTime());
		ggt.setCreatorid(BaseTools.getAdminCreateId());
		ggt.setGoodsParameterValue(this.getGoodsParameterValue());
		ggt.setGoodsTypeId(this.getGoodsTypeId());
		ggt.setGoodsTypeName(this.getGoodsTypeName());
		ggt.setGoodsid(this.getGoodsid());
		ggt.setGoodsname(this.getGoodsname());
		ggt.setGroupBeginTime(BaseTools.formatString2DataYYYMMDDHHMMSS(this.getGroupBeginTime()));
		ggt.setGroupEndTime(BaseTools.formatString2DataYYYMMDDHHMMSS(this.getGroupEndTime()));
		ggt.setGroupNeedPointsLimit(this.getGroupNeedPointsLimit());
		ggt.setGroupname(this.getGroupname());
		ggt.setGroupprice(this.getGroupprice());
		ggt.setHotsale(this.getHotsale());
		ggt.setHtmlPath(StaticKey.EMPTY);
		ggt.setIsNew(this.getIsNew());
		ggt.setIsmobileplatformgoods(this.getIsmobileplatformgoods());
		ggt.setIsoutsite(this.getIsoutsite());
		ggt.setIsvirtualsale(this.getIsvirtualsale());
		ggt.setKeywords(this.getMetaKeywords());
		ggt.setLimitBuy(this.getLimitBuy());
		ggt.setMainPicture(this.getMainPicture());
		ggt.setMainSmallPicture(this.getMainSmallPicture());
		ggt.setMemberprice(this.getMemberprice());
		ggt.setMetaDescription(this.getMetaDescription());
		ggt.setMetaKeywords(this.getMetaKeywords());
		ggt.setOutsitelink(this.getOutsitelink());
		ggt.setPictures(this.getPictures());
		ggt.setPoints(this.getPoints());
		ggt.setPrice(this.getPrice());
		ggt.setReadcount(this.getReadcount());
		ggt.setRealOrdersCount(0);
		ggt.setRecommended(this.getRecommended());
		ggt.setSaleprice(this.getSaleprice());
		ggt.setSalestate(this.getSalestate());
		ggt.setShopid(BaseTools.getShopId());
		ggt.setShopname(BaseTools.getShopName());
		ggt.setSmallPictures(this.getSmallPictures());
		ggt.setSort(this.getSort());
		ggt.setSubgroupname(this.getSubgroupname());
		ggt.setTotalcomment(this.getTotalcomment());
		ggt.setTotalstar(0);
		ggt.setTotalstaruser(0);
		ggt.setUpdatetime(BaseTools.getSystemTime());
		ggt.setUsersetnum(this.getUsersetnum());
		ggt.setVersiont(0);
		ggt.setVirtualOrdersCount(this.getVirtualOrdersCount());
		ggt.setNname(this.getNname());
		ggt.setLname(this.getLname());
		ggt.setSname(this.getSname());
		ggt.setFname(StaticKey.EMPTY);
		ggt.setNavid(this.getNavid());
		ggt.setLtypeid(this.getLtypeid());
		ggt.setStypeid(this.getStypeid());
		//构造goodsgroupdetail和goodsgroup关系
		GoodsGroupDetailRpT ggdt=new GoodsGroupDetailRpT();
		ggdt.setId(this.getSerial().Serialid(Serial.GOODSGROUPDETAILRPT));
		ggdt.setDetail(this.getDetail());
		ggdt.setGroupid(ggt.getGroupid());
		this.goodsGroupTService.saveGoodsGroupProcess(ggt, ggdt, this.getGoodsAttrsVals());
		this.setSucflag(true);
		return JSON;			
	}

	/**
	 * 处理迭代商品信息
	 * @param ggtList
	 */
	public void processGoodsGroupTList(List<GoodsGroupT> ggtList){
		String basePath= BaseTools.getBasePath();
		for(Iterator<GoodsGroupT> it = ggtList.iterator();it.hasNext();){
			GoodsGroupT ggt =it.next();
			if (ggt.getRecommended().equals(BaseEnums.GoodsState.RECOMMENDED.getState())) {
				ggt.setRecommended("<span class='truestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				ggt.setRecommended("<span class='falsestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (ggt.getHotsale().equals(BaseEnums.GoodsState.HOTSALE.getState())) {
				ggt.setHotsale("<span class='truestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				ggt.setHotsale("<span class='falsestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (ggt.getBargainprice().equals(BaseEnums.GoodsState.BARGAINPRICE.getState())) {
				ggt.setBargainprice("<span class='truestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				ggt.setBargainprice("<span class='falsestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (ggt.getIsNew().equals(BaseEnums.GoodsState.NEW.getState())) {
				ggt.setIsNew("<span class='truestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				ggt.setIsNew("<span class='falsestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (ggt.getSalestate().equals(BaseEnums.GoodsSaleState.SALE.getState())) {
				ggt.setSalestate("<span class='truestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				ggt.setSalestate("<span class='falsestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (ggt.getIsmobileplatformgoods().equals(BaseEnums.GoodsState.ISMOBILEPLATFORM.getState())) {
				ggt.setIsmobileplatformgoods("<span class='truestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				ggt.setIsmobileplatformgoods("<span class='falsestatue'><img width='20px' height='20px' src='"+basePath+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", ggt.getGroupid());
			cellMap.put("cell", new Object[]{
					ggt.getGroupname(),
					ggt.getGroupprice(),
					ggt.getSalestate(), 
					ggt.getIsNew(), 
					ggt.getBargainprice(), 
					ggt.getHotsale(), 
					ggt.getRecommended(), 
					ggt.getIsmobileplatformgoods(),
					BaseTools.formateDbDate(ggt.getGroupBeginTime()),
					BaseTools.formateDbDate(ggt.getGroupEndTime()),
					"<a id='editgroupgoods' href='goodsgroup.jsp?operate=edit&folder=goods&groupid="+ggt.getGroupid()+"' name='editgoodsgroup'>[编辑]</a>"});
			rows.add(cellMap);
		}
	}
	/**
	 * 获取默认所有的团购商品信息
	 */	
	public  void defaultfindAllGoodsGroupT(){
		int currentPage= page;
		int lineSize = rp;
		total = this.goodsGroupTService.count(GoodsGroupT.class).intValue();
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			List<GoodsGroupT> list = this.goodsGroupTService.findByCriteriaByPage(GoodsGroupT.class, order, currentPage, lineSize);
			processGoodsGroupTList(list);
		}
	}
	/**
	 * 获取所有团购商品的信息
	 * @return
	 */
	@Action(value="findAllGoodsGroupT",results={@Result(name="json",type="json")})
	public String findAllGoodsGroupT(){
		if(this.getQtype().equals(StaticKey.SC)){
			defaultfindAllGoodsGroupT();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return JSON;
			}else{
				return JSON;
			}
		}
		return JSON;
	}
	/**
	 * 根据groupid 获取团购商品信息
	 * @return
	 */
	@Action(value="findGoodsGroupById",results={@Result(name="json",type="json")})
	public String findGoodsGroupById(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			bean= this.goodsGroupTService.findByPK(GoodsGroupT.class, this.getGroupid());
			if(bean!=null){
				this.setGroupBeginTime(BaseTools.formateDbDate(bean.getGroupBeginTime()));
				this.setGroupEndTime(BaseTools.formateDbDate(bean.getGroupEndTime()));
				this.setBasepath(BaseTools.getBasePath()+"/");
				this.setSucflag(true);
				return JSON;
			}
		}
		return JSON;
	}
	/**
	 * 修改团购商品的信息
	 * @return
	 * @throws ParseException 
	 */
	@Action(value="updateGoodsGroup",results={@Result(name="json",type="json")})
	public String updateGoodsGroup() throws ParseException{
		if(StringUtils.isNotBlank(this.getGroupid())){
			GoodsGroupT ggt=this.goodsGroupTService.findByPK(GoodsGroupT.class, this.getGroupid());
			if(ggt!=null){
				ggt.setBargainprice(this.getBargainprice());
				ggt.setBrandid(this.getBrandid());
				ggt.setBrandname(this.getBrandname());
				ggt.setCommoditylist(this.getCommoditylist());
				ggt.setCost(this.getCost());
				ggt.setCreatorid(BaseTools.getAdminCreateId());
				ggt.setGoodsParameterValue(this.getGoodsParameterValue());
				ggt.setGoodsTypeId(this.getGoodsTypeId());
				ggt.setGoodsTypeName(this.getGoodsTypeName());
				ggt.setGoodsid(this.getGoodsid());
				ggt.setGoodsname(this.getGoodsname());
				ggt.setGroupBeginTime(BaseTools.formatString2DataYYYMMDDHHMMSS(this.getGroupBeginTime()));
				ggt.setGroupEndTime(BaseTools.formatString2DataYYYMMDDHHMMSS(this.getGroupEndTime()));
				ggt.setGroupNeedPointsLimit(this.getGroupNeedPointsLimit());
				ggt.setGroupname(this.getGroupname());
				ggt.setGroupprice(this.getGroupprice());
				ggt.setHotsale(this.getHotsale());
				ggt.setHtmlPath(StaticKey.EMPTY);
				ggt.setIsNew(this.getIsNew());
				ggt.setIsmobileplatformgoods(this.getIsmobileplatformgoods());
				ggt.setIsoutsite(this.getIsoutsite());
				ggt.setIsvirtualsale(this.getIsvirtualsale());
				ggt.setKeywords(this.getMetaKeywords());
				ggt.setLimitBuy(this.getLimitBuy());
				ggt.setMainPicture(this.getMainPicture());
				ggt.setMainSmallPicture(this.getMainSmallPicture());
				ggt.setMemberprice(this.getMemberprice());
				ggt.setMetaDescription(this.getMetaDescription());
				ggt.setMetaKeywords(this.getMetaKeywords());
				ggt.setOutsitelink(this.getOutsitelink());
				ggt.setPictures(this.getPictures());
				ggt.setPrice(this.getPrice());
				ggt.setReadcount(this.getReadcount());
				ggt.setRealOrdersCount(0);
				ggt.setRecommended(this.getRecommended());
				ggt.setSaleprice(this.getSaleprice());
				ggt.setSalestate(this.getSalestate());
				ggt.setShopid(BaseTools.getShopId());
				ggt.setShopname(BaseTools.getShopName());
				ggt.setSmallPictures(this.getSmallPictures());
				ggt.setSort(this.getSort());
				ggt.setSubgroupname(this.getSubgroupname());
				ggt.setTotalcomment(this.getTotalcomment());
				ggt.setUpdatetime(BaseTools.getSystemTime());
				ggt.setUsersetnum(this.getUsersetnum());
				ggt.setVirtualOrdersCount(this.getVirtualOrdersCount());
				ggt.setVersiont(ggt.getVersiont()+1);
				ggt.setNname(this.getNname());
				ggt.setLname(this.getLname());
				ggt.setSname(this.getSname());
				ggt.setFname(StaticKey.EMPTY);
				ggt.setNavid(this.getNavid());
				ggt.setLtypeid(this.getLtypeid());
				ggt.setStypeid(this.getStypeid());
				this.goodsGroupTService.updateGoodsGroupProcess(ggt, this.getDetail(), this.getGoodsAttrsVals());
				this.setSucflag(true);
				return JSON;
			}
		}
		return JSON;
	}
	/**
	 * 根据groupid批量删除团购商品
	 * @return
	 */
	@Action(value="delGoodsGroup",results={@Result(name="json",type="json")})
	public String delGoodsGroup(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			String []strs = StringUtils.split(this.getGroupid(), StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsGroupT ggt=this.goodsGroupTService.findByPK(GoodsGroupT.class, s);
				if(ggt!=null){
					this.goodsGroupTService.delete(ggt);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
	}
	/**
	 * 修改团购状态
	 * @return
	 */
	@Action(value="updateState",results={@Result(name="json",type="json")})
	public String updateState(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			GoodsGroupT ggt=this.goodsGroupTService.findByPK(GoodsGroupT.class, this.getGroupid());
			if(ggt!=null){
				ggt.setSalestate(BaseEnums.GoodsSaleState.UNSALE.getState());
				this.goodsGroupTService.update(ggt);
				this.setSucflag(true);
			}
		}
		return JSON;
		
	}
	/**
	 * 根据团购商品状态是“1”的 获取商品信息
	 * @return
	 */
	@Action(value="findGoodsGroupByState",results={@Result(name="json", type="json")})
	public String findGoodsGroupByState(){
		Criterion criterion=Restrictions.eq("salestate", BaseEnums.GoodsSaleState.SALE.getState());
		List<GoodsGroupT> list =this.goodsGroupTService.findByCriteria(GoodsGroupT.class, criterion);
		if(!list.isEmpty()){
			this.setSucflag(true);
			return JSON;
		}
		return JSON;
	}
	
	/**
	 * 更新商品团购上架状态
	 * @return
	 */
	@Action(value = "updateGoodsGroupsalestate", results = { @Result(name = "json", type = "json") })
	public String updateGoodsGroupsalestate(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			String strs[]=StringUtils.split(this.getGroupid(), StaticKey.SPLITDOT);
			for(String s:strs){
				Criterion criterion =Restrictions.eq("groupid", s);
				GoodsGroupT bean=this.goodsGroupTService.findOneByCriteria(GoodsGroupT.class, criterion);
				if(bean!=null){
					bean.setSalestate(this.getSalestate());
					this.goodsGroupTService.update(bean);
					this.setSucflag(true);
				}
			}
		}
		return JSON;
	}
	
	
	/**
	 * 更新特价标记
	 * @return
	 */
	@Action(value="updateGoodsGroupbargainprice",results={@Result(name="json", type="json")})
	public String updateGoodsGroupbargainprice(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			String strs[]=StringUtils.split(this.getGroupid(), StaticKey.SPLITDOT);
			for(String s:strs){
				Criterion criterion =Restrictions.eq("groupid", s);
				GoodsGroupT bean=this.goodsGroupTService.findOneByCriteria(GoodsGroupT.class, criterion);
				if(bean!=null){
					bean.setBargainprice(this.getBargainprice());
					this.goodsGroupTService.update(bean);
					this.setSucflag(true);
				}
			}
		}
		return JSON;
	}
	
	
	
	
	/**
	 * 更新热销标记
	 * @return
	 */
	@Action(value="updateGoodsGrouphotsale",results={@Result(name="json", type="json")})
	public String updateGoodsGrouphotsale(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			String strs[]=StringUtils.split(this.getGroupid(), StaticKey.SPLITDOT);
			for(String s:strs){
				Criterion criterion =Restrictions.eq("groupid", s);
				GoodsGroupT bean=this.goodsGroupTService.findOneByCriteria(GoodsGroupT.class, criterion);
				if(bean!=null){
					bean.setHotsale(this.getHotsale());
					this.goodsGroupTService.update(bean);
					this.setSucflag(true);
				}
			}
		}
		return JSON;
	}
	

	/**
	 * 更新推荐标记
	 * @return
	 */
	@Action(value="updateGoodsGrouprecommend",results={@Result(name="json", type="json")})
	public String updateGoodsGrouprecommend(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			String strs[]=StringUtils.split(this.getGroupid(), StaticKey.SPLITDOT);
			for(String s:strs){
				Criterion criterion =Restrictions.eq("groupid", s);
				GoodsGroupT bean=this.goodsGroupTService.findOneByCriteria(GoodsGroupT.class, criterion);
				if(bean!=null){
					bean.setRecommended(this.getRecommended());
					this.goodsGroupTService.update(bean);
					this.setSucflag(true);
				}
			}
		}
		return JSON;
	}
	/**
	 * 更新新品标记
	 * @return
	 */
	@Action(value="updateGoodsGroupisnew",results={@Result(name="json", type="json")})
	public String updateGoodsGroupisnew(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			String strs[]=StringUtils.split(this.getGroupid(), StaticKey.SPLITDOT);
			for(String s:strs){
				Criterion criterion =Restrictions.eq("groupid", s);
				GoodsGroupT bean=this.goodsGroupTService.findOneByCriteria(GoodsGroupT.class, criterion);
				if(bean!=null){
					bean.setIsNew(this.getIsNew());
					this.goodsGroupTService.update(bean);
					this.setSucflag(true);
				}
			}
		}
		return JSON;
	}
	
	/**
	 * 更新移动平台商品标记
	 * @return
	 */
	@Action(value="updateGoodsGroupismobileplatform",results={@Result(name="json", type="json")})
	public String updateGoodsGroupismobileplatform(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			String strs[]=StringUtils.split(this.getGroupid(), StaticKey.SPLITDOT);
			for(String s:strs){
				Criterion criterion =Restrictions.eq("groupid", s);
				GoodsGroupT bean=this.goodsGroupTService.findOneByCriteria(GoodsGroupT.class, criterion);
				if(bean!=null){
					bean.setIsmobileplatformgoods(this.getIsmobileplatformgoods());
					this.goodsGroupTService.update(bean);
					this.setSucflag(true);
				}
			}
		}
		return JSON;
	}
	
	
	/**
	 * 重置商品团购标记
	 * @return
	 */
	@Action(value="resetGoodsGroupState",results={@Result(name="json", type="json")})
	public String resetGoodsGroupState(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			String strs[]=StringUtils.split(this.getGroupid(), StaticKey.SPLITDOT);
			for(String s:strs){
				Criterion criterion =Restrictions.eq("groupid", s);
				GoodsGroupT bean=this.goodsGroupTService.findOneByCriteria(GoodsGroupT.class, criterion);
				if(bean!=null){
					bean.setRecommended(this.getRecommended());
					bean.setHotsale(this.getHotsale());
					bean.setBargainprice(this.getBargainprice());
					bean.setIsNew(this.getIsNew());
					bean.setIsmobileplatformgoods(this.getIsmobileplatformgoods());
					this.goodsGroupTService.update(bean);
					this.setSucflag(true);
				}
			}
		}
		return JSON;
	}
}
