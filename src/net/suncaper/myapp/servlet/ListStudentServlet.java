package net.suncaper.myapp.servlet;

import net.suncaper.myapp.common.domain.Student;
import net.suncaper.myapp.common.utils.PageInfo;
import net.suncaper.myapp.service.ListStudentService;
import net.suncaper.myapp.service.ListStudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listStudent")
public class ListStudentServlet extends HttpServlet {
    ListStudentService listStudentService = new ListStudentServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Student> allStudent = listStudentService.findAllStudentByPage();
//        super.service(request, response);
//        for (Student student : allStudent) {
//            System.out.println(student);
//        }

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
        PageInfo<Student> pageInfo = listStudentService.findAllStudentByPage(pageNo, pageSize);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/views/listStudent.jsp").forward(request,response);
    }

}
