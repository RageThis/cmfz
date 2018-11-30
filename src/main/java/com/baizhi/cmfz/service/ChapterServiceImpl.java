package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.ChapterDao;
import com.baizhi.cmfz.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao cd;

    @Override
    public boolean add(Chapter c) {
        try {
            cd.insert(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
