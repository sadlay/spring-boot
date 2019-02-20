package com.lay.springsso.ssoclient.filter;

import com.lay.springsso.ssoclient.service.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 认证过滤器（负责判断用户是否登陆和重定向到sso-server）
 * @Author: lay
 * @Date: Created in 16:22 2019/2/20
 * @Modified By:IntelliJ IDEA
 */

@Order(1)
@WebFilter(filterName = "ssoFilter",urlPatterns = "/hello",initParams = {@WebInitParam(name = "EXCLUDED_PAGES",value = "/receiveToken,/ssoLogout,/ssoDeleteToken")})
public class CommonAuthFilter implements Filter {
    @Autowired
    private UserAccessService userAccessService;

    private String excludedPages;
    private String[] excludedPageArray;

    @Value("${sso.server.url}")
    private String ssoServerPath;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.excludedPages=filterConfig.getInitParameter("EXCLUDED_PAGES");
        if(excludedPages!=null){
            excludedPageArray=excludedPages.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        String username = req.getParameter("ssoUser");
        if(!StringUtils.isEmpty(username)&&userAccessService.getUserToken(username)!=null){
            filterChain.doFilter(req,servletResponse);
        }else{
            boolean containFlag=false;
            if(excludedPageArray!=null){
                for (String excludeStr  : excludedPageArray) {
                    if(excludeStr.equals(req.getServletPath())){
                        containFlag=true;
                        break;
                    }
                }
            }
            if(containFlag){
                filterChain.doFilter(req,servletResponse);
            }else {
                //其他情况都丢给SSO中心去处理
                HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
                String originUrl=req.getRequestURL().toString();
                httpResponse.sendRedirect(ssoServerPath+"/index?originUrl="+originUrl+"&ssoUser="+username);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
