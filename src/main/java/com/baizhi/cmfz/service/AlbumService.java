package com.baizhi.cmfz.service;


import com.baizhi.cmfz.entity.Album;

import java.util.Map;

public interface AlbumService {
    public Map selectAll(int page, int rows);

    public void insert(Album a);
}
