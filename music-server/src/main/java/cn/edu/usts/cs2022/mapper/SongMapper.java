package cn.edu.usts.cs2022.mapper;

import cn.edu.usts.cs2022.pojo.po.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SongMapper {
    List<Song> searchBySong(String keyword);

    @Select("select * from song where singer_name = (select name from singer where id = #{SingerId})")
    List<Song> getBySingerId(Integer singerId);

    @Select("select * from song")
    List<Song> list();
}
