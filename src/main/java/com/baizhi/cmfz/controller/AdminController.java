package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private AdminService as;

    @RequestMapping("/login")
    public Map login(Admin a) {
        System.out.println(a);
        return as.selectOne(a);
    }
}
