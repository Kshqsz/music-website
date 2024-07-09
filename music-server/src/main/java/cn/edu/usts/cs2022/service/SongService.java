package cn.edu.usts.cs2022.service;

import cn.edu.usts.cs2022.pojo.dto.SongDTO;
import cn.edu.usts.cs2022.pojo.po.Song;

import java.util.List;

public interface SongService {

    List<Song> searchBySong(String keyword);

    List<Song> getBySingerId(Integer singerId);

    List<Song> list();

    List<Song> getByIds(List<Integer> songIdList);

    void addSong(SongDTO songDTO);

    void deleteSong(Integer id);

    Song getById(Integer id);

    void updateSong(Song song);
}
