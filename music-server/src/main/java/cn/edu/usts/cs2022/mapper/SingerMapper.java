package cn.edu.usts.cs2022.mapper;

import cn.edu.usts.cs2022.pojo.dto.SingerDTO;
import cn.edu.usts.cs2022.pojo.po.Singer;
import org.apache.ibatis.annotations.Delete;
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

    void addSinger(SingerDTO singerDTO);

    void updateSinger(Singer singer);

    @Delete("delete from singer where id = #{singerId}")
    void deleteSinger(Integer singerId);
}
