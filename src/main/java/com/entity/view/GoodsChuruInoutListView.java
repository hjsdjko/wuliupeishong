package com.entity.view;

import com.entity.GoodsChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出入库详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("goods_churu_inout_list")
public class GoodsChuruInoutListView extends GoodsChuruInoutListEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 goods
			/**
			* 货物名称
			*/
			private String goodsName;
			/**
			* 货物类型
			*/
			private Integer goodsTypes;
				/**
				* 货物类型的值
				*/
				private String goodsValue;
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

		//级联表 goods_churu_inout
			/**
			* 出入库流水号
			*/
			private String goodsChuruInoutUuidNumber;
			/**
			* 出入库名称
			*/
			private String goodsChuruInoutName;
			/**
			* 出入库类型
			*/
			private Integer goodsChuruInoutTypes;
				/**
				* 出入库类型的值
				*/
				private String goodsChuruInoutValue;
			/**
			* 备注
			*/
			private String goodsChuruInoutContent;

	public GoodsChuruInoutListView() {

	}

	public GoodsChuruInoutListView(GoodsChuruInoutListEntity goodsChuruInoutListEntity) {
		try {
			BeanUtils.copyProperties(this, goodsChuruInoutListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}














				//级联表的get和set goods

					/**
					* 获取： 货物名称
					*/
					public String getGoodsName() {
						return goodsName;
					}
					/**
					* 设置： 货物名称
					*/
					public void setGoodsName(String goodsName) {
						this.goodsName = goodsName;
					}

					/**
					* 获取： 货物类型
					*/
					public Integer getGoodsTypes() {
						return goodsTypes;
					}
					/**
					* 设置： 货物类型
					*/
					public void setGoodsTypes(Integer goodsTypes) {
						this.goodsTypes = goodsTypes;
					}


						/**
						* 获取： 货物类型的值
						*/
						public String getGoodsValue() {
							return goodsValue;
						}
						/**
						* 设置： 货物类型的值
						*/
						public void setGoodsValue(String goodsValue) {
							this.goodsValue = goodsValue;
						}

					/**
					* 获取： 货物图片
					*/
					public String getGoodsPhoto() {
						return goodsPhoto;
					}
					/**
					* 设置： 货物图片
					*/
					public void setGoodsPhoto(String goodsPhoto) {
						this.goodsPhoto = goodsPhoto;
					}

					/**
					* 获取： 货物数量
					*/
					public Integer getGoodsKucunNumber() {
						return goodsKucunNumber;
					}
					/**
					* 设置： 货物数量
					*/
					public void setGoodsKucunNumber(Integer goodsKucunNumber) {
						this.goodsKucunNumber = goodsKucunNumber;
					}

					/**
					* 获取： 货物价格
					*/
					public Double getGoodsMoney() {
						return goodsMoney;
					}
					/**
					* 设置： 货物价格
					*/
					public void setGoodsMoney(Double goodsMoney) {
						this.goodsMoney = goodsMoney;
					}

					/**
					* 获取： 货物详情
					*/
					public String getGoodsContent() {
						return goodsContent;
					}
					/**
					* 设置： 货物详情
					*/
					public void setGoodsContent(String goodsContent) {
						this.goodsContent = goodsContent;
					}


				//级联表的get和set goods_churu_inout

					/**
					* 获取： 出入库流水号
					*/
					public String getGoodsChuruInoutUuidNumber() {
						return goodsChuruInoutUuidNumber;
					}
					/**
					* 设置： 出入库流水号
					*/
					public void setGoodsChuruInoutUuidNumber(String goodsChuruInoutUuidNumber) {
						this.goodsChuruInoutUuidNumber = goodsChuruInoutUuidNumber;
					}

					/**
					* 获取： 出入库名称
					*/
					public String getGoodsChuruInoutName() {
						return goodsChuruInoutName;
					}
					/**
					* 设置： 出入库名称
					*/
					public void setGoodsChuruInoutName(String goodsChuruInoutName) {
						this.goodsChuruInoutName = goodsChuruInoutName;
					}

					/**
					* 获取： 出入库类型
					*/
					public Integer getGoodsChuruInoutTypes() {
						return goodsChuruInoutTypes;
					}
					/**
					* 设置： 出入库类型
					*/
					public void setGoodsChuruInoutTypes(Integer goodsChuruInoutTypes) {
						this.goodsChuruInoutTypes = goodsChuruInoutTypes;
					}


						/**
						* 获取： 出入库类型的值
						*/
						public String getGoodsChuruInoutValue() {
							return goodsChuruInoutValue;
						}
						/**
						* 设置： 出入库类型的值
						*/
						public void setGoodsChuruInoutValue(String goodsChuruInoutValue) {
							this.goodsChuruInoutValue = goodsChuruInoutValue;
						}

					/**
					* 获取： 备注
					*/
					public String getGoodsChuruInoutContent() {
						return goodsChuruInoutContent;
					}
					/**
					* 设置： 备注
					*/
					public void setGoodsChuruInoutContent(String goodsChuruInoutContent) {
						this.goodsChuruInoutContent = goodsChuruInoutContent;
					}



















}
