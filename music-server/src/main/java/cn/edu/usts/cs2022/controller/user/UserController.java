package cn.edu.usts.cs2022.controller.user;

import cn.edu.usts.cs2022.pojo.dto.LoginDTO;
import cn.edu.usts.cs2022.pojo.dto.RegisterDTO;
import cn.edu.usts.cs2022.pojo.dto.UpdatePasswordDTO;
import cn.edu.usts.cs2022.pojo.dto.UserDTO;
import cn.edu.usts.cs2022.pojo.po.Result;
import cn.edu.usts.cs2022.pojo.po.Song;
import cn.edu.usts.cs2022.pojo.po.User;
import cn.edu.usts.cs2022.service.SongService;
import cn.edu.usts.cs2022.service.StarService;
import cn.edu.usts.cs2022.service.UserService;
import cn.edu.usts.cs2022.utils.JwtUtil;
import org.hibernate.validator.constraints.URL;
import cn.edu.usts.cs2022.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final StarService starService;

    private final SongService songService;

    /**
     * 用户登录
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    public Result Login(@RequestBody LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        User user = userService.login(username, password);
        if (user == null) {
            return Result.error("用户名或密码错误");
        } else {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            String token = JwtUtil.genToken(claims);
            UserDTO userDTO = new UserDTO();
            userDTO.setUser(user);
            userDTO.setUserId(user.getId());
            userDTO.setToken(token);
            return Result.success(userDTO);
        }
    }

    /**
     * 用户注册
     * @param registerDTO
     * @return
     */
    @PostMapping("/register")
    public Result Register(@RequestBody RegisterDTO registerDTO) {
        String username = registerDTO.getUsername();
        String password = registerDTO.getPassword();
        String rePassword = registerDTO.getRePassword();

        if (!password.equals(rePassword)) {
            return Result.error("两次密码输入不一致!");
        }
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return Result.error("用户名已存在");
        }
        userService.register(username, password);
        return Result.success();
    }

    @GetMapping("/getById/{id}")
    public Result<User> getById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

    @PostMapping("/star/{songId}")
    public Result star(@PathVariable("songId") Integer songId) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        Integer cnt = starService.count(songId, userId);
        if (cnt > 0) {
            return Result.error("已经收藏过了");
        } else {
            starService.star(songId, userId);
            return Result.success();
        }
    }
    @GetMapping("/starList/{id}")
    public Result<List<Song>> starList(@PathVariable("id") Integer id) {
        List<Integer> songIdList = starService.getSongIdList(id);
        if (songIdList.isEmpty()) {
            List<Song> songList = new ArrayList<>();
            return Result.success(songList);
        }
        List<Song> songList = songService.getByIds(songIdList);
        return Result.success(songList);
    }

    @DeleteMapping("/cancelStar/{id}")
    public Result cancelStar(@PathVariable("id") Integer id) {
        starService.cancelStar(id);
        return Result.success();
    }

    @PostMapping("/updateAvatar")
    public Result<User> updateAvatar(@RequestBody String avatarUrl) throws UnsupportedEncodingException {
        avatarUrl = URLDecoder.decode(avatarUrl, "UTF-8");
        avatarUrl = avatarUrl.substring(0, avatarUrl.length() - 1);
        System.out.println(avatarUrl);
        userService.updateAvatar(avatarUrl);
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        User user = userService.getById(id);
        return Result.success(user);
    }

    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody UpdatePasswordDTO updatePasswordDTO) {
        String newPassword = updatePasswordDTO.getNewPassword();
        String reNewPassword = updatePasswordDTO.getReNewPassword();
        if (!newPassword.equals(reNewPassword)) {
            return Result.error("两次密码不一致!");
        }
        userService.updatePassword(newPassword);
        return Result.success();
    }
}
