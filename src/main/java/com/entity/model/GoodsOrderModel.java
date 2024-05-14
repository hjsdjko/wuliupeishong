package com.entity.model;

import com.entity.GoodsOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 货物订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GoodsOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 货物订单号
     */
    private String goodsName;


    /**
     * 货物
     */
    private Integer goodsId;


    /**
     * 购买客户
     */
    private Integer kehuId;


    /**
     * 车辆
     */
    private Integer cheliangId;


    /**
     * 购买数量
     */
    private Integer goodsOrderNumber;


    /**
     * 收货人
     */
    private String goodsOrderShouhuoren;


    /**
     * 联系方式
     */
    private String goodsOrderPhone;


    /**
     * 送货地点
     */
    private String goodsOrderAddress;


    /**
     * 订单状态
     */
    private Integer goodsOrderTypes;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：货物订单号
	 */
    public String getGoodsName() {
        return goodsName;
    }


    /**
	 * 设置：货物订单号
	 */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
	 * 获取：货物
	 */
    public Integer getGoodsId() {
        return goodsId;
    }


    /**
	 * 设置：货物
	 */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    /**
	 * 获取：购买客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 设置：购买客户
	 */
    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 获取：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 设置：车辆
	 */
    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 获取：购买数量
	 */
    public Integer getGoodsOrderNumber() {
        return goodsOrderNumber;
    }


    /**
	 * 设置：购买数量
	 */
    public void setGoodsOrderNumber(Integer goodsOrderNumber) {
        this.goodsOrderNumber = goodsOrderNumber;
    }
    /**
	 * 获取：收货人
	 */
    public String getGoodsOrderShouhuoren() {
        return goodsOrderShouhuoren;
    }


    /**
	 * 设置：收货人
	 */
    public void setGoodsOrderShouhuoren(String goodsOrderShouhuoren) {
        this.goodsOrderShouhuoren = goodsOrderShouhuoren;
    }
    /**
	 * 获取：联系方式
	 */
    public String getGoodsOrderPhone() {
        return goodsOrderPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setGoodsOrderPhone(String goodsOrderPhone) {
        this.goodsOrderPhone = goodsOrderPhone;
    }
    /**
	 * 获取：送货地点
	 */
    public String getGoodsOrderAddress() {
        return goodsOrderAddress;
    }


    /**
	 * 设置：送货地点
	 */
    public void setGoodsOrderAddress(String goodsOrderAddress) {
        this.goodsOrderAddress = goodsOrderAddress;
    }
    /**
	 * 获取：订单状态
	 */
    public Integer getGoodsOrderTypes() {
        return goodsOrderTypes;
    }


    /**
	 * 设置：订单状态
	 */
    public void setGoodsOrderTypes(Integer goodsOrderTypes) {
        this.goodsOrderTypes = goodsOrderTypes;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
