package cn.edu.usts.cs2022.mapper;

import cn.edu.usts.cs2022.pojo.dto.SongStarDTO;
import cn.edu.usts.cs2022.pojo.dto.SongStarTempDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.List;

@Mapper
public interface StarMapper {
    @Select("select count(*) from star where song_id = #{songId} and user_id = #{userId}")
    Integer count(@Param("songId") Integer songId,
                  @Param("userId") Integer userId);

    void star(@Param("songId") Integer songId,
              @Param("userId") Integer userId);

    @Select("select song_id from star where user_id = #{id}")
    List<Integer> getSongIdList(Integer id);

    @Delete("delete from star where user_id = #{userId} and song_id = #{songId}")
    void cancelStar(@Param("userId") Integer userId,
                    @Param("songId") Integer songId);

    @Select("select star.song_id as songId, count(*) as cnt from star group by star.song_id order by cnt desc limit 4")
    List<SongStarTempDTO> countStar();

    @Select("delete from star where song_id = #{id}")
    void deleteSong(Integer id);

    @Delete("delete from star where user_id = #{id}")
    void deleteSongByUserId(Integer id);
}
