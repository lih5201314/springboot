package com.jk.dao;

import com.jk.model.User;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;

import java.util.List;
import java.util.Map;

public interface ClientDao {


    List<User> queryUserList(ParameUtil params);
}

