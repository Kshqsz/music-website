package cn.edu.usts.cs2022.service.Impl;

import cn.edu.usts.cs2022.mapper.SongMapper;
import cn.edu.usts.cs2022.pojo.dto.SongDTO;
import cn.edu.usts.cs2022.pojo.po.Song;
import cn.edu.usts.cs2022.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    public final SongMapper songMapper;
    /**
     * 根据关键词查找歌曲
     * @param keyword
     * @return
     */
    @Override
    public List<Song> searchBySong(String keyword) {
        List<Song> songList = songMapper.searchBySong(keyword);
        return songList;
    }

    /**
     * 根据 歌手id 查找歌曲
     * @param singerId
     * @return
     */
    @Override
    public List<Song> getBySingerId(Integer singerId) {
        List<Song> songList = songMapper.getBySingerId(singerId);
        return songList;
    }

    /**
     * 查询所有歌曲
     * @return
     */
    @Override
    public List<Song> list() {
        List<Song> songList = songMapper.list();
        return songList;
    }

    @Override
    public List<Song> getByIds(List<Integer> songIdList) {
        List<Song> songList = songMapper.getByIds(songIdList);
        return songList;
    }

    @Override
    public void addSong(SongDTO songDTO) {
        songMapper.addSong(songDTO);
    }

    @Override
    public void deleteSong(Integer id) {
        songMapper.deleteById(id);
    }

    @Override
    public Song getById(Integer id) {
        Song song = songMapper.getById(id);
        return song;
    }

    @Override
    public void updateSong(Song song) {
        songMapper.updateSong(song);
    }

    @Override
    public Integer countSong() {
        return songMapper.countSong();
    }
}
