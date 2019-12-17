package net.suncaper.myapp.servlet;

import net.suncaper.myapp.common.domain.Student;
import net.suncaper.myapp.common.utils.PageInfo;
import net.suncaper.myapp.service.StudentService;
import net.suncaper.myapp.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/listStudent")
public class ListStudentServlet extends HttpServlet {
    StudentService StudentService = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageNoStr = request.getParameter("pageNo");// "2" --> 2
        String pageSizeStr = request.getParameter("pageSize");
        int pageNo = 1;
        int pageSize = 10;
        if (pageNoStr != null) {
            pageNo = Integer.parseInt(pageNoStr.trim());
        }
        if (pageSizeStr != null) {
            pageSize = Integer.parseInt(pageSizeStr.trim());
        }
        PageInfo<Student> pageInfo = StudentService.findAllStudentByPage(pageNo, pageSize);
        request.setAttribute("pageInfo", pageInfo);
        request.getRequestDispatcher("/views/listStudent.jsp").forward(request, response);
    }

}
