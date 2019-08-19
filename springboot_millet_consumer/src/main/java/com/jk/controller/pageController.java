/**
 * Copyright (C), 2015-2019, 金科教育
 * FileName: pageController
 * Author:   dell
 * Date:     2019/8/16 20:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名 ：刘博文   修改时间   new Date()  版本号              描述
 */
package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Goods;
import com.jk.model.Order;
import com.jk.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author dell
 * @create 2019/8/16
 * @since 1.0.0


 */
@Controller
@RequestMapping("page")
public class pageController {

    @Reference
    private GoodsService goodsService;
    @Reference
    private com.jk.service.DealService DealService;


    @RequestMapping("main")
    public String main(){
        return "html/index";
    }

    //財務管理
    @RequestMapping("tofinance")
    public String touserlist() {
        return "FinanceList";
    }

    //树
    @RequestMapping("index")
    public String index(){
        return "html/wh/tree";
    }

    //商品查询
    @RequestMapping("goodsshow")
    public String goodsshow(){
        return "html/wh/goodsshow";
    }

    //发布商品
    @RequestMapping("addgoods")
    public String addgoods(){
        return "html/wh/addgoods";
    }
    //订单管理
   /* @RequestMapping("deal")
    public String deal(Integer id) {

        return "html/lih/deal";
    }*/

    @RequestMapping("dd")
    public String dd() {
        return "html/lih/dd";
    }
//退款管理
@RequestMapping("refund")
public String refund() {
    return "html/lih/refund";
}
    //评论管理
    @RequestMapping("comment")
    public String comment() {
        return "html/lih/comment";
    }


  @RequestMapping("dealXq")
    public ModelAndView dealXq(Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/lih/deal");
        mv.addObject("order",id);
        return mv;
    }

    @RequestMapping("edit")
    public ModelAndView edit(Integer id){
        Goods goods = goodsService.findGoodsByid(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/wh/updgoods");
        mv.addObject("goods",goods);
        return mv;
    }
    @RequestMapping("typegoods")
    public String typegoods(){
        return "html/wh/typegoods";
    }

    //岗位角色
    @RequestMapping("togangWei")
    public String toGangwei(){
        return "html/dhy/gangWei";
    }
    //账号管理
    @RequestMapping("tozhangHao")
    public String toZhanghao(){
        return "html/dhy/zhangHao";
    }


}
