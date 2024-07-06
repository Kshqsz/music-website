<<<<<<< HEAD
package cn.edu.usts.cs2022.mapper;

import cn.edu.usts.cs2022.pojo.po.Singer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SingerMapper {
    List<Singer> searchBySinger(String keyword);
}
=======
package cn.edu.usts.cs2022.mapper;

import cn.edu.usts.cs2022.pojo.po.Singer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SingerMapper {
    List<Singer> searchBySinger(String keyword);
}
>>>>>>> e2484d075ab92c8eb6c49421a93acdc37135dff8
