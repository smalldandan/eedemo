package net.suncaper.myapp.servlet;

import net.suncaper.myapp.common.domain.Student;
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
        List<Student> allStudent = listStudentService.findAllStudent();
//        super.service(request, response);
//        for (Student student : allStudent) {
//            System.out.println(student);
//        }
        request.setAttribute("allStudent",allStudent);
        request.getRequestDispatcher("/views/listStudent.jsp").forward(request,response);
    }

}
