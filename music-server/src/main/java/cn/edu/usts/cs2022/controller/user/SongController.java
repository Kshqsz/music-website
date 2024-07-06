package cn.edu.usts.cs2022.controller.user;

import cn.edu.usts.cs2022.pojo.dto.SearchDTO;
import cn.edu.usts.cs2022.pojo.po.Result;
import cn.edu.usts.cs2022.pojo.po.Singer;
import cn.edu.usts.cs2022.pojo.po.Song;
import cn.edu.usts.cs2022.service.SingerService;
import cn.edu.usts.cs2022.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.directory.SearchResult;
import java.util.List;

@RestController
@RequestMapping("/song")
@RequiredArgsConstructor
public class SongController {

    public final SongService songService;
    public final SingerService singerService;

    @GetMapping("/search")
    public Result<SearchDTO> search(String keyword) {
        List<Song> songList = songService.searchBySong(keyword);
        List<Singer> singerList = singerService.searchBySinger(keyword);
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setSongList(songList);
        searchDTO.setSingerList(singerList);
        return Result.success(searchDTO);
    }
}
