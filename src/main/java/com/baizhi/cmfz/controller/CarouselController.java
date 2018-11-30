package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Carousel;
import com.baizhi.cmfz.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
public class CarouselController {

    @Autowired
    private CarouselService cs;

    @RequestMapping("/CselectAll")
    public Map selectAll(int page, int rows) {
        System.out.println(cs.selectAll(page, rows));
        return cs.selectAll(page, rows);
    }

    @RequestMapping("/Cupdate")
    public void update(Carousel c) {
        System.out.println(c);
        cs.updateStates(c);
    }

    @RequestMapping("/Cdelete")
    public void delete(int id) {
        cs.delete(id);
    }

    @RequestMapping("/Cadd")
    public boolean insertt(Carousel c, HttpServletRequest request,
                           MultipartFile uploadFile) {
        System.out.println(c);
        System.out.println(cs.insert(c));

        // 获取文件的名字
        String fileName = uploadFile.getOriginalFilename();
        System.out.println("文件上传的名字" + fileName);
        // 文件重新命名
        // fileName = new Date().getTime() + "_" + fileName;
        // 把接收到的文件转换成磁盘文件
        // wenjian.transferTo(new
        // File("F:\\Tomcat\\apache-tomcat-7.0.72\\webapps\\SpringmvcAuction\\wenjian"+fileName));
        // 根据文件夹名字获取绝对路径
        String realPath = request.getRealPath("img");
        try {
            uploadFile.transferTo(new File(realPath + "\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        c.setImgPath(fileName);
        System.out.println(c);
        return cs.insert(c);

    }
}
