package com;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by liviu on 2/8/2016.
 */
//urlPatterns = {"/annotated1","/annotated2"},
@WebServlet(initParams = {@WebInitParam(name = "myname", value = "myvalue")},
         value = "/annotated3")
public class ServletAnnotated extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);//Atenttion , will not work in combination with getSession(true)
        resp.setContentType("text/html");
        PrintWriter out = new PrintWriter(resp.getOutputStream());
        out.print("<html><body>");
        ServletContext context = getServletContext();
        req.getSession(true);
        if(context == null) {
            out.print("NUll Context");
        } else {

            out.print(context.getInitParameter("myname"));
        }
        out.print("</body></html>");

        out.flush();
    }
}
