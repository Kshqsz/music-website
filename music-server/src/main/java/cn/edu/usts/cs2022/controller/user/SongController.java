package cn.edu.usts.cs2022.controller.user;

import cn.edu.usts.cs2022.pojo.dto.SearchDTO;
import cn.edu.usts.cs2022.pojo.po.Result;
import cn.edu.usts.cs2022.pojo.po.Singer;
import cn.edu.usts.cs2022.pojo.po.Song;
import cn.edu.usts.cs2022.service.SingerService;
import cn.edu.usts.cs2022.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getBySingerId/{singerId}")
    public Result<List<Song>> getBySingerId(@PathVariable Integer singerId) {
        List<Song> songList = songService.getBySingerId(singerId);
        return Result.success(songList);
    }

    @GetMapping("/list")
    public Result<List<Song>> list() {
        List<Song> songList = songService.list();
        return Result.success(songList);
    }

}
