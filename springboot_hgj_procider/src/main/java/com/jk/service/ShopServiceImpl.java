package com.jk.service;

import com.jk.dao.ShopDao;
import com.jk.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ShopService;


@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;


    @Override
    public void addShop(Shop shop) {

        shopDao.addShop(shop);
}
}