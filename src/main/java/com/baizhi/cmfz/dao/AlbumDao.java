package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDao {
    public List<Album> selectAll(@Param("start") int start,
                                 @Param("rows") int rows);

    public int getCount();

    void insertOne(Album a);
}
