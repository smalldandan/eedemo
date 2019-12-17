package net.suncaper.myapp.servlet;

import net.suncaper.myapp.service.StudentService;
import net.suncaper.myapp.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delStudent")
public class DelStudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stuId = request.getParameter("id");
        int id = Integer.parseInt(stuId);
        System.out.println(studentService.removeStudentByPrimaryKey(id));

        String pageNoStr = request.getParameter("pageNo");// "2" --> 2
        String pageSizeStr = request.getParameter("pageSize");
        int pageNo = 1;
        int pageSize = 10;
        if(pageNoStr!=null){
            pageNo = Integer.parseInt(pageNoStr.trim());
        }
        if(pageSizeStr!=null){
            pageSize = Integer.parseInt(pageSizeStr.trim());
        }

//        重定向
//        重定向
        response.sendRedirect(request.getContextPath()+"/listStudent?pageNo="+pageNo+"&pageSize="+pageSize);


    }
}
