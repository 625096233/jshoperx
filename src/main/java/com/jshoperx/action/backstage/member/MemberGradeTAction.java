package com.jshoperx.action.backstage.member;

import com.jshoperx.action.backstage.base.BaseTAction;
import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.enums.BaseEnums;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.jshoperx.entity.MemberGradeT;
import com.jshoperx.service.MemberGradeTService;
import com.jshoperx.service.impl.Serial;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Order;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.*;
@Namespace("")
@ParentPackage("jshoperx")
public class MemberGradeTAction extends BaseTAction {

	private static final long serialVersionUID = 1L;
	@Resource
	private MemberGradeTService memberGradeTService;
	private String id;
	private String type;
	private String name;
	private double start;
	private double end;
	private Double increment;
	private Double multiplypower;
	private String mpstate;
	private Double mpchangepower;
	private Date updatetime;
	private int versiont;
	private Double discount;
	private MemberGradeT bean = new MemberGradeT();
	private List<MemberGradeT>beanlist=new ArrayList<MemberGradeT>();
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}

	public Double getIncrement() {
		return increment;
	}

	public void setIncrement(Double increment) {
		this.increment = increment;
	}

	public Double getMultiplypower() {
		return multiplypower;
	}

	public void setMultiplypower(Double multiplypower) {
		this.multiplypower = multiplypower;
	}

	public String getMpstate() {
		return mpstate;
	}

	public void setMpstate(String mpstate) {
		this.mpstate = mpstate;
	}

	public Double getMpchangepower() {
		return mpchangepower;
	}

	public void setMpchangepower(Double mpchangepower) {
		this.mpchangepower = mpchangepower;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public int getVersiont() {
		return versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public MemberGradeT getBean() {
		return bean;
	}

	public void setBean(MemberGradeT bean) {
		this.bean = bean;
	}

	public List<MemberGradeT> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<MemberGradeT> beanlist) {
		this.beanlist = beanlist;
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

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}


	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加用户等级信息
	 * 
	 * @return
	 */
	@Action(value = "addMemberGradeT", results = { @Result(name = "json", type = "json") })
	public String addMemberGradeT() {
		MemberGradeT mgt = new MemberGradeT();
		mgt.setId(this.getSerial().Serialid(Serial.MEMBERGRADE));
		mgt.setType(this.getType());
		mgt.setName(this.getName());
		mgt.setStart(this.getStart());
		mgt.setEnd(this.getEnd());
		mgt.setIncrement(this.getIncrement());
		mgt.setMultiplypower(this.getMultiplypower());
		mgt.setMpstate(this.getMpstate());
		mgt.setMpchangepower(this.getMpchangepower());
		mgt.setDiscount(this.getDiscount());
		mgt.setCreatetime(BaseTools.getSystemTime());
		mgt.setCreatorid(BaseTools.getAdminCreateId());
		mgt.setUpdatetime(mgt.getCreatetime());
		mgt.setVersiont(0);
		this.memberGradeTService.save(mgt);
		this.setSucflag(true);
		return JSON;
	}

	/**
	 * 查询所有用户等级设定信息
	 * 
	 * @return
	 */
	@Action(value = "findAllMemberGradeT", results = { @Result(name = "json", type = "json") })
	public String findAllMemberGradeT() {
		if(StaticKey.SC.equals(this.getQtype())){
			this.findDefaultAllMemberGradeT();
		}else{
			if(StringUtils.isBlank(this.getQuery())){
				return JSON;
			}else{
				return JSON;
			}
		}
		
		return JSON;
	}

	private void findDefaultAllMemberGradeT() {
		int currentPage=page;
		int lineSize=rp;
		total=this.memberGradeTService.count(MemberGradeT.class).intValue();
		Order order=Order.desc("createtime");
		List<MemberGradeT>list=this.memberGradeTService.findByCriteriaByPage(MemberGradeT.class, order, currentPage, lineSize);
		this.processMemberGradeTList(list);
	}

	private void processMemberGradeTList(List<MemberGradeT> list) {
		for(Iterator<MemberGradeT> it=list.iterator();it.hasNext();){
			MemberGradeT mgt=(MemberGradeT) it.next();
			mgt.setType(BaseEnums.MemberGradeType.getName(mgt.getType()));
			mgt.setMpstate(BaseEnums.DataUsingState.getName(mgt.getMpstate()));
			Map<String,Object>cellMap=new HashMap<String, Object>();
			cellMap.put("id", mgt.getId());
			cellMap.put("cell", new Object[]{
				mgt.getType(),
				mgt.getName(),
				mgt.getDiscount(),
				mgt.getStart(),
				mgt.getEnd(),
				mgt.getIncrement(),
				mgt.getMultiplypower(),
				mgt.getMpchangepower(),
				mgt.getMpstate(),
				mgt.getCreatetime(),
				mgt.getCreatorid(),
				"<a id='editmembergrade' name='editmembergrade' href='membergrade.jsp?operate=edit&id="+mgt.getId()+"'>编辑</a>"				
			});
			rows.add(cellMap);
			
		}
	}

	/**
	 * 根据用户等级id获取用户等级设置信息
	 * 
	 * @return
	 */
	@Action(value = "findMemberGradeTById", results = { @Result(name = "json", type = "json") })
	public String findMemberGradeTById() {
		if(StringUtils.isBlank(this.getId())){
			return JSON;
		}
		bean=this.memberGradeTService.findByPK(MemberGradeT.class, this.getId());
		if(bean!=null){
			this.setSucflag(true);
		}
		return JSON;
	}

	/**
	 * 更新会员等级设置
	 * 
	 * @return
	 */
	@Action(value = "updateMemberGradeTById", results = { @Result(name = "json", type = "json") })
	public String updateMemberGradeTById() {
		if(StringUtils.isBlank(this.getId())){
			return JSON;
		}
		bean=this.memberGradeTService.findByPK(MemberGradeT.class, this.getId());
		bean.setType(this.getType());
		bean.setName(this.getName());
		bean.setStart(this.getStart());
		bean.setEnd(this.getEnd());
		bean.setIncrement(this.getIncrement());
		bean.setMultiplypower(this.getMultiplypower());
		bean.setMpstate(this.getMpstate());
		bean.setMpchangepower(this.getMpchangepower());
		bean.setUpdatetime(BaseTools.getSystemTime());
		bean.setVersiont(bean.getVersiont()+1);
		bean.setDiscount(this.getDiscount());
		bean.setCreatorid(BaseTools.getAdminCreateId());
		this.memberGradeTService.update(bean);
		this.setSucflag(true);
		return JSON;
	}
	/**
	 * 批量删除会员等级设置
	 * @return
	 */
	@Action(value = "delMemberGradeT", results = { @Result(name = "json", type = "json") })
	public String delMemberGradeT(){
		if(StringUtils.isBlank(this.getId())){
			return JSON;
		}
		String strs[]=StringUtils.split(this.getId(), StaticKey.SPLITDOT);
		for(String s:strs){
			MemberGradeT mgt=this.memberGradeTService.findByPK(MemberGradeT.class, s);
			if(mgt!=null){
				this.memberGradeTService.delete(mgt);
			}
		}
		this.setSucflag(true);
		return JSON;
	}
	/**
	 * 获取所有等级信息用于select控件
	 * @return
	 */
	@Action(value = "findAllGradeForselect", results = { @Result(name = "json", type = "json") })
	public String findAllGradeForselect(){
		List<MemberGradeT>list=this.memberGradeTService.findAll(MemberGradeT.class);
		if(!list.isEmpty()){
			this.setSucflag(true);
			this.setBeanlist(list);
		}
		return JSON;
	}
	
	
}
