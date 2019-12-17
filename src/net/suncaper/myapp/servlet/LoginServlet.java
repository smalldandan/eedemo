package net.suncaper.myapp.servlet;

import net.suncaper.myapp.common.domain.User;
import net.suncaper.myapp.service.UserService;
import net.suncaper.myapp.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        User userInDb = userService.findUserByName(userName);

        if(userInDb==null){
            request.setAttribute("msg","用户不存在!!");
            request.getRequestDispatcher("/views/login.jsp").forward(request,response);
        }else{
            String pwdDB = userInDb.getPassword();
            if(pwdDB.equals(password)){
                //OK
                request.getSession().setAttribute("currentUser",userInDb);

                request.setAttribute("currentUserName",userName);
                request.getRequestDispatcher("/views/index.jsp").forward(request,response);
            }else {
                request.setAttribute("msg","密码错误!");
                request.getRequestDispatcher("/views/login.jsp").forward(request,response);
            }
        }
    }
}
