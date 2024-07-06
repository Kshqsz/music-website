package cn.edu.usts.cs2022.controller.user;

import cn.edu.usts.cs2022.pojo.po.Result;
import cn.edu.usts.cs2022.pojo.po.Singer;
import cn.edu.usts.cs2022.service.SingerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/singer")
@RequiredArgsConstructor
public class SingerController {
    public final SingerService singerService;

    @GetMapping("/{id}")
    public Result<Singer> getById(@PathVariable Integer id) {
        Singer singer = singerService.getById(id);
        return Result.success(singer);
    }

    @GetMapping("/list")
    public Result<List<Singer>> list() {
        List<Singer> singerList = singerService.list();
        return Result.success(singerList);
    }
}
