package cn.edu.usts.cs2022.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    private Integer id;

    private String singerName;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String pic;

    private String url;
}
