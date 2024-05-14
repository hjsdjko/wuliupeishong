package com.dao;

import com.entity.GoodsChuruInoutEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GoodsChuruInoutView;

/**
 * 出入库 Dao 接口
 *
 * @author 
 */
public interface GoodsChuruInoutDao extends BaseMapper<GoodsChuruInoutEntity> {

   List<GoodsChuruInoutView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
