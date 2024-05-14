package com.entity.view;

import com.entity.GoodsOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 货物订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("goods_order")
public class GoodsOrderView extends GoodsOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 订单状态的值
		*/
		private String goodsOrderValue;



		//级联表 cheliang
			/**
			* 车辆编号
			*/
			private String cheliangUuidNumber;
			/**
			* 车辆名称
			*/
			private String cheliangName;
			/**
			* 车辆类型
			*/
			private Integer cheliangTypes;
				/**
				* 车辆类型的值
				*/
				private String cheliangValue;
			/**
			* 车辆数量
			*/
			private Integer cheliangNumber;
			/**
			* 车辆详情
			*/
			private String cheliangContent;

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

		//级联表 kehu
			/**
			* 客户编号
			*/
			private String kehuUuidNumber;
			/**
			* 公司名称
			*/
			private String kehuGongshi;
			/**
			* 公司地址
			*/
			private String kehuAddress;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 联系人
			*/
			private String kehuName;
			/**
			* 联系方式
			*/
			private String kehuPhone;
			/**
			* 邮箱
			*/
			private String kehuEmail;
			/**
			* 假删
			*/
			private Integer kehuDelete;

	public GoodsOrderView() {

	}

	public GoodsOrderView(GoodsOrderEntity goodsOrderEntity) {
		try {
			BeanUtils.copyProperties(this, goodsOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 订单状态的值
			*/
			public String getGoodsOrderValue() {
				return goodsOrderValue;
			}
			/**
			* 设置： 订单状态的值
			*/
			public void setGoodsOrderValue(String goodsOrderValue) {
				this.goodsOrderValue = goodsOrderValue;
			}






				//级联表的get和set cheliang

					/**
					* 获取： 车辆编号
					*/
					public String getCheliangUuidNumber() {
						return cheliangUuidNumber;
					}
					/**
					* 设置： 车辆编号
					*/
					public void setCheliangUuidNumber(String cheliangUuidNumber) {
						this.cheliangUuidNumber = cheliangUuidNumber;
					}

					/**
					* 获取： 车辆名称
					*/
					public String getCheliangName() {
						return cheliangName;
					}
					/**
					* 设置： 车辆名称
					*/
					public void setCheliangName(String cheliangName) {
						this.cheliangName = cheliangName;
					}

					/**
					* 获取： 车辆类型
					*/
					public Integer getCheliangTypes() {
						return cheliangTypes;
					}
					/**
					* 设置： 车辆类型
					*/
					public void setCheliangTypes(Integer cheliangTypes) {
						this.cheliangTypes = cheliangTypes;
					}


						/**
						* 获取： 车辆类型的值
						*/
						public String getCheliangValue() {
							return cheliangValue;
						}
						/**
						* 设置： 车辆类型的值
						*/
						public void setCheliangValue(String cheliangValue) {
							this.cheliangValue = cheliangValue;
						}

					/**
					* 获取： 车辆数量
					*/
					public Integer getCheliangNumber() {
						return cheliangNumber;
					}
					/**
					* 设置： 车辆数量
					*/
					public void setCheliangNumber(Integer cheliangNumber) {
						this.cheliangNumber = cheliangNumber;
					}

					/**
					* 获取： 车辆详情
					*/
					public String getCheliangContent() {
						return cheliangContent;
					}
					/**
					* 设置： 车辆详情
					*/
					public void setCheliangContent(String cheliangContent) {
						this.cheliangContent = cheliangContent;
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

















				//级联表的get和set kehu

					/**
					* 获取： 客户编号
					*/
					public String getKehuUuidNumber() {
						return kehuUuidNumber;
					}
					/**
					* 设置： 客户编号
					*/
					public void setKehuUuidNumber(String kehuUuidNumber) {
						this.kehuUuidNumber = kehuUuidNumber;
					}

					/**
					* 获取： 公司名称
					*/
					public String getKehuGongshi() {
						return kehuGongshi;
					}
					/**
					* 设置： 公司名称
					*/
					public void setKehuGongshi(String kehuGongshi) {
						this.kehuGongshi = kehuGongshi;
					}

					/**
					* 获取： 公司地址
					*/
					public String getKehuAddress() {
						return kehuAddress;
					}
					/**
					* 设置： 公司地址
					*/
					public void setKehuAddress(String kehuAddress) {
						this.kehuAddress = kehuAddress;
					}

					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}

					/**
					* 获取： 联系人
					*/
					public String getKehuName() {
						return kehuName;
					}
					/**
					* 设置： 联系人
					*/
					public void setKehuName(String kehuName) {
						this.kehuName = kehuName;
					}

					/**
					* 获取： 联系方式
					*/
					public String getKehuPhone() {
						return kehuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setKehuPhone(String kehuPhone) {
						this.kehuPhone = kehuPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getKehuEmail() {
						return kehuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setKehuEmail(String kehuEmail) {
						this.kehuEmail = kehuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getKehuDelete() {
						return kehuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setKehuDelete(Integer kehuDelete) {
						this.kehuDelete = kehuDelete;
					}













}
