package com.lay.springboot.springsecurity.controller;

import com.lay.springboot.springsecurity.util.ImageCode;
import org.springframework.session.SessionRepository;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Description: 图形验证码控制器
 * @Author: lay
 * @Date: Created in 11:45 2019/1/11
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class ImageValidateController {
    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        ImageCode imageCode = caretaImageCode(request);
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);
        //将验证码图片以jpeg格式写入输入流，以在页面显示
        ImageIO.write(imageCode.getBufferedImage(),"JPEG",response.getOutputStream());
    }

    private ImageCode caretaImageCode(HttpServletRequest request) {
        //验证码图片宽度
        int width = 65;
        //验证码图片高度
        int height = 25;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = bufferedImage.getGraphics();
        Random random = new Random();
        // 设置图片背景色
        g.setColor(getRandomColor(200, 500));
        g.setColor(getRandomColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRandomColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 16);
        }
        g.dispose();
        return new ImageCode(bufferedImage, sRand, 60);
    }

    /**
     * @param fc
     * @param bc
     * @Description: 生成随机背景条纹
     * @param:
     * @return: java.awt.Color
     * @auther: lay
     * @date: 11:55 2019/1/11
     */
    private Color getRandomColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
