package net.suncaper.myapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (userName.equals("admin") && password.equals("password")) {
            request.setAttribute("currentUserName", userName);
            request.getRequestDispatcher("/views/index.jsp").forward(request,response);
        } else {
            request.setAttribute("msg", "登录失败！");
            request.getRequestDispatcher("/views/login.jsp").forward(request,response);
        }

        // userName = new String(userName.getBytes("ISO-8859-1"),"UTF-8");//字符转码的方式
   /*    System.out.println(userName+"/"+password);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("已经接受daoshuju");*/

/**
 request 的作用

 1. 获取浏览器发送的参数
 2. 转发到其他路径
 3. 可以存储属性值,相当于Map,(存储数据,交给页面作展示)
 */

    }
}
