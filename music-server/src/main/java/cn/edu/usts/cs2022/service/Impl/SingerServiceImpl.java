package cn.edu.usts.cs2022.service.Impl;

import cn.edu.usts.cs2022.mapper.SingerMapper;
import cn.edu.usts.cs2022.pojo.po.Singer;
import cn.edu.usts.cs2022.service.SingerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SingerServiceImpl implements SingerService {
    private final SingerMapper singerMapper;
    /**
     * 根据歌手条件查询
     * @param keyword
     * @return
     */
    @Override
    public List<Singer> searchBySinger(String keyword) {
        List<Singer> singerList = singerMapper.searchBySinger(keyword);
        return singerList;
    }

    /**
     * 根据 id 查询歌手
     * @param id
     * @return
     */
    @Override
    public Singer getById(Integer id) {
        Singer singer = singerMapper.getById(id);
        return singer;

    }

    /**
     * 查询所有歌手
     * @return
     */
    @Override
    public List<Singer> list() {
       List<Singer> singerList = singerMapper.list();
       return singerList;
    }
}
