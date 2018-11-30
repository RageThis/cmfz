package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Carousel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarouselDao {
    public List<Carousel> selectByPrimaryKey(@Param("start") int start,
                                             @Param("rows") int rows);

    public void updateStatus(Carousel c);

    public int getCount();

    public void delete(int id);

    public void insertOne(Carousel c);
}