package cn.edu.usts.cs2022.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Singer {

    private Integer id;

    private String name;

    private Integer sex;

    private Date birth;

    private String pic;

    private String location;

    private String introduction;
}
