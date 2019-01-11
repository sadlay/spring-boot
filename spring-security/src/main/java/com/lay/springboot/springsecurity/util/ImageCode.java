package com.lay.springboot.springsecurity.util;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Description: 验证码信息
 * @Author: lay
 * @Date: Created in 11:26 2019/1/11
 * @Modified By:IntelliJ IDEA
 */
public class ImageCode {
    //验证码图片
    private BufferedImage bufferedImage;

    //验证码随机数字
    private String code;

    //验证码失效事件
    private LocalDateTime expireTime;

    public ImageCode(BufferedImage bufferedImage, String code, long second) {
        this.bufferedImage = bufferedImage;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(second);
    }

    public ImageCode(BufferedImage bufferedImage, String code, LocalDateTime expireTime) {
        this.bufferedImage = bufferedImage;
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
