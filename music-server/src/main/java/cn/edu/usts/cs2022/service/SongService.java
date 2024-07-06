package cn.edu.usts.cs2022.service;

import cn.edu.usts.cs2022.pojo.po.Song;

import java.util.List;

public interface SongService {

    List<Song> searchBySong(String keyword);
}
