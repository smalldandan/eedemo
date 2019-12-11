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



    }
}
