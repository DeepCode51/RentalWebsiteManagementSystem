package com.entity.vo;

import com.entity.ZaixianqianyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 在线签约
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-03-11 14:12:56
 */
public class ZaixianqianyueVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 房屋名称
	 */
	
	private String fangwumingcheng;
		
	/**
	 * 房屋类型
	 */
	
	private String fangwuleixing;
		
	/**
	 * 小区
	 */
	
	private String xiaoqu;
		
	/**
	 * 月租价格
	 */
	
	private String yuezujiage;
		
	/**
	 * 租赁月数
	 */
	
	private String zulinyueshu;
		
	/**
	 * 租赁金额
	 */
	
	private Integer zulinjine;
		
	/**
	 * 押金
	 */
	
	private Integer yajin;
		
	/**
	 * 合同金额
	 */
	
	private String hetongjine;
		
	/**
	 * 生效日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shengxiaoriqi;
		
	/**
	 * 有效期至
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date youxiaoqizhi;
		
	/**
	 * 合同内容
	 */
	
	private String hetongneirong;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
	/**
	 * 设置：房屋名称
	 */
	 
	public void setFangwumingcheng(String fangwumingcheng) {
		this.fangwumingcheng = fangwumingcheng;
	}
	
	/**
	 * 获取：房屋名称
	 */
	public String getFangwumingcheng() {
		return fangwumingcheng;
	}
				
	
	/**
	 * 设置：房屋类型
	 */
	 
	public void setFangwuleixing(String fangwuleixing) {
		this.fangwuleixing = fangwuleixing;
	}
	
	/**
	 * 获取：房屋类型
	 */
	public String getFangwuleixing() {
		return fangwuleixing;
	}
				
	
	/**
	 * 设置：小区
	 */
	 
	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}
	
	/**
	 * 获取：小区
	 */
	public String getXiaoqu() {
		return xiaoqu;
	}
				
	
	/**
	 * 设置：月租价格
	 */
	 
	public void setYuezujiage(String yuezujiage) {
		this.yuezujiage = yuezujiage;
	}
	
	/**
	 * 获取：月租价格
	 */
	public String getYuezujiage() {
		return yuezujiage;
	}
				
	
	/**
	 * 设置：租赁月数
	 */
	 
	public void setZulinyueshu(String zulinyueshu) {
		this.zulinyueshu = zulinyueshu;
	}
	
	/**
	 * 获取：租赁月数
	 */
	public String getZulinyueshu() {
		return zulinyueshu;
	}
				
	
	/**
	 * 设置：租赁金额
	 */
	 
	public void setZulinjine(Integer zulinjine) {
		this.zulinjine = zulinjine;
	}
	
	/**
	 * 获取：租赁金额
	 */
	public Integer getZulinjine() {
		return zulinjine;
	}
				
	
	/**
	 * 设置：押金
	 */
	 
	public void setYajin(Integer yajin) {
		this.yajin = yajin;
	}
	
	/**
	 * 获取：押金
	 */
	public Integer getYajin() {
		return yajin;
	}
				
	
	/**
	 * 设置：合同金额
	 */
	 
	public void setHetongjine(String hetongjine) {
		this.hetongjine = hetongjine;
	}
	
	/**
	 * 获取：合同金额
	 */
	public String getHetongjine() {
		return hetongjine;
	}
				
	
	/**
	 * 设置：生效日期
	 */
	 
	public void setShengxiaoriqi(Date shengxiaoriqi) {
		this.shengxiaoriqi = shengxiaoriqi;
	}
	
	/**
	 * 获取：生效日期
	 */
	public Date getShengxiaoriqi() {
		return shengxiaoriqi;
	}
				
	
	/**
	 * 设置：有效期至
	 */
	 
	public void setYouxiaoqizhi(Date youxiaoqizhi) {
		this.youxiaoqizhi = youxiaoqizhi;
	}
	
	/**
	 * 获取：有效期至
	 */
	public Date getYouxiaoqizhi() {
		return youxiaoqizhi;
	}
				
	
	/**
	 * 设置：合同内容
	 */
	 
	public void setHetongneirong(String hetongneirong) {
		this.hetongneirong = hetongneirong;
	}
	
	/**
	 * 获取：合同内容
	 */
	public String getHetongneirong() {
		return hetongneirong;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
