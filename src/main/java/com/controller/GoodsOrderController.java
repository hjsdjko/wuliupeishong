
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
 * 货物订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/goodsOrder")
public class GoodsOrderController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsOrderController.class);

    @Autowired
    private GoodsOrderService goodsOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private CheliangService cheliangService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private KehuService kehuService;



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
        PageUtils page = goodsOrderService.queryPage(params);

        //字典表数据转换
        List<GoodsOrderView> list =(List<GoodsOrderView>)page.getList();
        for(GoodsOrderView c:list){
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
        GoodsOrderEntity goodsOrder = goodsOrderService.selectById(id);
        if(goodsOrder !=null){
            //entity转view
            GoodsOrderView view = new GoodsOrderView();
            BeanUtils.copyProperties( goodsOrder , view );//把实体数据重构到view中

                //级联表
                CheliangEntity cheliang = cheliangService.selectById(goodsOrder.getCheliangId());
                if(cheliang != null){
                    BeanUtils.copyProperties( cheliang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCheliangId(cheliang.getId());
                }
                //级联表
                GoodsEntity goods = goodsService.selectById(goodsOrder.getGoodsId());
                if(goods != null){
                    BeanUtils.copyProperties( goods , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGoodsId(goods.getId());
                }
                //级联表
                KehuEntity kehu = kehuService.selectById(goodsOrder.getKehuId());
                if(kehu != null){
                    BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKehuId(kehu.getId());
                }
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
    public R save(@RequestBody GoodsOrderEntity goodsOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,goodsOrder:{}",this.getClass().getName(),goodsOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        goodsOrder.setCreateTime(new Date());
        goodsOrderService.insert(goodsOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GoodsOrderEntity goodsOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,goodsOrder:{}",this.getClass().getName(),goodsOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<GoodsOrderEntity> queryWrapper = new EntityWrapper<GoodsOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GoodsOrderEntity goodsOrderEntity = goodsOrderService.selectOne(queryWrapper);
        if(goodsOrderEntity==null){
            goodsOrderService.updateById(goodsOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        goodsOrderService.deleteBatchIds(Arrays.asList(ids));
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
            List<GoodsOrderEntity> goodsOrderList = new ArrayList<>();//上传的东西
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
                            GoodsOrderEntity goodsOrderEntity = new GoodsOrderEntity();
//                            goodsOrderEntity.setGoodsName(data.get(0));                    //货物订单号 要改的
//                            goodsOrderEntity.setGoodsId(Integer.valueOf(data.get(0)));   //货物 要改的
//                            goodsOrderEntity.setKehuId(Integer.valueOf(data.get(0)));   //购买客户 要改的
//                            goodsOrderEntity.setCheliangId(Integer.valueOf(data.get(0)));   //车辆 要改的
//                            goodsOrderEntity.setGoodsOrderNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            goodsOrderEntity.setGoodsOrderShouhuoren(data.get(0));                    //收货人 要改的
//                            goodsOrderEntity.setGoodsOrderPhone(data.get(0));                    //联系方式 要改的
//                            goodsOrderEntity.setGoodsOrderAddress(data.get(0));                    //送货地点 要改的
//                            goodsOrderEntity.setGoodsOrderTypes(Integer.valueOf(data.get(0)));   //订单状态 要改的
//                            goodsOrderEntity.setCreateTime(date);//时间
                            goodsOrderList.add(goodsOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //联系方式
                                if(seachFields.containsKey("goodsOrderPhone")){
                                    List<String> goodsOrderPhone = seachFields.get("goodsOrderPhone");
                                    goodsOrderPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> goodsOrderPhone = new ArrayList<>();
                                    goodsOrderPhone.add(data.get(0));//要改的
                                    seachFields.put("goodsOrderPhone",goodsOrderPhone);
                                }
                        }

                        //查询是否重复
                         //联系方式
                        List<GoodsOrderEntity> goodsOrderEntities_goodsOrderPhone = goodsOrderService.selectList(new EntityWrapper<GoodsOrderEntity>().in("goods_order_phone", seachFields.get("goodsOrderPhone")));
                        if(goodsOrderEntities_goodsOrderPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GoodsOrderEntity s:goodsOrderEntities_goodsOrderPhone){
                                repeatFields.add(s.getGoodsOrderPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        goodsOrderService.insertBatch(goodsOrderList);
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
