package cn.edu.usts.cs2022.service.Impl;


import cn.edu.usts.cs2022.mapper.AdminMapper;
import cn.edu.usts.cs2022.pojo.po.Admin;
import cn.edu.usts.cs2022.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    public final AdminMapper adminMapper;
    @Override
    public Admin login(String username, String password) {
        Admin admin = adminMapper.login(username, password);
        return admin;
    }
}
