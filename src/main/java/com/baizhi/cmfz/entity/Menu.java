package com.baizhi.cmfz.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private int id;
    private String title;
    private String iconCls;
    private int parent_id;
    private String url;
    private List<Menu> mlist;
}
