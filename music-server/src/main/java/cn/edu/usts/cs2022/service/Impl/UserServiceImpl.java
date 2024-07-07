package cn.edu.usts.cs2022.service.Impl;

import cn.edu.usts.cs2022.mapper.UserMapper;
import cn.edu.usts.cs2022.pojo.po.User;
import cn.edu.usts.cs2022.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserMapper userMapper;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    /**
     * 用户注册
     * @param username
     * @param password
     */
    @Override
    public void register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.register(user);
    }

    /**
     * 根据 id 查询用户
     * @param id
     * @return
     */
    @Override
    public User getById(Integer id) {
        User user = userMapper.getById(id);
        return user;
    }
}
