package com.chinasofti.mall.common.entity.order;

import java.math.BigDecimal;

import com.chinasofti.mall.common.utils.PageBean;

/**
 * @ClassName: PyChildGoodsorder
 * @Description: 子订单实体类
 * @author tanjl
 * @Version V1.0
 * @date 2017年11月7日 下午1:00:04
 */
public class PyChildGoodsorder extends PageBean {
	/**
	 * @Fields ids : 主键
	 */
	private String ids;

	/**
	 * @Fields mainorderIds : 主订单号
	 */
	private String mainorderIds;

	/**
	 * @Fields goodsids : 商品编号
	 */
	private String goodsids;

	/**
	 * @Fields custIds : 用户id
	 */
	private String custIds;

	/**
	 * @Fields orderStatus :状态\r\n\r\n部分退货\r\n
	 */
	private String orderStatus;

	/**
	 * @Fields goodsNum : 商品数量
	 */
	private BigDecimal goodsNum;

	/**
	 * @Fields goodsPrice : 商品单价
	 */
	private BigDecimal goodsPrice;

	/**
	 * @Fields discount : 折扣
	 */
	private BigDecimal discount;

	/**
	 * @Fields orderRealAmt : 实付金额
	 */
	private BigDecimal orderRealAmt;

	/**
	 * @Fields isevaluate : 评价状态 ： 0 未评价 1 已评价
	 */
	private String isevaluate;

	/**
	 * @Fields orderRevoke : 订单撤销时间
	 */
	private String orderRevoke;

	/**
	 * @Fields remark1 : 备注1
	 */
	private String remark1;

	/**
	 * @Fields remark2 : 备注2
	 */
	private String remark2;

	/**
	 * @Fields remark3 : 备注3
	 */
	private String remark3;

	/**
	 * @Fields transactionid : 子订单编号：订单流水
	 */
	private String transactionid;

	/**
	 * @Fields orderAmt : 订单金额
	 */
	private BigDecimal orderAmt;

	/**
	 * @Fields orderDate : 订单时间
	 */
	private String orderDate;

	/**
	 * @Fields venderRemark : 商家备注
	 */
	private String venderRemark;

	/**
	 * @Fields orderType : 订单类型 1:普通订单 2:优惠券订单 3:实物众筹
	 */
	private String orderType;

	/**
	 * @Fields orderRealAmtOld : 原实付金额(即下单时计算出的实付金额)
	 */
	private BigDecimal orderRealAmtOld;

	/**
	 * @Fields freight : 运费
	 */
	private BigDecimal freight;

	private String goodsTitle;

	private String goodsStandard;

	private String goodsCode;

	private String goodsType;

	private String className;

	private BigDecimal afterType;

	private String approveStatus;

	private String payWay;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getMainorderIds() {
		return mainorderIds;
	}

	public void setMainorderIds(String mainorderIds) {
		this.mainorderIds = mainorderIds;
	}

	public String getGoodsids() {
		return goodsids;
	}

	public void setGoodsids(String goodsids) {
		this.goodsids = goodsids;
	}

	public String getCustIds() {
		return custIds;
	}

	public void setCustIds(String custIds) {
		this.custIds = custIds;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public BigDecimal getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(BigDecimal goodsNum) {
		this.goodsNum = goodsNum;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getOrderRealAmt() {
		return orderRealAmt;
	}

	public void setOrderRealAmt(BigDecimal orderRealAmt) {
		this.orderRealAmt = orderRealAmt;
	}

	public String getIsevaluate() {
		return isevaluate;
	}

	public void setIsevaluate(String isevaluate) {
		this.isevaluate = isevaluate;
	}

	public String getOrderRevoke() {
		return orderRevoke;
	}

	public void setOrderRevoke(String orderRevoke) {
		this.orderRevoke = orderRevoke;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public BigDecimal getOrderAmt() {
		return orderAmt;
	}

	public void setOrderAmt(BigDecimal orderAmt) {
		this.orderAmt = orderAmt;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getVenderRemark() {
		return venderRemark;
	}

	public void setVenderRemark(String venderRemark) {
		this.venderRemark = venderRemark;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getOrderRealAmtOld() {
		return orderRealAmtOld;
	}

	public void setOrderRealAmtOld(BigDecimal orderRealAmtOld) {
		this.orderRealAmtOld = orderRealAmtOld;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public String getGoodsTitle() {
		return goodsTitle;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}

	public String getGoodsStandard() {
		return goodsStandard;
	}

	public void setGoodsStandard(String goodsStandard) {
		this.goodsStandard = goodsStandard;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public BigDecimal getAfterType() {
		return afterType;
	}

	public void setAfterType(BigDecimal afterType) {
		this.afterType = afterType;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	
}