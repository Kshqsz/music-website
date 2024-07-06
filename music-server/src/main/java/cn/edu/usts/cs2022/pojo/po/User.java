package cn.edu.usts.cs2022.pojo.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String username;

    private String password;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String avatar;
}
