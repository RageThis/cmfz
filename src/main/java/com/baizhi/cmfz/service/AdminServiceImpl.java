package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao ad;

    @Override
    public Map selectOne(Admin a) {
        Map map = new HashMap();
        Admin aa = ad.quarryOne(a);
        if (aa != null) {
            map.put("admin", aa);
            map.put("login", true);
        } else {
            map.put("login", false);
        }
        return map;
    }
}
