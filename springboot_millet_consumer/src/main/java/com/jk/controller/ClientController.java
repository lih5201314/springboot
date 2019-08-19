package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.ClientService;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Reference
    private ClientService clientService;


    @RequestMapping("clientList")
    public String toMain(){
        return "clientList";
    }


    @RequestMapping("queryUserList")
    @ResponseBody
    public DataGridResult queryUserList(@RequestBody ParameUtil params) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = clientService.queryUserList(params);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }



}
