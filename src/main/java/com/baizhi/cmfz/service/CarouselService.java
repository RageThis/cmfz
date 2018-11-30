package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Carousel;

import java.util.Map;

public interface CarouselService {
    public Map selectAll(int page, int rows);

    public void updateStates(Carousel c);

    public boolean insert(Carousel c);

    public void delete(int id);
}
