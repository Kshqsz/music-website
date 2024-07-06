package cn.edu.usts.cs2022.service.Impl;

import cn.edu.usts.cs2022.mapper.SongMapper;
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
}
