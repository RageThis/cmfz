package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private AdminService as;


    @RequestMapping("/login")
    public Map login(Admin a, String enCode, HttpSession session) {
        String sessionkaptcha = (String) session.getAttribute("code");
        Map map = new HashMap();
        if (enCode.equals(sessionkaptcha)) {
            return as.selectOne(a);
        } else {
            map.put("login", false);
            return map;
        }

    }
}
