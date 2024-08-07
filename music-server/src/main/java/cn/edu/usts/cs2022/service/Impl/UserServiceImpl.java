package cn.edu.usts.cs2022.service.Impl;

import cn.edu.usts.cs2022.mapper.StarMapper;
import cn.edu.usts.cs2022.mapper.UserMapper;
import cn.edu.usts.cs2022.pojo.dto.SexDTO;
import cn.edu.usts.cs2022.pojo.po.User;
import cn.edu.usts.cs2022.service.UserService;
import cn.edu.usts.cs2022.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserMapper userMapper;
    private final StarMapper starMapper;

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

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl, id);
    }

    @Override
    public void updatePassword(String newPassword) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePassword(newPassword, id);
    }

    @Override
    public List<User> listUser() {
        List<User> userList = userMapper.listUser();
        return userList;
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
        starMapper.deleteSongByUserId(id);
    }

    @Override
    public Integer countUser() {
        Integer cnt = userMapper.countUser();
        return cnt;
    }

}
