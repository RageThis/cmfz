package com.baizhi.cmfz.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Chapter {
    private int id;
    private String title;
    private double size;
    private String duration;
    private String downpath;
    private Date uploaddate;
    private int parentid;
}
