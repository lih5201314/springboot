package com.jk.mapper;

import com.jk.model.Gangwei;
import com.jk.model.Tree;
import com.jk.model.Zhanghao;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface DhyMapper {

    List<Gangwei> queryGangwei(Map map);

    List<Zhanghao> queryZhanghao(Map map);

    @Select("select * from t_gangwei where gid = #{id}")
    Gangwei showXiangQing(Integer id);
    @Select("select * from t_zhanghao where id = #{id}")
    Zhanghao showXiangQing2(Integer id);

    @Update("update t_zhanghao set status = 1 where id = #{id}")
    void updateStatus(Integer id);

    @Update("update t_zhanghao set status = 0 where id = #{id}")
    void updateStatus2(Integer id);

    List<Tree> getTreeAll();
}
