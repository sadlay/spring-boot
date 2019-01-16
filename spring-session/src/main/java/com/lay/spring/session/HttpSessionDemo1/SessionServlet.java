package com.lay.spring.session.HttpSessionDemo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:45 2019/1/16
 * @Modified By:IntelliJ IDEA
 */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    private static final Logger log= LoggerFactory.getLogger(SessionServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info(req.getRemoteAddr());
        log.info("{}:{}",req.getRemoteHost(),req.getRemotePort());

        String sessionId=req.getSession().getId();
        log.info("-----tomcat1 sessionId----------{}",sessionId);

        String testKey= (String) req.getSession().getAttribute("testKey");
        log.info("-----tomcat1 testKey----------{}",testKey);
        PrintWriter out=null;
        try {
            out = resp.getWriter();
            out.append(MessageFormat.format("-----tomcat1 sessionId----------{0}",sessionId));
            out.append("{\"name\":\"dufy2\"}"+"\n");
            out.append(MessageFormat.format("-----tomcat1 testKey----------{0}",testKey));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out!=null){
                out.close();
            }
        }
    }

    public static void main(String[] args){
        String message=MessageFormat.format("{0}:{1}:{2}:'{''}","这是我","不是你",new Date());
        System.out.println(message);
    }
}
