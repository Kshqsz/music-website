package cn.edu.usts.cs2022.mapper;

import cn.edu.usts.cs2022.pojo.dto.SongDTO;
import cn.edu.usts.cs2022.pojo.po.Song;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SongMapper {
    List<Song> searchBySong(String keyword);

    @Select("select * from song where singer_name = (select name from singer where id = #{SingerId})")
    List<Song> getBySingerId(Integer singerId);

    @Select("select * from song")
    List<Song> list();

    List<Song> getByIds(@Param("songIdList") List<Integer> songIdList);

    void addSong(SongDTO songDTO);

    @Delete("delete from song where singer_name = #{singerName}")
    void deleteBySingerName(String singerName);

    @Delete("delete from song where id = #{id}")
    void deleteById(Integer id);

    @Select("select * from song where id = #{id}")
    Song getById(Integer id);

    void updateSong(Song song);
}
