package cn.edu.usts.cs2022.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingerDTO {
    private String name;

    private Integer sex;

    private Date birth;

    private String pic;

    private String location;

    private String introduction;
}
