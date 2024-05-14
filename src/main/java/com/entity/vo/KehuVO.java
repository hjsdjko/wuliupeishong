package com.entity.vo;

import com.entity.KehuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 客户
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kehu")
public class KehuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 客户编号
     */

    @TableField(value = "kehu_uuid_number")
    private String kehuUuidNumber;


    /**
     * 公司名称
     */

    @TableField(value = "kehu_gongshi")
    private String kehuGongshi;


    /**
     * 公司地址
     */

    @TableField(value = "kehu_address")
    private String kehuAddress;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 联系人
     */

    @TableField(value = "kehu_name")
    private String kehuName;


    /**
     * 联系方式
     */

    @TableField(value = "kehu_phone")
    private String kehuPhone;


    /**
     * 邮箱
     */

    @TableField(value = "kehu_email")
    private String kehuEmail;


    /**
     * 假删
     */

    @TableField(value = "kehu_delete")
    private Integer kehuDelete;


    /**
     * 创建时间
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
	 * 设置：客户编号
	 */
    public String getKehuUuidNumber() {
        return kehuUuidNumber;
    }


    /**
	 * 获取：客户编号
	 */

    public void setKehuUuidNumber(String kehuUuidNumber) {
        this.kehuUuidNumber = kehuUuidNumber;
    }
    /**
	 * 设置：公司名称
	 */
    public String getKehuGongshi() {
        return kehuGongshi;
    }


    /**
	 * 获取：公司名称
	 */

    public void setKehuGongshi(String kehuGongshi) {
        this.kehuGongshi = kehuGongshi;
    }
    /**
	 * 设置：公司地址
	 */
    public String getKehuAddress() {
        return kehuAddress;
    }


    /**
	 * 获取：公司地址
	 */

    public void setKehuAddress(String kehuAddress) {
        this.kehuAddress = kehuAddress;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：联系人
	 */
    public String getKehuName() {
        return kehuName;
    }


    /**
	 * 获取：联系人
	 */

    public void setKehuName(String kehuName) {
        this.kehuName = kehuName;
    }
    /**
	 * 设置：联系方式
	 */
    public String getKehuPhone() {
        return kehuPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setKehuPhone(String kehuPhone) {
        this.kehuPhone = kehuPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getKehuEmail() {
        return kehuEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setKehuEmail(String kehuEmail) {
        this.kehuEmail = kehuEmail;
    }
    /**
	 * 设置：假删
	 */
    public Integer getKehuDelete() {
        return kehuDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setKehuDelete(Integer kehuDelete) {
        this.kehuDelete = kehuDelete;
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

}
