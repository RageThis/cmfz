package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.Chapter;
import com.baizhi.cmfz.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
public class ChapterController {

    @Autowired
    private ChapterService cs;

    @RequestMapping("/ChapterAdd")
    public boolean add(Chapter c, MultipartFile chapter,
                       HttpServletRequest request, int cc_id) {
        System.out.println(cc_id);
        // 获取文件的名字
        String fileName = chapter.getOriginalFilename();
        System.out.println("文件上传的名字" + fileName);
        // 文件重新命名
        // fileName = new Date().getTime() + "_" + fileName;
        // 把接收到的文件转换成磁盘文件
        // wenjian.transferTo(new
        // File("F:\\Tomcat\\apache-tomcat-7.0.72\\webapps\\SpringmvcAuction\\wenjian"+fileName));
        // 根据文件夹名字获取绝对路径
        String savePath = request.getRealPath("/upload");
        File file = new File(savePath);
        System.out.println(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            //创建目录
            file.mkdir();
        }
        try {
            chapter.transferTo(new File(savePath + "\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            c.setDownpath(fileName);
           /* int i = FileUtil.getDuration(file+"/"+fileName);
            int m=i/60;
            int s=i%60;
            String time=m+"分"+s+"秒";*/
            c.setDuration("1分10秒");
            long size = chapter.getSize();
            double l = size / 1024.0 / 1024.0;
            c.setSize(l);
            System.out.println(cc_id);
            c.setParentid(cc_id);
            System.out.println(c);
            cs.add(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/getChapter")
    public void getChapter(Chapter c, HttpServletRequest request,
                           HttpServletResponse response) {
        System.out.println(c);
        //webapp当前项目的路径
        String uploadPath = request.getSession().getServletContext().getRealPath("upload");
        String path = uploadPath + "/" + c.getDownpath();
        File file = new File(path);
        String s = c.getDownpath();
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(s, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("audio/mpeg");

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  /*  @RequestMapping("/download")
    public void download(String downPath, String title, HttpServletRequest request, HttpServletResponse response) {
        String uploadPath = request.getSession().getServletContext().getRealPath("upload");  //webapp当前项目的路径
        String path = uploadPath + "/" + downPath;
        File file = new File(path);
        String s = title + "." + "mp3";

        System.out.println(downPath);
        System.out.println(title);
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(s, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("audio/mpeg");

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/
}
