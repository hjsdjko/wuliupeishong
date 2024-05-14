package com.entity.model;

import com.entity.GoodsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 货物信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GoodsModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 货物名称
     */
    private String goodsName;


    /**
     * 货物类型
     */
    private Integer goodsTypes;


    /**
     * 货物图片
     */
    private String goodsPhoto;


    /**
     * 货物数量
     */
    private Integer goodsKucunNumber;


    /**
     * 货物价格
     */
    private Double goodsMoney;


    /**
     * 货物详情
     */
    private String goodsContent;


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
	 * 获取：货物名称
	 */
    public String getGoodsName() {
        return goodsName;
    }


    /**
	 * 设置：货物名称
	 */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
	 * 获取：货物类型
	 */
    public Integer getGoodsTypes() {
        return goodsTypes;
    }


    /**
	 * 设置：货物类型
	 */
    public void setGoodsTypes(Integer goodsTypes) {
        this.goodsTypes = goodsTypes;
    }
    /**
	 * 获取：货物图片
	 */
    public String getGoodsPhoto() {
        return goodsPhoto;
    }


    /**
	 * 设置：货物图片
	 */
    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }
    /**
	 * 获取：货物数量
	 */
    public Integer getGoodsKucunNumber() {
        return goodsKucunNumber;
    }


    /**
	 * 设置：货物数量
	 */
    public void setGoodsKucunNumber(Integer goodsKucunNumber) {
        this.goodsKucunNumber = goodsKucunNumber;
    }
    /**
	 * 获取：货物价格
	 */
    public Double getGoodsMoney() {
        return goodsMoney;
    }


    /**
	 * 设置：货物价格
	 */
    public void setGoodsMoney(Double goodsMoney) {
        this.goodsMoney = goodsMoney;
    }
    /**
	 * 获取：货物详情
	 */
    public String getGoodsContent() {
        return goodsContent;
    }


    /**
	 * 设置：货物详情
	 */
    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
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
