package cn.edu.usts.cs2022.mapper;

import cn.edu.usts.cs2022.pojo.po.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SongMapper {
    List<Song> searchBySong(String keyword);
}
