package com.entity.vo;

import com.entity.GoodsEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 货物信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("goods")
public class GoodsVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
