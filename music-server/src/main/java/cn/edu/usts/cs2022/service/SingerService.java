package cn.edu.usts.cs2022.service;

import cn.edu.usts.cs2022.pojo.po.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> searchBySinger(String keyword);
}
