package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.mapper.DhyMapper;
import com.jk.model.Gangwei;
import com.jk.model.Tree;
import com.jk.model.Zhanghao;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.apache.poi.ss.formula.functions.Count;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DhyServiceImpl implements DhyService{

    @Autowired
    private DhyMapper dhyMapper;

    @Override
    public PageUtil queryGangwei(ParameUtil parameUtil) {
        PageHelper.startPage(parameUtil.getPageNumber(),parameUtil.getPageSize());

        Map map = new HashMap<>();

        map.put("gname",parameUtil.getGname());
        System.err.println(parameUtil.getGname());
        List<Gangwei> list = dhyMapper.queryGangwei(map);

        PageInfo<Gangwei> pageInfo = new PageInfo<>(list);

        PageUtil page= new PageUtil((int)pageInfo.getTotal(),parameUtil.getPageNumber(), parameUtil.getPageSize());

        page.setList(list);

        return page;

    }

    @Override
    public PageUtil queryZhanghao(ParameUtil parameUtil) {

        PageHelper.startPage(parameUtil.getPageNumber(),parameUtil.getPageSize());

        Map map = new HashMap<>();

        map.put("gname",parameUtil.getGname());
        System.err.println(parameUtil.getGname());
        List<Zhanghao> list = dhyMapper.queryZhanghao(map);

        PageInfo<Zhanghao> pageInfo = new PageInfo<>(list);

        PageUtil page= new PageUtil((int)pageInfo.getTotal(),parameUtil.getPageNumber(), parameUtil.getPageSize());

        page.setList(list);

        return page;

    }

    @Override
    public Gangwei showXiangQing(Integer id) {
        return dhyMapper.showXiangQing(id);
    }

    @Override
    public Zhanghao showXiangQing2(Integer id) {
        return dhyMapper.showXiangQing2(id);
    }

    @Override
    public void updateStatus(Integer id) {
        dhyMapper.updateStatus(id);
    }

    @Override
    public void updateStatus2(Integer id) {
        dhyMapper.updateStatus2(id);
    }

    @Override
    public List<Tree> getTreeAll() {

        return dhyMapper.getTreeAll();
    }


}
