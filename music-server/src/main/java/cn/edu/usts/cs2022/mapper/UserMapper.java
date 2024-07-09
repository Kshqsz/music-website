package cn.edu.usts.cs2022.mapper;

import cn.edu.usts.cs2022.pojo.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    User login(@Param("username") String username,
               @Param("password") String password);

    @Select("select * from user where username = #{username}")
    User getUserByUsername(String username);

    void register(User user);

    @Select("select * from user where id = #{id}")
    User getById(Integer id);

    @Update("update user set avatar= #{avatarUrl}, update_time = now() where id = #{id}")
    void updateAvatar(@Param("avatarUrl") String avatarUrl,
                      @Param("id") Integer id);

    @Update("update user set password = #{newPassword}, update_time = now() where id = #{id}")
    void updatePassword(@Param("newPassword") String newPassword,
                        @Param("id") Integer id);

    @Select("select * from user")
    List<User> listUser();

    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);
}
