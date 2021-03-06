package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Gangwei;
import com.jk.model.Tree;
import com.jk.model.Zhanghao;
import com.jk.service.DhyService;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("dhy")
public class DhyController {

    @Reference
    private DhyService dhyService;

    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("queryGangwei")
    @ResponseBody
    public DataGridResult queryGangwei(@RequestBody ParameUtil parameUtil){
        PageUtil pageUtil = dhyService.queryGangwei(parameUtil);

        DataGridResult result = new DataGridResult();

        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());

        return result;
    }



    @RequestMapping("showXiangQing")

    public ModelAndView showXiangQing(Integer id, ModelAndView model){
        System.err.println(id);
        Gangwei list = dhyService.showXiangQing(id);

        model.setViewName("html/dhy/showXiangQing");
        model.addObject("list",list);

        return model;
    }

    @RequestMapping("showXiangQing2")

    public ModelAndView showXiangQing2(Integer id, ModelAndView model){
        System.err.println(id);
        Zhanghao list = dhyService.showXiangQing2(id);

        model.setViewName("html/dhy/role");
        model.addObject("list",list);

        return model;
    }



    @RequestMapping("queryZhanghao")
    @ResponseBody
    public DataGridResult queryZhanghao(@RequestBody ParameUtil parameUtil){
        PageUtil pageUtil = dhyService.queryZhanghao(parameUtil);

        DataGridResult result = new DataGridResult();

        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());

        return result;
    }

    @RequestMapping("down")
    @ResponseBody
    public void updateStatus(Integer id){

        dhyService.updateStatus(id);
    }

    @RequestMapping("up")
    @ResponseBody
    public void updateStatus2(Integer id){

        dhyService.updateStatus2(id);
    }

    //tree
    @RequestMapping("queryTree")
    @ResponseBody
    public List<Tree> queryTree(){
        List<Tree> list = new ArrayList();
        String key = "tree";
        if (redisTemplate.hasKey(key)) {
            System.out.println("=====走缓存=====");
            list = (List<Tree>) redisTemplate.opsForValue().get(key);
        }else {
            System.out.println("=====走数据库=====");
            list = dhyService.getTreeAll();
            list = TreeNoteUtil.getFatherNode(list);
            redisTemplate.opsForValue().set(key, list);
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return list;
    }
}
