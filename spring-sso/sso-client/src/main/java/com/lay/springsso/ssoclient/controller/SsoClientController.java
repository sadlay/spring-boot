package com.lay.springsso.ssoclient.controller;

import com.lay.springsso.ssoclient.service.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:53 2019/2/20
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class SsoClientController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${sso.server.url}")
    String ssoServerPath;

    @Autowired
    private UserAccessService userAccessService;

    @RequestMapping("receiveToken")
    public String receiveToken(HttpServletRequest request, String ssoToken, String userName) {
        if (!StringUtils.isEmpty(ssoToken)) {
            String realUrl = request.getRequestURL().toString();
            String[] paths = realUrl.split("/");
            String realUrlUrls = paths[2];
            String returnUrl = ssoServerPath + "/verifyToken?address=" + realUrlUrls + "&token=" + ssoToken;
            String resultStr = restTemplate.getForObject(returnUrl, String.class);
            if ("true".equals(resultStr)) {
                //创建局部会话，保存用户状态为已登陆
                userAccessService.putUserStatus(userName, ssoToken);
                return "success";
            }
        }
        return "error";
    }
    @RequestMapping("/ssoLogout")
    public String ssoLogout(String userName) {
        String userToken = userAccessService.getUserToken(userName);
        if(userToken!=null) {
            String returnUrl = ssoServerPath+"/logoutByToken?ssoToken="+userToken;
            return restTemplate.getForObject(returnUrl, String.class);
        }
        return "None Token";
    }

    @RequestMapping("/ssoDeleteToken")
    public String ssoDeleteToken(String ssoToken) {
        userAccessService.deleteToken(ssoToken);
        return "success";
    }
}
