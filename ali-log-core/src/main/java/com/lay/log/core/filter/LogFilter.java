package com.lay.log.core.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:22 2019/3/19
 * @Modified By:IntelliJ IDEA
 */
public class LogFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(LogFilter.class);


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("start log filter");
        this.insertIntoMDC(request);
        log.info("log filter....");
        try {
            chain.doFilter(request, response);
        } finally {
            log.info("log filter....");
            this.clearMDC();
            log.info("end log filter");
        }

    }

    void insertIntoMDC(ServletRequest request) {
        MDC.put("req.remoteHost", request.getRemoteHost());
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            MDC.put("req.requestURI", httpServletRequest.getRequestURI());
            StringBuffer requestURL = httpServletRequest.getRequestURL();
            if (requestURL != null) {
                MDC.put("req.requestURL", requestURL.toString());
            }
            String requestNo = httpServletRequest.getHeader("Request-No");
            if (requestNo != null && !requestNo.equals("")) {
                MDC.put("req.requestNo", requestNo);
            }
            MDC.put("req.method", httpServletRequest.getMethod());
            MDC.put("req.queryString", httpServletRequest.getQueryString());
            MDC.put("req.userAgent", httpServletRequest.getHeader("User-Agent"));
            MDC.put("req.xForwardedFor", httpServletRequest.getHeader("X-Forwarded-For"));
            MDC.put("req.hostIp", getHostIp());
        }
    }

    void clearMDC() {
        MDC.remove("req.remoteHost");
        MDC.remove("req.requestURI");
        MDC.remove("req.queryString");
        MDC.remove("req.requestURL");
        MDC.remove("req.method");
        MDC.remove("req.userAgent");
        MDC.remove("req.xForwardedFor");
        MDC.remove("req.requestNo");
        MDC.remove("req.hostIp");
    }


    @Override
    public void destroy() {

    }

    public String getHostIp() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostAddress();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}
