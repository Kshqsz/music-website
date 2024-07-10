package cn.edu.usts.cs2022.service;

import cn.edu.usts.cs2022.pojo.dto.SongStarDTO;

import java.util.List;

public interface StarService {
    Integer count(Integer songId, Integer userId);

    void star(Integer songId, Integer userId);

    List<Integer> getSongIdList(Integer id);

    void cancelStar(Integer id);

    List<SongStarDTO> countStar();
}
