package cn.edu.usts.cs2022.service.Impl;


import cn.edu.usts.cs2022.mapper.StarMapper;
import cn.edu.usts.cs2022.service.StarService;
import cn.edu.usts.cs2022.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StarServiceImpl implements StarService {

    public final StarMapper starMapper;

    @Override
    public Integer count(Integer songId, Integer userId) {
        Integer cnt = starMapper.count(songId, userId);
        return cnt;
    }

    @Override
    public void star(Integer songId, Integer userId) {
        starMapper.star(songId, userId);
    }

    @Override
    public List<Integer> getSongIdList(Integer id) {
        List<Integer> songIdList = starMapper.getSongIdList(id);
        return songIdList;
    }

    @Override
    public void cancelStar(Integer songId) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        starMapper.cancelStar(userId, songId);
    }

    @Override
    public Integer countStar(Integer id) {
        return starMapper.countStar(id);
    }
}
