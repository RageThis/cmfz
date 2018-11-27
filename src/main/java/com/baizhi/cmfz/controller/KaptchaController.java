package com.baizhi.cmfz.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class KaptchaController {

    @Autowired
    private Producer producer;

    @RequestMapping("/getkaptcha")
    public void getKaptcha(HttpSession session, HttpServletResponse rs) throws IOException {

//		生成文本内容
        String text = producer.createText();

//		把文本中的文字存入session中
        session.setAttribute("code", text);

//		把生成的文本放入图片中生成一个验证码图片
        BufferedImage image = producer.createImage(text);

//		通过图片工具把图片写入响应输出流
        ImageIO.write(image, "jpg", rs.getOutputStream());
    }
}
