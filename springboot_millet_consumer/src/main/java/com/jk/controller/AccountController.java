/**
 * Copyright (C), 2015-2019, 金科教育
 * FileName: AccountController
 * Author:   dell
 * Date:     2019/8/16 14:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名 ：刘博文   修改时间   new Date()  版本号              描述
 */
package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Goods;
import com.jk.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("account")
public class AccountController {
    @Reference
    private AccountService accountService;
/*
* 查询账户总览
 */
    @RequestMapping("findBootstrapaccount")
    @ResponseBody
    public HashMap<String,Object> findBootstrapaccount (Integer page, Integer rows, Goods goods){
       return accountService.findBootstrapaccount(page,rows,goods);
    }



}
