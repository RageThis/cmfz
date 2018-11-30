package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.CarouselDao;
import com.baizhi.cmfz.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselDao cd;

    @Override
    public Map selectAll(int page, int rows) {
        Map map = new HashMap();
        int start = (page - 1) * rows;
        int count = cd.getCount();
        map.put("rows", cd.selectByPrimaryKey(start, rows));
        map.put("total", count);
        return map;
    }

    @Override
    public void updateStates(Carousel c) {
        cd.updateStatus(c);
    }

    @Override
    public boolean insert(Carousel c) {
        try {
            cd.insertOne(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int id) {
        cd.delete(id);
    }
}
