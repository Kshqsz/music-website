package cn.edu.usts.cs2022.pojo.dto;

import cn.edu.usts.cs2022.pojo.po.Singer;
import cn.edu.usts.cs2022.pojo.po.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {
    private List<Song> songList;

    private List<Singer> singerList;
}
