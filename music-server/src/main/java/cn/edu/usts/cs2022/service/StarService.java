package cn.edu.usts.cs2022.service;

import java.util.List;

public interface StarService {
    Integer count(Integer songId, Integer userId);

    void star(Integer songId, Integer userId);

    List<Integer> getSongIdList(Integer id);

    void cancelStar(Integer id);
}
