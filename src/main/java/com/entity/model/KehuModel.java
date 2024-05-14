package com.entity.model;

import com.entity.KehuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 客户
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KehuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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


    /**
     * 创建时间
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
	 * 获取：客户编号
	 */
    public String getKehuUuidNumber() {
        return kehuUuidNumber;
    }


    /**
	 * 设置：客户编号
	 */
    public void setKehuUuidNumber(String kehuUuidNumber) {
        this.kehuUuidNumber = kehuUuidNumber;
    }
    /**
	 * 获取：公司名称
	 */
    public String getKehuGongshi() {
        return kehuGongshi;
    }


    /**
	 * 设置：公司名称
	 */
    public void setKehuGongshi(String kehuGongshi) {
        this.kehuGongshi = kehuGongshi;
    }
    /**
	 * 获取：公司地址
	 */
    public String getKehuAddress() {
        return kehuAddress;
    }


    /**
	 * 设置：公司地址
	 */
    public void setKehuAddress(String kehuAddress) {
        this.kehuAddress = kehuAddress;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：联系人
	 */
    public String getKehuName() {
        return kehuName;
    }


    /**
	 * 设置：联系人
	 */
    public void setKehuName(String kehuName) {
        this.kehuName = kehuName;
    }
    /**
	 * 获取：联系方式
	 */
    public String getKehuPhone() {
        return kehuPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setKehuPhone(String kehuPhone) {
        this.kehuPhone = kehuPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getKehuEmail() {
        return kehuEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setKehuEmail(String kehuEmail) {
        this.kehuEmail = kehuEmail;
    }
    /**
	 * 获取：假删
	 */
    public Integer getKehuDelete() {
        return kehuDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setKehuDelete(Integer kehuDelete) {
        this.kehuDelete = kehuDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
