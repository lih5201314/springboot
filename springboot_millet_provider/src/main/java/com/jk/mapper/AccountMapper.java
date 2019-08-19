package com.jk.mapper;

import com.jk.model.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface AccountMapper {
@Select("select count(*) from t_goods g LEFT JOIN t_member m ON g.commentId=m.memberId\n" +
        "LEFT JOIN t_user u on g.userId=u.userId\n" +
        "LEFT JOIN t_state s on u.stateId=s.satateId")
    Integer queryaccountcount(HashMap<String, Object> map);
@Select("select * from t_goods g LEFT JOIN t_member m ON g.commentId=m.memberId\n" +
        "LEFT JOIN t_user u on g.userId=u.userId\n" +
        "LEFT JOIN t_state s on u.stateId=s.satateId\n" +
        "limit ${start},${end}")
    List<Goods> queryaccount(HashMap<String, Object> map);
}
