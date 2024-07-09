package cn.edu.usts.cs2022.service;

import cn.edu.usts.cs2022.pojo.po.User;

import java.util.List;

public interface UserService {
    User login(String username, String password);

    User getUserByUsername(String username);

    void register(String username, String password);

    User getById(Integer id);

    void updateAvatar(String avatarUrl);

    void updatePassword(String newPassword);

    List<User> listUser();

    void deleteUser(Integer id);
}
