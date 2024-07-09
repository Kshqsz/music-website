package cn.edu.usts.cs2022.controller.admin;

import cn.edu.usts.cs2022.pojo.dto.LoginDTO;
import cn.edu.usts.cs2022.pojo.dto.SingerDTO;
import cn.edu.usts.cs2022.pojo.dto.SongDTO;
import cn.edu.usts.cs2022.pojo.po.*;
import cn.edu.usts.cs2022.service.*;
import cn.edu.usts.cs2022.utils.JwtUtil;
import cn.edu.usts.cs2022.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    public final SongService songService;

    public final SingerService singerService;

    public final UserService userService;

    public final AdminService adminService;

    public final StarService starService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        Admin admin = adminService.login(username, password);
        if (admin == null) {
            return Result.error("账号或密码错误!");
        }
        Map<String, Object> claims = new HashMap<>();
//        Map<String, Object> map = ThreadLocalUtil.get();
//        Integer id = (Integer) map.get("id");
//        claims.put("id", id);
        String token = JwtUtil.genToken(claims);
        return Result.success(token);
    }
    @PostMapping("/addSong")
    public Result addSong(@RequestBody SongDTO songDTO) {
         songService.addSong(songDTO);
         return Result.success();
    }

    @PostMapping("/addSinger")
    public Result addSinger(@RequestBody SingerDTO singerDTO) {
        singerService.addSinger(singerDTO);
        return Result.success();
    }

    @GetMapping("/listUser")
    public Result<List<User>> listUser() {
        List<User> userList = userService.listUser();
        return Result.success(userList);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Result deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return Result.success();
    }

    @PutMapping("/updateSinger")
    public Result updateSinger(@RequestBody Singer singer) {
        singerService.updateSinger(singer);
        return Result.success();
    }

    @DeleteMapping("/deleteSinger/{id}")
    public Result deleteSinger(@PathVariable("id") Integer id) {
        singerService.deleteSinger(id);
        return Result.success();
    }

    @DeleteMapping("/deleteSong/{id}")
    public Result deleteSong(@PathVariable("id") Integer id) {
        songService.deleteSong(id);
        return Result.success();
    }

    @PutMapping("/updateSong")
    public Result updateSong(Song song) {
        songService.updateSong(song);
        return Result.success();
    }

    @GetMapping("/countUser")
    public Result<Integer> countUser() {
        Integer cnt = userService.countUser();
        return Result.success(cnt);
    }

    @GetMapping("/countSinger")
    public Result<Integer> countSinger() {
        Integer cnt = singerService.countSinger();
        return Result.success(cnt);
    }

    @GetMapping("/countSong")
    public Result<Integer> countSong() {
        Integer cnt = songService.countSong();
        return Result.success(cnt);
    }

    @GetMapping("/countStar/{id}")
    public Result<Integer> countStar(@PathVariable("id") Integer id) {
        Integer cnt = starService.countStar(id);
        return Result.success(cnt);
    }
}
