
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 出入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/goodsChuruInout")
public class GoodsChuruInoutController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsChuruInoutController.class);

    @Autowired
    private GoodsChuruInoutService goodsChuruInoutService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    // 列表详情的表级联service
    @Autowired
    private GoodsChuruInoutListService goodsChuruInoutListService;
//    @Autowired
//    private YonghuService yonghuService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = goodsChuruInoutService.queryPage(params);

        //字典表数据转换
        List<GoodsChuruInoutView> list =(List<GoodsChuruInoutView>)page.getList();
        for(GoodsChuruInoutView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GoodsChuruInoutEntity goodsChuruInout = goodsChuruInoutService.selectById(id);
        if(goodsChuruInout !=null){
            //entity转view
            GoodsChuruInoutView view = new GoodsChuruInoutView();
            BeanUtils.copyProperties( goodsChuruInout , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GoodsChuruInoutEntity goodsChuruInout, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,goodsChuruInout:{}",this.getClass().getName(),goodsChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GoodsChuruInoutEntity> queryWrapper = new EntityWrapper<GoodsChuruInoutEntity>()
            .eq("goods_churu_inout_uuid_number", goodsChuruInout.getGoodsChuruInoutUuidNumber())
            .eq("goods_churu_inout_name", goodsChuruInout.getGoodsChuruInoutName())
            .eq("goods_churu_inout_types", goodsChuruInout.getGoodsChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GoodsChuruInoutEntity goodsChuruInoutEntity = goodsChuruInoutService.selectOne(queryWrapper);
        if(goodsChuruInoutEntity==null){
            goodsChuruInout.setInsertTime(new Date());
            goodsChuruInout.setCreateTime(new Date());
            goodsChuruInoutService.insert(goodsChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GoodsChuruInoutEntity goodsChuruInout, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,goodsChuruInout:{}",this.getClass().getName(),goodsChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<GoodsChuruInoutEntity> queryWrapper = new EntityWrapper<GoodsChuruInoutEntity>()
            .notIn("id",goodsChuruInout.getId())
            .andNew()
            .eq("goods_churu_inout_uuid_number", goodsChuruInout.getGoodsChuruInoutUuidNumber())
            .eq("goods_churu_inout_name", goodsChuruInout.getGoodsChuruInoutName())
            .eq("goods_churu_inout_types", goodsChuruInout.getGoodsChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GoodsChuruInoutEntity goodsChuruInoutEntity = goodsChuruInoutService.selectOne(queryWrapper);
        if(goodsChuruInoutEntity==null){
            goodsChuruInoutService.updateById(goodsChuruInout);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }
    /**
    * 出库
    */
    @RequestMapping("/outGoodsChuruInoutList")
    public R outGoodsChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outGoodsChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取出入库名称并判断是否存在
        String goodsChuruInoutName = String.valueOf(params.get("goodsChuruInoutName"));
        Wrapper<GoodsChuruInoutEntity> queryWrapper = new EntityWrapper<GoodsChuruInoutEntity>()
            .eq("goods_churu_inout_name", goodsChuruInoutName)
            ;
        GoodsChuruInoutEntity goodsChuruInoutSelectOne = goodsChuruInoutService.selectOne(queryWrapper);
        if(goodsChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


    //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");


        Set<String> ids = map.keySet();

        List<GoodsEntity> goodsList = goodsService.selectBatchIds(ids);
        if(goodsList == null || goodsList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(GoodsEntity w:goodsList){
                Integer value = w.getGoodsKucunNumber()-map.get(String.valueOf(w.getId()));
                if(value <0){
                    return R.error(511,"出库数量大于库存数量");
                }
                w.setGoodsKucunNumber(value);
            }
        }

        //当前表
        GoodsChuruInoutEntity goodsChuruInoutEntity = new GoodsChuruInoutEntity<>();
            goodsChuruInoutEntity.setGoodsChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            goodsChuruInoutEntity.setGoodsChuruInoutName(goodsChuruInoutName);
            goodsChuruInoutEntity.setGoodsChuruInoutTypes(1);
            goodsChuruInoutEntity.setGoodsChuruInoutContent("");
            goodsChuruInoutEntity.setInsertTime(new Date());
            goodsChuruInoutEntity.setCreateTime(new Date());

        boolean insertGoodsChuruInout = goodsChuruInoutService.insert(goodsChuruInoutEntity);
        if(insertGoodsChuruInout){
            //级联表
            ArrayList<GoodsChuruInoutListEntity> goodsChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                GoodsChuruInoutListEntity goodsChuruInoutListEntity = new GoodsChuruInoutListEntity();
                    goodsChuruInoutListEntity.setGoodsChuruInoutId(goodsChuruInoutEntity.getId());
                    goodsChuruInoutListEntity.setGoodsId(Integer.valueOf(id));
                    goodsChuruInoutListEntity.setGoodsChuruInoutListNumber(map.get(id));
                    goodsChuruInoutListEntity.setInsertTime(new Date());
                    goodsChuruInoutListEntity.setCreateTime(new Date());
                goodsChuruInoutLists.add(goodsChuruInoutListEntity);
                goodsService.updateBatchById(goodsList);
            }
            goodsChuruInoutListService.insertBatch(goodsChuruInoutLists);
        }
        return R.ok();
    }

    /**
    *入库
    */
    @RequestMapping("/inGoodsChuruInoutList")
    public R inGoodsChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inGoodsChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        //params:{"map":{"1":2,"2":3},"wuziOutinName":"订单1"}

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取当前表名称并判断
        String goodsChuruInoutName = String.valueOf(params.get("goodsChuruInoutName"));
        Wrapper<GoodsChuruInoutEntity> queryWrapper = new EntityWrapper<GoodsChuruInoutEntity>()
            .eq("goods_churu_inout_name", goodsChuruInoutName)
            ;
        GoodsChuruInoutEntity goodsChuruInoutSelectOne = goodsChuruInoutService.selectOne(queryWrapper);
        if(goodsChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


        //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");

        Set<String> ids = map.keySet();

        List<GoodsEntity> goodsList = goodsService.selectBatchIds(ids);
        if(goodsList == null || goodsList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(GoodsEntity w:goodsList){
                w.setGoodsKucunNumber(w.getGoodsKucunNumber()+map.get(String.valueOf(w.getId())));
            }
        }

        //当前表
        GoodsChuruInoutEntity goodsChuruInoutEntity = new GoodsChuruInoutEntity<>();
            goodsChuruInoutEntity.setGoodsChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            goodsChuruInoutEntity.setGoodsChuruInoutName(goodsChuruInoutName);
            goodsChuruInoutEntity.setGoodsChuruInoutTypes(2);
            goodsChuruInoutEntity.setGoodsChuruInoutContent("");
            goodsChuruInoutEntity.setInsertTime(new Date());
            goodsChuruInoutEntity.setCreateTime(new Date());


        boolean insertGoodsChuruInout = goodsChuruInoutService.insert(goodsChuruInoutEntity);
        if(insertGoodsChuruInout){
            //级联表
            ArrayList<GoodsChuruInoutListEntity> goodsChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                GoodsChuruInoutListEntity goodsChuruInoutListEntity = new GoodsChuruInoutListEntity();
                goodsChuruInoutListEntity.setGoodsChuruInoutId(goodsChuruInoutEntity.getId());
                goodsChuruInoutListEntity.setGoodsId(Integer.valueOf(id));
                goodsChuruInoutListEntity.setGoodsChuruInoutListNumber(map.get(id));
                goodsChuruInoutListEntity.setInsertTime(new Date());
                goodsChuruInoutListEntity.setCreateTime(new Date());
                goodsChuruInoutLists.add(goodsChuruInoutListEntity);
                goodsService.updateBatchById(goodsList);
            }
            goodsChuruInoutListService.insertBatch(goodsChuruInoutLists);
        }

        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        goodsChuruInoutService.deleteBatchIds(Arrays.asList(ids));
        goodsChuruInoutListService.delete(new EntityWrapper<GoodsChuruInoutListEntity>().in("goods_churu_inout_id",ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<GoodsChuruInoutEntity> goodsChuruInoutList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            GoodsChuruInoutEntity goodsChuruInoutEntity = new GoodsChuruInoutEntity();
//                            goodsChuruInoutEntity.setGoodsChuruInoutUuidNumber(data.get(0));                    //出入库流水号 要改的
//                            goodsChuruInoutEntity.setGoodsChuruInoutName(data.get(0));                    //出入库名称 要改的
//                            goodsChuruInoutEntity.setGoodsChuruInoutTypes(Integer.valueOf(data.get(0)));   //出入库类型 要改的
//                            goodsChuruInoutEntity.setGoodsChuruInoutContent("");//详情和图片
//                            goodsChuruInoutEntity.setInsertTime(date);//时间
//                            goodsChuruInoutEntity.setCreateTime(date);//时间
                            goodsChuruInoutList.add(goodsChuruInoutEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库流水号
                                if(seachFields.containsKey("goodsChuruInoutUuidNumber")){
                                    List<String> goodsChuruInoutUuidNumber = seachFields.get("goodsChuruInoutUuidNumber");
                                    goodsChuruInoutUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> goodsChuruInoutUuidNumber = new ArrayList<>();
                                    goodsChuruInoutUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("goodsChuruInoutUuidNumber",goodsChuruInoutUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库流水号
                        List<GoodsChuruInoutEntity> goodsChuruInoutEntities_goodsChuruInoutUuidNumber = goodsChuruInoutService.selectList(new EntityWrapper<GoodsChuruInoutEntity>().in("goods_churu_inout_uuid_number", seachFields.get("goodsChuruInoutUuidNumber")));
                        if(goodsChuruInoutEntities_goodsChuruInoutUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GoodsChuruInoutEntity s:goodsChuruInoutEntities_goodsChuruInoutUuidNumber){
                                repeatFields.add(s.getGoodsChuruInoutUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        goodsChuruInoutService.insertBatch(goodsChuruInoutList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
