package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 货物订单
 *
 * @author 
 * @email
 */
@TableName("goods_order")
public class GoodsOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GoodsOrderEntity() {

	}

	public GoodsOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 货物订单号
     */
    @TableField(value = "goods_name")

    private String goodsName;


    /**
     * 货物
     */
    @TableField(value = "goods_id")

    private Integer goodsId;


    /**
     * 购买客户
     */
    @TableField(value = "kehu_id")

    private Integer kehuId;


    /**
     * 车辆
     */
    @TableField(value = "cheliang_id")

    private Integer cheliangId;


    /**
     * 购买数量
     */
    @TableField(value = "goods_order_number")

    private Integer goodsOrderNumber;


    /**
     * 收货人
     */
    @TableField(value = "goods_order_shouhuoren")

    private String goodsOrderShouhuoren;


    /**
     * 联系方式
     */
    @TableField(value = "goods_order_phone")

    private String goodsOrderPhone;


    /**
     * 送货地点
     */
    @TableField(value = "goods_order_address")

    private String goodsOrderAddress;


    /**
     * 订单状态
     */
    @TableField(value = "goods_order_types")

    private Integer goodsOrderTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：货物订单号
	 */
    public String getGoodsName() {
        return goodsName;
    }
    /**
	 * 获取：货物订单号
	 */

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
	 * 设置：货物
	 */
    public Integer getGoodsId() {
        return goodsId;
    }
    /**
	 * 获取：货物
	 */

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    /**
	 * 设置：购买客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }
    /**
	 * 获取：购买客户
	 */

    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 设置：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }
    /**
	 * 获取：车辆
	 */

    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getGoodsOrderNumber() {
        return goodsOrderNumber;
    }
    /**
	 * 获取：购买数量
	 */

    public void setGoodsOrderNumber(Integer goodsOrderNumber) {
        this.goodsOrderNumber = goodsOrderNumber;
    }
    /**
	 * 设置：收货人
	 */
    public String getGoodsOrderShouhuoren() {
        return goodsOrderShouhuoren;
    }
    /**
	 * 获取：收货人
	 */

    public void setGoodsOrderShouhuoren(String goodsOrderShouhuoren) {
        this.goodsOrderShouhuoren = goodsOrderShouhuoren;
    }
    /**
	 * 设置：联系方式
	 */
    public String getGoodsOrderPhone() {
        return goodsOrderPhone;
    }
    /**
	 * 获取：联系方式
	 */

    public void setGoodsOrderPhone(String goodsOrderPhone) {
        this.goodsOrderPhone = goodsOrderPhone;
    }
    /**
	 * 设置：送货地点
	 */
    public String getGoodsOrderAddress() {
        return goodsOrderAddress;
    }
    /**
	 * 获取：送货地点
	 */

    public void setGoodsOrderAddress(String goodsOrderAddress) {
        this.goodsOrderAddress = goodsOrderAddress;
    }
    /**
	 * 设置：订单状态
	 */
    public Integer getGoodsOrderTypes() {
        return goodsOrderTypes;
    }
    /**
	 * 获取：订单状态
	 */

    public void setGoodsOrderTypes(Integer goodsOrderTypes) {
        this.goodsOrderTypes = goodsOrderTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GoodsOrder{" +
            "id=" + id +
            ", goodsName=" + goodsName +
            ", goodsId=" + goodsId +
            ", kehuId=" + kehuId +
            ", cheliangId=" + cheliangId +
            ", goodsOrderNumber=" + goodsOrderNumber +
            ", goodsOrderShouhuoren=" + goodsOrderShouhuoren +
            ", goodsOrderPhone=" + goodsOrderPhone +
            ", goodsOrderAddress=" + goodsOrderAddress +
            ", goodsOrderTypes=" + goodsOrderTypes +
            ", createTime=" + createTime +
        "}";
    }
}
