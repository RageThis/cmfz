package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao md;

    @Override
    public Map selectAll() {
        Map map = new HashMap();
        map.put("menu", md.quarryAll());
        System.out.println(map);
        return map;
    }
}
