package cn.edu.usts.cs2022.service;

import cn.edu.usts.cs2022.pojo.dto.SingerDTO;
import cn.edu.usts.cs2022.pojo.po.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> searchBySinger(String keyword);

    Singer getById(Integer id);

    List<Singer> list();

    void addSinger(SingerDTO singerDTO);

    void updateSinger(Singer singer);

    void deleteSinger(Integer id);
}
