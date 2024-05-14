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
 * 货物信息
 *
 * @author 
 * @email
 */
@TableName("goods")
public class GoodsEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GoodsEntity() {

	}

	public GoodsEntity(T t) {
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
     * 货物名称
     */
    @TableField(value = "goods_name")

    private String goodsName;


    /**
     * 货物类型
     */
    @TableField(value = "goods_types")

    private Integer goodsTypes;


    /**
     * 货物图片
     */
    @TableField(value = "goods_photo")

    private String goodsPhoto;


    /**
     * 货物数量
     */
    @TableField(value = "goods_kucun_number")

    private Integer goodsKucunNumber;


    /**
     * 货物价格
     */
    @TableField(value = "goods_money")

    private Double goodsMoney;


    /**
     * 货物详情
     */
    @TableField(value = "goods_content")

    private String goodsContent;


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
	 * 设置：货物名称
	 */
    public String getGoodsName() {
        return goodsName;
    }
    /**
	 * 获取：货物名称
	 */

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
	 * 设置：货物类型
	 */
    public Integer getGoodsTypes() {
        return goodsTypes;
    }
    /**
	 * 获取：货物类型
	 */

    public void setGoodsTypes(Integer goodsTypes) {
        this.goodsTypes = goodsTypes;
    }
    /**
	 * 设置：货物图片
	 */
    public String getGoodsPhoto() {
        return goodsPhoto;
    }
    /**
	 * 获取：货物图片
	 */

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }
    /**
	 * 设置：货物数量
	 */
    public Integer getGoodsKucunNumber() {
        return goodsKucunNumber;
    }
    /**
	 * 获取：货物数量
	 */

    public void setGoodsKucunNumber(Integer goodsKucunNumber) {
        this.goodsKucunNumber = goodsKucunNumber;
    }
    /**
	 * 设置：货物价格
	 */
    public Double getGoodsMoney() {
        return goodsMoney;
    }
    /**
	 * 获取：货物价格
	 */

    public void setGoodsMoney(Double goodsMoney) {
        this.goodsMoney = goodsMoney;
    }
    /**
	 * 设置：货物详情
	 */
    public String getGoodsContent() {
        return goodsContent;
    }
    /**
	 * 获取：货物详情
	 */

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
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
        return "Goods{" +
            "id=" + id +
            ", goodsName=" + goodsName +
            ", goodsTypes=" + goodsTypes +
            ", goodsPhoto=" + goodsPhoto +
            ", goodsKucunNumber=" + goodsKucunNumber +
            ", goodsMoney=" + goodsMoney +
            ", goodsContent=" + goodsContent +
            ", createTime=" + createTime +
        "}";
    }
}
