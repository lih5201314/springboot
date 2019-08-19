package com.jk.service;


import com.jk.model.Goods;

import java.util.HashMap;

public interface AccountService {
    HashMap<String, Object> findBootstrapaccount(Integer page, Integer rows, Goods goods);
}
