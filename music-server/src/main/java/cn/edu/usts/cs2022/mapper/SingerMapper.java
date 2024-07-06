package cn.edu.usts.cs2022.mapper;

import cn.edu.usts.cs2022.pojo.po.Singer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SingerMapper {
    List<Singer> searchBySinger(String keyword);

    @Select("select * from singer where id = #{id}")
    Singer getById(Integer id);

    @Select("select * from singer")
    List<Singer> list();
}
