package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MenuController {


    @Autowired
    private MenuService ms;

    @RequestMapping("/mselectAll")
    public Map selectAll() {
        return ms.selectAll();
    }
}
