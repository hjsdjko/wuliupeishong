package com.entity.vo;

import com.entity.GoodsOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 货物订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("goods_order")
public class GoodsOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
