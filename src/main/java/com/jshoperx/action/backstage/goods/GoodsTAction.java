package com.jshoperx.action.backstage.goods;


import com.jshoperx.action.backstage.base.BaseTAction;
import com.jshoperx.action.backstage.base.DataCollectionTAction;
import com.jshoperx.action.backstage.staticspage.CreateHtml;
import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.enums.BaseEnums;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.*;
import com.jshoperx.service.*;
import com.jshoperx.service.impl.Serial;
import com.jshoperx.vo.GoodsParameterlistVo;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.*;
@Namespace("")
@ParentPackage("jshoperx")
public class GoodsTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private GoodsTService goodsTService;
	@Resource
	private ProductTService productTService;
	@Resource
	private ArticleTService articleTService;
	@Resource
	private ArticleCategoryTService articleCategoryTService;
	@Resource
	private JshopbasicInfoTService jshopbasicInfoTService;
	@Resource
	private SiteNavigationTService siteNavigationTService;
	@Resource
	private GoodsAttributeRpTService goodsAttributeRpTService;
	@Resource
	private GoodsDetailRpTService goodsDetailRpTService;
	@Resource
	private GoodsCommentTService goodsCommentTService;
	@Resource
	private GoodsTypeTNService goodsTypeTNService;
	@Resource
	private GoodsBelinkedTService goodsBelinkedTService;
	@Resource
	private CreateHtml createHtml;
	@Resource
	private DataCollectionTAction dataCollectionTAction;
	@Resource
	private GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService;
	@Resource
	private GoodsTwocodeRelationshipTService goodsTwocodeRelationshipTService;
	private String goodsid;
	private String goodsname;
	private String subgoodsname;
	private String brandname;
	private String nname;
	private String lname;
	private String sname;
	private String fname;
	private String navid;
	private String ltypeid;
	private String stypeid;
	private String price;
	private String memberprice;
	private String points;
	private String pictureurl;
	private String quantity;
	private String salestate;
	private String detail;
	private String keywordname;
	private String weight;
	private String readcount;
	private String relatedproductid;
	private String recommended;
	private String hotsale;
	private String bargainprice;
	private String sort;
	private Date createtime;
	private String creatorid;
	private String replycount;
	private String brandid;
	private String placeStore;
	private String metaKeywords;
	private String metaDescription;
	private String cost;
	private String saleprice;
	private String isNew;
	private String htmlPath;
	private String productSn;
	private String productName;
	private String unit;
	private String store;
	private String isDefault;
	private String isSalestate;
	private String warehouseLocation;
	private String goodsParameterValue;
	private String freezeStore;
	private String keywordid;
	private String productplaceid;
	private String goodsTypeId;
	private String goodsTypeName;
	private String goodsAttrsVals;
	private String usersetnum;
	private String isSpecificationsOpen;
	private String specificationsValue;
	private String specificationsid;
	private String specificationsName;
	private String star;
	private String otherPath;
	private String pathName;
	private String staruser;
	private String totalcomment;
	private String ismobileplatformgoods;
	private String commoditylist;//清单
	private String belinkedgoodsid;//关联商品id串
	private String isvirtualsale;//是否虚拟商品标记
	private String virtualresults;//虚拟商品返回结果
	private String productid;
	private String isoutsite;
	private String outsitelink;
	/**
	 * 原图主图
	 */
	private String mainPicture;
	/**
	 * 缩略图主图
	 */
	private String mainSmallPicture;
	/**
	 * 多张缩略图不包含缩略图主图
	 */
	private String smallPictures;
	private String rejson;
	private GoodsT bean = new GoodsT();
	private GoodsT gt = new GoodsT();
	private List<GoodsT>beanlist=new ArrayList<GoodsT>();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private Map<String, Object> map = new HashMap<String, Object>();
	private List<GoodsTypeTN>gtnlist=new ArrayList<GoodsTypeTN>();
	private GoodsTypeTN gtnbean=new GoodsTypeTN();
	private List<GoodsParameterlistVo>gmllist=new ArrayList<GoodsParameterlistVo>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private File fileupload;
	private String fileuploadFileName;
	private String allfilename;
	private String pcpath;
	private String twocodepath;
	private String basepath;
	private boolean sucflag;
	
	public String getSubgoodsname() {
		return subgoodsname;
	}

	public void setSubgoodsname(String subgoodsname) {
		this.subgoodsname = subgoodsname;
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

	public String getSmallPictures() {
		return smallPictures;
	}

	public void setSmallPictures(String smallPictures) {
		this.smallPictures = smallPictures;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	public String getTwocodepath() {
		return twocodepath;
	}

	public void setTwocodepath(String twocodepath) {
		this.twocodepath = twocodepath;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
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

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getNavid() {
		return navid;
	}

	public void setNavid(String navid) {
		this.navid = navid;
	}

	public String getLtypeid() {
		return ltypeid;
	}

	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}

	public String getStypeid() {
		return stypeid;
	}

	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getSalestate() {
		return salestate;
	}

	public void setSalestate(String salestate) {
		this.salestate = salestate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getKeywordname() {
		return keywordname;
	}

	public void setKeywordname(String keywordname) {
		this.keywordname = keywordname;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getRelatedproductid() {
		return relatedproductid;
	}

	public void setRelatedproductid(String relatedproductid) {
		this.relatedproductid = relatedproductid;
	}

	public String getRecommended() {
		return recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}

	public String getHotsale() {
		return hotsale;
	}

	public void setHotsale(String hotsale) {
		this.hotsale = hotsale;
	}

	public String getBargainprice() {
		return bargainprice;
	}

	public void setBargainprice(String bargainprice) {
		this.bargainprice = bargainprice;
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

	public String getBrandid() {
		return brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}

	public String getPlaceStore() {
		return placeStore;
	}

	public void setPlaceStore(String placeStore) {
		this.placeStore = placeStore;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	
	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	public String getProductSn() {
		return productSn;
	}

	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}

	public String getGoodsParameterValue() {
		return goodsParameterValue;
	}

	public void setGoodsParameterValue(String goodsParameterValue) {
		this.goodsParameterValue = goodsParameterValue;
	}

	public String getKeywordid() {
		return keywordid;
	}

	public void setKeywordid(String keywordid) {
		this.keywordid = keywordid;
	}

	public String getProductplaceid() {
		return productplaceid;
	}

	public void setProductplaceid(String productplaceid) {
		this.productplaceid = productplaceid;
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


	

	public GoodsT getBean() {
		return bean;
	}

	public void setBean(GoodsT bean) {
		this.bean = bean;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
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


	public File getFileupload() {
		return fileupload;
	}

	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}

	public String getFileuploadFileName() {
		return fileuploadFileName;
	}

	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}

	public String getAllfilename() {
		return allfilename;
	}

	public void setAllfilename(String allfilename) {
		this.allfilename = allfilename;
	}

	public String getPcpath() {
		return pcpath;
	}

	public void setPcpath(String pcpath) {
		this.pcpath = pcpath;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getUsersetnum() {
		return usersetnum;
	}

	public void setUsersetnum(String usersetnum) {
		this.usersetnum = usersetnum;
	}

	public String getIsSpecificationsOpen() {
		return isSpecificationsOpen;
	}

	public void setIsSpecificationsOpen(String isSpecificationsOpen) {
		this.isSpecificationsOpen = isSpecificationsOpen;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMemberprice() {
		return memberprice;
	}

	public void setMemberprice(String memberprice) {
		this.memberprice = memberprice;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getReadcount() {
		return readcount;
	}

	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getReplycount() {
		return replycount;
	}

	public void setReplycount(String replycount) {
		this.replycount = replycount;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(String saleprice) {
		this.saleprice = saleprice;
	}

	public String getFreezeStore() {
		return freezeStore;
	}

	public void setFreezeStore(String freezeStore) {
		this.freezeStore = freezeStore;
	}

	public String getRejson() {
		return rejson;
	}

	public void setRejson(String rejson) {
		this.rejson = rejson;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getStaruser() {
		return staruser;
	}

	public void setStaruser(String staruser) {
		this.staruser = staruser;
	}

	public String getTotalcomment() {
		return totalcomment;
	}

	public void setTotalcomment(String totalcomment) {
		this.totalcomment = totalcomment;
	}

	public String getIsmobileplatformgoods() {
		return ismobileplatformgoods;
	}

	public void setIsmobileplatformgoods(String ismobileplatformgoods) {
		this.ismobileplatformgoods = ismobileplatformgoods;
	}


	public String getSpecificationsValue() {
		return specificationsValue;
	}

	public void setSpecificationsValue(String specificationsValue) {
		this.specificationsValue = specificationsValue;
	}



	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getGoodsAttrsVals() {
		return goodsAttrsVals;
	}

	public void setGoodsAttrsVals(String goodsAttrsVals) {
		this.goodsAttrsVals = goodsAttrsVals;
	}

	public GoodsT getGt() {
		return gt;
	}

	public void setGt(GoodsT gt) {
		this.gt = gt;
	}

	public List<GoodsTypeTN> getGtnlist() {
		return gtnlist;
	}

	public void setGtnlist(List<GoodsTypeTN> gtnlist) {
		this.gtnlist = gtnlist;
	}

	public GoodsTypeTN getGtnbean() {
		return gtnbean;
	}

	public void setGtnbean(GoodsTypeTN gtnbean) {
		this.gtnbean = gtnbean;
	}

	public List<GoodsParameterlistVo> getGmllist() {
		return gmllist;
	}

	public void setGmllist(List<GoodsParameterlistVo> gmllist) {
		this.gmllist = gmllist;
	}
	
	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getCommoditylist() {
		return commoditylist;
	}

	public void setCommoditylist(String commoditylist) {
		this.commoditylist = commoditylist;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getSpecificationsid() {
		return specificationsid;
	}

	public void setSpecificationsid(String specificationsid) {
		this.specificationsid = specificationsid;
	}

	public String getSpecificationsName() {
		return specificationsName;
	}

	public void setSpecificationsName(String specificationsName) {
		this.specificationsName = specificationsName;
	}

	public List<GoodsT> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<GoodsT> beanlist) {
		this.beanlist = beanlist;
	}

	public String getBelinkedgoodsid() {
		return belinkedgoodsid;
	}

	public void setBelinkedgoodsid(String belinkedgoodsid) {
		this.belinkedgoodsid = belinkedgoodsid;
	}
	public String getIsvirtualsale() {
		return isvirtualsale;
	}

	public void setIsvirtualsale(String isvirtualsale) {
		this.isvirtualsale = isvirtualsale;
	}

	public String getVirtualresults() {
		return virtualresults;
	}

	public void setVirtualresults(String virtualresults) {
		this.virtualresults = virtualresults;
	}


	public String getIsSalestate() {
		return isSalestate;
	}

	public void setIsSalestate(String isSalestate) {
		this.isSalestate = isSalestate;
	}


	public String getOtherPath() {
		return otherPath;
	}

	public void setOtherPath(String otherPath) {
		this.otherPath = otherPath;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getIsoutsite() {
		return isoutsite;
	}

	public void setIsoutsite(String isoutsite) {
		this.isoutsite = isoutsite;
	}

	public String getOutsitelink() {
		return outsitelink;
	}

	public void setOutsitelink(String outsitelink) {
		this.outsitelink = outsitelink;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加商品
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@Action(value = "saveGoods", results = { @Result(name = "json", type = "json") })
	public String saveGoods()  {
		//构造goods
		GoodsT gt=new GoodsT();
		gt.setGoodsid(this.getSerial().Serialid(Serial.GOODS));
		gt.setGoodsTypeId(this.getGoodsTypeId());
		gt.setGoodsTypeName(this.getGoodsTypeName());
		gt.setGoodsParameterValue(this.getGoodsParameterValue());
		gt.setNavid(this.getNavid());
		gt.setNname(this.getNname());
		gt.setLtypeid(this.getLtypeid());
		gt.setLname(this.getLname());
		gt.setStypeid(this.getStypeid());
		gt.setSname(this.getSname());
		gt.setFname(this.getFname());
		gt.setGoodsname(this.getGoodsname());
		gt.setUsersetnum(this.getUsersetnum());
		gt.setBrandid(this.getBrandid());
		gt.setBrandname(this.getBrandname());
		gt.setCost(Double.parseDouble(this.getCost()));
		gt.setSaleprice(Double.parseDouble(this.getSaleprice()));
		gt.setMemberprice(Double.parseDouble(this.getMemberprice()));
		gt.setPrice(Double.parseDouble(this.getPrice()));
		gt.setPoints(Double.parseDouble(this.getPoints()));
		gt.setSort(Integer.parseInt(this.getSort()));
		gt.setIsNew(this.getIsNew());
		gt.setRecommended(this.getRecommended());
		gt.setHotsale(this.getHotsale());
		gt.setBargainprice(this.getBargainprice());
		gt.setIsvirtualsale(this.getIsvirtualsale());//是否虚拟商品标记，用于充值卡或者购物卡类没有实物的商品
		gt.setIsmobileplatformgoods(this.getIsmobileplatformgoods());
		gt.setSalestate(this.getSalestate());
		gt.setUnitname(StaticKey.EMPTY);
		gt.setKeywordname(StaticKey.EMPTY);
		gt.setWeight(StaticKey.EMPTY);
		gt.setRelatedproductid(StaticKey.EMPTY);
		gt.setPlaceStore(StaticKey.EMPTY);
		gt.setHtmlPath(StaticKey.EMPTY);
		gt.setProductSn(StaticKey.EMPTY);
		gt.setKeywordid(StaticKey.EMPTY);
		gt.setUnitnameid(StaticKey.EMPTY);
		gt.setSubgoodsname(this.getSubgoodsname());
		gt.setIsSpecificationsOpen(BaseEnums.SupportType.SUPPORT.getState());//默认支持规格值
		gt.setMainPicture(this.getMainPicture());
		gt.setMainSmallPicture(this.getMainSmallPicture());
		gt.setPictureurl(this.getPictureurl());
		gt.setSmallPictures(this.getSmallPictures());
		gt.setCommoditylist(this.getCommoditylist());
		gt.setMetaDescription(this.getMetaDescription());
		gt.setMetaKeywords(this.getMetaKeywords());
		gt.setCreatetime(BaseTools.getSystemTime());
		gt.setCreatorid(BaseTools.getAdminCreateId());
		gt.setUpdatetime(BaseTools.getSystemTime());
		gt.setIsoutsite(this.getIsoutsite());
		gt.setOutsitelink(this.getOutsitelink());
		gt.setIsgroup(StaticKey.EMPTY);
		gt.setIssecondkill(StaticKey.EMPTY);
		gt.setShopid(BaseTools.getShopId());
		gt.setShopname(BaseTools.getShopName());
		//构造goodsdetail和goods关系
		GoodsDetailRpT gdpt=new GoodsDetailRpT();
		gdpt.setId(this.getSerial().Serialid(Serial.GOODSDETAILRPT));
		gdpt.setDetail(this.getDetail());
		gdpt.setGoodsid(gt.getGoodsid());
		//构造product
		ProductT pt=new ProductT();
		pt.setProductid(this.getSerial().Serialid(Serial.PRODUCT));
		pt.setPrice(gt.getPrice());
		pt.setMemberprice(gt.getMemberprice());
		pt.setCost(gt.getCost());
		pt.setSaleprice(gt.getSaleprice());
		pt.setFreezeStore(0);
		pt.setStore(0);
		pt.setIsDefault(BaseEnums.IsDefault.DEFAULT.getState());//表示默认
		pt.setIsSalestate(BaseEnums.GoodsSaleState.SALE.getState());//表示对外销售状态
		pt.setProductName(gt.getGoodsname());
		pt.setProductSn(gt.getUsersetnum());
		pt.setSpecificationsValue(StaticKey.EMPTY);
		pt.setWarehouseLocation(StaticKey.EMPTY);
		pt.setPlaceStore(StaticKey.EMPTY);
		pt.setWeight(StaticKey.EMPTY);
		pt.setGoodsid(gt.getGoodsid());
		pt.setCreatorid(gt.getCreatorid());
		pt.setCreatetime(gt.getCreatetime());
		pt.setSpecificationsid(StaticKey.ZERO);//表示默认规格的值
		pt.setSpecificationsName(StaticKey.DEFAULTSPECIFNAME);//默认规格值名称
		pt.setUpdatetime(gt.getCreatetime());
		pt.setUnit(StaticKey.EMPTY);
		pt.setShopid(BaseTools.getShopId());
		//构造goodsspecificationproductrp
		GoodsSpecificationsProductRpT gspt=new GoodsSpecificationsProductRpT();
		gspt.setGoodsSpecificationsProductRpTid(this.getSerial().Serialid(Serial.GOODSSPECIFICATIONSPRODUCTRPT));
		gspt.setGoodsid(gt.getGoodsid());
		gspt.setProductid(pt.getProductid());
		gspt.setSpecidicationsid(StaticKey.ZERO);//0表示默认规格
		
		this.goodsTService.saveGoodsProcess(gt,gdpt,pt,gspt);
		this.saveGoodsAttributeRp(gt, this.getGoodsAttrsVals());
		this.setSucflag(true);
		return JSON;
	
		
		
	}
	/**
	 * 保存属性和商品关系
	 * @param gt
	 * @param goodsattrsval
	 */
	private void saveGoodsAttributeRp(GoodsT gt,String goodsattrsval){
		JSONArray ja=(JSONArray)JSONValue.parse(goodsattrsval);
		int jsonsize=ja.size();
		GoodsAttributeRpT gart=new GoodsAttributeRpT();
		for(int i=0;i<jsonsize;i++){
			gart.setId(this.getSerial().Serialid(Serial.GOODSATTRIBUTERPT));
			gart.setGoodsid(gt.getGoodsid());
			JSONObject jo=(JSONObject) ja.get(i);
			gart.setAttrval(jo.get(StaticKey.ATTRVAL).toString());
			this.goodsAttributeRpTService.save(gart);
		}
	}

	
	/**
	 * 根据用户id读取所有该用户增加的商品
	 * 
	 * @return
	 */
	@Action(value = "findAllGoods", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String findAllGoods() {
		if (StaticKey.SC.equals(this.getQtype())) {
			finddefaultAllGoods();
		} else {
			if(StringUtils.isNotBlank(this.getQtype())){
				if(this.getQtype().equals("goodsname")){
					findGoodsByGoodsname();
				}
			}
		}
		return JSON;

	}
	/**
	 * 根据商品名称查询商品
	 */
	private void findGoodsByGoodsname() {
		int currentPage=page;
		int lineSize=rp;
		Criterion criterion=Restrictions.like(this.getQtype(), this.getQuery().trim(), MatchMode.ANYWHERE);
		total=this.goodsTService.count(GoodsT.class, criterion).intValue();
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			List<GoodsT>list=this.goodsTService.findByCriteriaByPage(GoodsT.class, criterion, order, currentPage, lineSize);
			this.processGoodsList(list);
		}
	}

	/**
	 * 获取用户的所有商品信息
	 */
	private void finddefaultAllGoods() {
		int currentPage = page;
		int lineSize = rp;
		total=this.goodsTService.count(GoodsT.class).intValue();
		Order order=Order.desc("updatetime");
		List<GoodsT> list = this.goodsTService.findByCriteriaByPage(GoodsT.class, order, currentPage, lineSize);
		processGoodsList(list);
	}

	/**
	 * 迭代处理供前台显示
	 * 
	 * @param list
	 */
	public void processGoodsList(List<GoodsT> list) {
		rows.clear();
		this.setBasepath(BaseTools.getBasePath());
		for (Iterator<GoodsT> it = list.iterator(); it.hasNext();) {
			GoodsT gt = (GoodsT) it.next();
			if (gt.getRecommended().equals(BaseEnums.GoodsState.RECOMMENDED.getState())) {
				gt.setRecommended("<span class='truestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				gt.setRecommended("<span class='falsestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (gt.getHotsale().equals(BaseEnums.GoodsState.HOTSALE.getState())) {
				gt.setHotsale("<span class='truestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				gt.setHotsale("<span class='falsestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (gt.getBargainprice().equals(BaseEnums.GoodsState.BARGAINPRICE.getState())) {
				gt.setBargainprice("<span class='truestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				gt.setBargainprice("<span class='falsestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (gt.getIsNew().equals(BaseEnums.GoodsState.NEW.getState())) {
				gt.setIsNew("<span class='truestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				gt.setIsNew("<span class='falsestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (gt.getSalestate().equals(BaseEnums.GoodsSaleState.SALE.getState())) {
				gt.setSalestate("<span class='truestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				gt.setSalestate("<span class='falsestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}

			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", gt.getGoodsid());
			cellMap.put("cell", new Object[] {
					gt.getGoodsname(), 
					gt.getUsersetnum(), 
					gt.getMemberprice(),
					gt.getNname(),  
					gt.getSalestate(), 
					gt.getIsNew(), 
					gt.getBargainprice(), 
					gt.getHotsale(), 
					gt.getRecommended(), 
					gt.getQuantity(), 
					"<a id='editgoods' href='goods.jsp?operate=edit&folder=setting&goodsid="+gt.getGoodsid()+"' name='editgoods'>[编辑]</a>"});
			rows.add(cellMap);
		}
	}

	/**
	 * 根据商品id获取商品数据
	 * 
	 * @return
	 */
	@Action(value = "findGoodsById", results = { @Result(name = "json", type = "json",params = { "excludeNullProperties", "true","goods","bean"}) })
	public String findGoodsById() {
		if (StringUtils.isNotBlank(this.getGoodsid())) {
			bean = this.goodsTService.findByPK(GoodsT.class, this.getGoodsid());
			if (bean != null) {
				Criterion criterion=Restrictions.eq("goodsid", bean.getGoodsid());
				ProductT pt=this.productTService.findOneByCriteria(ProductT.class, criterion);
				if(pt!=null){
					this.setProductid(pt.getProductid());
				}
				this.setBasepath(BaseTools.getBasePath()+"/");
				this.setSucflag(true);
				return JSON;
			}
		}
		return JSON;
	}

	/**
	 * 更新文章静态路径
	 * 
	 * @param goodsid
	 * @param htmlPath
	 */
	public void updateHtmlPath(String goodsid, String htmlPath) {
		GoodsT gt=this.goodsTService.findByPK(GoodsT.class, goodsid);
		if(gt!=null){
			gt.setHtmlPath(htmlPath);
			this.goodsTService.update(gt);
		}
	
	}

	/**
	 * 更新商品
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@Action(value = "updateGoods", results = { @Result(name = "json", type = "json",params = { "excludeNullProperties", "true" }) })
	public String updateGoods() throws IOException, TemplateException {
		if(StringUtils.isNotBlank(this.getGoodsid())){
			bean=this.goodsTService.findByPK(GoodsT.class, this.getGoodsid());
			if(bean!=null){
				bean.setGoodsTypeId(this.getGoodsTypeId());
				bean.setGoodsTypeName(this.getGoodsTypeName());
				bean.setGoodsParameterValue(this.getGoodsParameterValue());
				bean.setNavid(this.getNavid());
				bean.setNname(this.getNname());
				bean.setLtypeid(this.getLtypeid());
				bean.setLname(this.getLname());
				bean.setStypeid(this.getStypeid());
				bean.setSname(this.getSname());
				bean.setFname(this.getFname());
				bean.setGoodsname(this.getGoodsname());
				bean.setUsersetnum(this.getUsersetnum());
				bean.setBrandid(this.getBrandid());
				bean.setBrandname(this.getBrandname());
				bean.setCost(Double.parseDouble(this.getCost()));
				bean.setSaleprice(Double.parseDouble(this.getSaleprice()));
				bean.setMemberprice(Double.parseDouble(this.getMemberprice()));
				bean.setPrice(Double.parseDouble(this.getPrice()));
				bean.setPoints(Double.parseDouble(this.getPoints()));
				bean.setSort(Integer.parseInt(this.getSort()));
				bean.setIsNew(this.getIsNew());
				bean.setRecommended(this.getRecommended());
				bean.setHotsale(this.getHotsale());
				bean.setBargainprice(this.getBargainprice());
				bean.setIsvirtualsale(this.getIsvirtualsale());
				bean.setIsmobileplatformgoods(this.getIsmobileplatformgoods());
				bean.setSalestate(this.getSalestate());
				bean.setPictureurl(this.getPictureurl());
				bean.setCommoditylist(this.getCommoditylist());
				bean.setMetaKeywords(this.getMetaKeywords());
				bean.setMetaDescription(this.getMetaDescription());
				bean.setCreatorid(BaseTools.getAdminCreateId());
				bean.setUpdatetime(BaseTools.getSystemTime());
				bean.setIsoutsite(this.getIsoutsite());
				bean.setOutsitelink(this.getOutsitelink());
				//构造product
				ProductT pt=new ProductT();
				//根据商品和规格货物关系，通过spid0和goodsid来取出addgoods时唯一对照的默认规格值的productdid进行级联更新
				//this.getGoodsSpecificationsProductRpTService().checkSpecificationRelationshipBygoodssetid(this.getGoodsid());
				pt=this.productTService.findByPK(ProductT.class, this.getProductid());
				pt.setPrice(bean.getPrice());
				pt.setMemberprice(bean.getMemberprice());
				pt.setCost(bean.getCost());
				pt.setSaleprice(bean.getSaleprice());
				pt.setFreezeStore(0);
				pt.setStore(0);
				pt.setIsDefault(BaseEnums.IsDefault.DEFAULT.getState());//表示默认
				pt.setIsSalestate(BaseEnums.GoodsSaleState.SALE.getState());//表示对外销售状态
				pt.setProductName(bean.getGoodsname());
				pt.setProductSn(bean.getUsersetnum());
				pt.setSpecificationsValue(StaticKey.EMPTY);
				pt.setWarehouseLocation(StaticKey.EMPTY);
				pt.setPlaceStore(StaticKey.EMPTY);
				pt.setWeight(StaticKey.EMPTY);
				pt.setGoodsid(bean.getGoodsid());
				pt.setCreatorid(bean.getCreatorid());
				pt.setCreatetime(bean.getCreatetime());
				pt.setSpecificationsid(StaticKey.ZERO);//表示默认规格的值
				pt.setSpecificationsName(StaticKey.DEFAULTSPECIFNAME);//默认规格值名称
				pt.setUpdatetime(bean.getCreatetime());
				pt.setUnit(StaticKey.EMPTY);
				pt.setShopid(BaseTools.getShopId());
				this.goodsTService.updateGoodsProcess(bean, this.getDetail(),pt);
				this.updateGoodsAttributeRp(bean, this.getGoodsAttrsVals());
				this.setSucflag(true);
				return JSON;
			}
		}
		return JSON;
		
	}

	/**
	 * 更新商品属性关系
	 * @param gt
	 * @param goodsattrvals
	 */
	private void updateGoodsAttributeRp(GoodsT gt,String goodsattrvals){
		Criterion criterion=Restrictions.eq("goodsid", gt.getGoodsid());
		GoodsAttributeRpT garpt=this.goodsAttributeRpTService.findOneByCriteria(GoodsAttributeRpT.class, criterion);
		if(garpt!=null){
			this.goodsAttributeRpTService.delete(garpt);
			JSONArray ja=(JSONArray)JSONValue.parse(goodsattrvals);
			int jsonsize=ja.size();
			GoodsAttributeRpT gart=new GoodsAttributeRpT();
			for(int i=0;i<jsonsize;i++){
				gart.setId(this.getSerial().Serialid(Serial.GOODSATTRIBUTERPT));
				gart.setGoodsid(gt.getGoodsid());
				JSONObject jo=(JSONObject) ja.get(i);
				gart.setAttrval(jo.get(StaticKey.ATTRVAL).toString());
				this.goodsAttributeRpTService.save(gart);
			}
		}
	}
	
	/**
	 * 删除商品同时删除商品对应的货品
	 * 
	 * @return
	 */
	@Action(value = "delGoods", results = { @Result(name = "json", type = "json") })
	//判断是否上架
	public String delGoods() {
		if (StringUtils.isNotBlank(this.getGoodsid())) {
			String[] strs = StringUtils.split(this.getGoodsid(), StaticKey.SPLITDOT);
			for (String s:strs) {
				ProductT pt=this.productTService.findByPK(ProductT.class, s);
				if(pt!=null){
					this.productTService.delete(pt);
				}
				GoodsT gt=this.goodsTService.findByPK(GoodsT.class,s);
				if(gt!=null){
					this.goodsTService.delete(gt);
				}
			}
			this.setSucflag(true);
		} 
		return "json";
	}

	/**
	 * 根据goodsid更新上下架状态
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsSaleState", results = { @Result(name = "json", type = "json") })
	public String updateGoodsSaleState() {
		if (StringUtils.isNotBlank(this.getGoodsid())) {
			String[] strs = StringUtils.split(this.getGoodsid(), StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsT gt=this.goodsTService.findByPK(GoodsT.class, s);
				if(gt!=null){
					gt.setSalestate(this.getSalestate());
					this.goodsTService.update(gt);
				}
			}
			this.setSucflag(true);
			}
		return JSON;
	}

	/**
	 * 根据goodsid更新特价商品
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsbargainprice", results = { @Result(name = "json", type = "json") })
	public String updateGoodsbargainprice() {
		if (StringUtils.isNotBlank(this.getGoodsid())) {
			String[] strs = StringUtils.split(this.getGoodsid(), StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsT gt=this.goodsTService.findByPK(GoodsT.class, s);
				if(gt!=null){
					gt.setBargainprice(this.getBargainprice());
					this.goodsTService.update(gt);
				}
			}
			this.setSucflag(true);
			}
		return JSON;
	}

	/**
	 * 根据goodsid更新热销商品
	 * 
	 * @return
	 */
	@Action(value = "updateGoodshotsale", results = { @Result(name = "json", type = "json") })
	public String updateGoodshotsale() {
		if (StringUtils.isNotBlank(this.getGoodsid())) {
			String[] strs = StringUtils.split(this.getGoodsid(), StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsT gt=this.goodsTService.findByPK(GoodsT.class, s);
				if(gt!=null){
					gt.setHotsale(this.getHotsale());
					this.goodsTService.update(gt);
				}
			}
			this.setSucflag(true);
			}
		return JSON;
	}

	/**
	 * 根据goodsid更新推荐商品
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsrecommended", results = { @Result(name = "json", type = "json") })
	public String updateGoodsrecommended() {
		if (StringUtils.isNotBlank(this.getGoodsid())) {
			String[] strs = StringUtils.split(this.getGoodsid(), StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsT gt=this.goodsTService.findByPK(GoodsT.class, s);
				if(gt!=null){
					gt.setRecommended(this.getRecommended());
					this.goodsTService.update(gt);
				}
			}
			this.setSucflag(true);
			}
		return JSON;
	}

	/**
	 * 根据goodsid更新新品商品
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsisNew", results = { @Result(name = "json", type = "json") })
	public String updateGoodsisNew() {
		if (StringUtils.isNotBlank(this.getGoodsid())) {
			String[] strs = StringUtils.split(this.getGoodsid(), StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsT gt=this.goodsTService.findByPK(GoodsT.class, s);
				if(gt!=null){
					gt.setIsNew(this.getIsNew());
					this.goodsTService.update(gt);
				}
			}
			this.setSucflag(true);
			}
		return JSON;
	}

	/**
	 * 根据商品id更新是否同步到移动平台
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsismobileplatformgoods", results = { @Result(name = "json", type = "json") })
	public String updateGoodsismobileplatformgoods() {
		if (StringUtils.isNotBlank(this.getGoodsid())) {
			String[] strs = StringUtils.split(this.getGoodsid(), StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsT gt=this.goodsTService.findByPK(GoodsT.class, s);
				if(gt!=null){
					gt.setIsmobileplatformgoods(this.getIsmobileplatformgoods());
					this.goodsTService.update(gt);
				}
			}
			this.setSucflag(true);
			}
		return JSON;
	}

	/**
	 * 根据商品id更新5种商品状态
	 * 
	 * @return
	 */
	@Action(value = "updateFiveGoodsState", results = { @Result(name = "json", type = "json") })
	public String updateFiveGoodsState() {
		if (StringUtils.isNotBlank(this.getGoodsid())) {
			String[] strs = StringUtils.split(this.getGoodsid(), StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsT gt=this.goodsTService.findByPK(GoodsT.class, s);
				if(gt!=null){
					gt.setRecommended(this.getRecommended());
					gt.setHotsale(this.getHotsale());
					gt.setBargainprice(this.getBargainprice());
					gt.setIsNew(this.getIsNew());
					gt.setIsmobileplatformgoods(this.getIsmobileplatformgoods());
					this.goodsTService.update(gt);
				}
			}
			this.setSucflag(true);
			}
		return JSON;
	}

	/**
	 * 增加星级评分
	 * 
	 * @return
	 */
	@Action(value = "updatestarsumBygoodsid", results = { @Result(name = "json", type = "json") })
	public String updatestarsumBygoodsid() {
		if(StringUtils.isNotBlank(this.getGoodsid())){
			GoodsT gt=this.goodsTService.findByPK(GoodsT.class, this.getGoodsid());
			if(gt!=null){
				gt.setTotalstar(Integer.parseInt(this.getStar()));
				this.goodsTService.update(gt);
				this.setSucflag(true);
			}
		}
		return JSON;
	}

	/**
	 * 更新商品总打分人数
	 * 
	 * @return
	 */
	@Action(value = "updatestarusersumBygoodsid", results = { @Result(name = "json", type = "json") })
	public String updatestarusersumBygoodsid() {
		if(StringUtils.isNotBlank(this.getGoodsid())){
			GoodsT gt=this.goodsTService.findByPK(GoodsT.class, this.getGoodsid());
			if(gt!=null){
				gt.setTotalstaruser(Integer.parseInt(this.getStaruser()));
				this.goodsTService.update(gt);
				this.setSucflag(true);
			}
		}
		return JSON;
	}

	/**
	 * 更新商品总评分人数
	 * 
	 * @return
	 */
	@Action(value = "updatecommentsumBygoodsid", results = { @Result(name = "json", type = "json") })
	public String updatecommentsumBygoodsid() {
		if(StringUtils.isNotBlank(this.getGoodsid())){
			GoodsT gt=this.goodsTService.findByPK(GoodsT.class, this.getGoodsid());
			if(gt!=null){
				gt.setTotalcomment(Integer.parseInt(this.getTotalcomment()));
				this.goodsTService.update(gt);
				this.setSucflag(true);
			}
		}
		return JSON;
	}
	

	
	/**
	 * 根据顶级分类获取商品列表传送到前台给关联商品部分
	 * @return
	 */
	@Action(value = "findAllGoodsByCategory", results = { @Result(name = "json", type = "json") })
	public String findAllGoodsByCategory(){
		if(!StaticKey.FONE.equals(this.getNavid())&&StaticKey.FONE.equals(this.getLtypeid())&&StaticKey.FONE.equals(this.getStypeid())){
			String navid=this.getNavid().trim();
			String salestate= BaseEnums.GoodsSaleState.SALE.getState();//上架
			String isSpecificationsOpen= BaseEnums.SupportType.SUPPORT.getState();//默认都支持规格
			Map<String,String>params=new HashMap<String, String>();
			params.put("navid", navid);
			params.put("salestate", salestate);
			params.put("isSpecificationsOpen", isSpecificationsOpen);
			Criterion criterion=Restrictions.allEq(params);
			total=this.goodsTService.count(GoodsT.class, criterion).intValue();
			List<GoodsT>list=this.goodsTService.findByCriteria(GoodsT.class, criterion);
			this.processGoodsList(list);
			this.setSucflag(true);
			return JSON;
		}
		if(!StaticKey.FONE.equals(this.getNavid())&&!StaticKey.FONE.equals(this.getLtypeid())&&StaticKey.FONE.equals(this.getStypeid())){
			String navid=this.getNavid().trim();
			String ltypeid=this.getLtypeid().trim();
			String salestate= BaseEnums.GoodsSaleState.SALE.getState();//上架
			String isSpecificationsOpen= BaseEnums.SupportType.SUPPORT.getState();//开启规格
			Map<String,String>params=new HashMap<String, String>();
			params.put("navid", navid);
			params.put("ltypeid", ltypeid);
			params.put("salestate", salestate);
			params.put("isSpecificationsOpen", isSpecificationsOpen);
			Criterion criterion=Restrictions.allEq(params);
			total=this.goodsTService.count(GoodsT.class, criterion).intValue();
			List<GoodsT>list=this.goodsTService.findByCriteria(GoodsT.class, criterion);
			this.processGoodsList(list);
			this.setSucflag(true);
			return JSON;
		}
		if(!StaticKey.FONE.equals(this.getNavid())&&!StaticKey.FONE.equals(this.getLtypeid())&&!StaticKey.FONE.equals(this.getStypeid())){
			String navid=this.getNavid().trim();
			String ltypeid=this.getLtypeid().trim();
			String stypeid=this.getStypeid().trim();
			String salestate= BaseEnums.GoodsSaleState.SALE.getState();//上架
			String isSpecificationsOpen= BaseEnums.SupportType.SUPPORT.getState();//开启规格
			Map<String,String>params=new HashMap<String, String>();
			params.put("navid", navid);
			params.put("ltypeid", ltypeid);
			params.put("stypeid", stypeid);
			params.put("salestate",salestate);
			params.put("isSpecificationsOpen", isSpecificationsOpen);
			Criterion criterion=Restrictions.allEq(params);
			total=this.goodsTService.count(GoodsT.class, criterion).intValue();
			List<GoodsT>list=this.goodsTService.findByCriteria(GoodsT.class, criterion);
			this.processGoodsList(list);
			this.setSucflag(true);
			return JSON;
		}
		return JSON;
	}
	

	/**
	 * 根据商品名称搜索商品
	 * @return
	 */
	@Action(value = "searchGoodsBygoodsname", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String searchGoodsBygoodsname(){
		if(StringUtils.isBlank(this.getGoodsname())){
			return JSON;
		}
		int currentPage=page;
		int lineSize=rp;
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			Criterion criterion=Restrictions.like("goodsname", this.getGoodsname(),MatchMode.ANYWHERE);
			beanlist=this.goodsTService.findByCriteriaByPage(GoodsT.class, criterion, order, currentPage, lineSize);
			this.processGoodsList(beanlist);
			this.setSucflag(true);
		}
		return "json";
		
	}
	
}
