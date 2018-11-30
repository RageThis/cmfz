package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Album;
import com.baizhi.cmfz.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AlbumController {

    @Autowired
    private AlbumService as;

    @RequestMapping("/AselectAll")
    public Map selectAll(int page, int rows) {
        System.out.println(page + "+++++" + rows);
        System.out.println(as.selectAll(page, rows));
        return as.selectAll(page, rows);
    }

    @RequestMapping("/Ainsert")
    public boolean insert(Album a) {
        try {
            as.insert(a);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*@RequestMapping("/Aadd")
    public boolean add(Album a, MultipartFile chapter,
                       HttpServletRequest request) {
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
        a.set
        return false;
    }*/
}
