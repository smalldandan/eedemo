package net.suncaper.myapp.servlet;

import net.suncaper.myapp.common.domain.Student;
import net.suncaper.myapp.service.StudentService;
import net.suncaper.myapp.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatestu")
public class SubmitUpdateStudent extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String sex = request.getParameter("sex");
        String stuNo = request.getParameter("stuNo");

//        Student student4Update = new Student().setName(name).setId(Integer.parseInt(id)).setStuNo(stuNo).setSex(sex);
        Student student4Update = new Student(Integer.parseInt(id), name, stuNo, sex);

        studentService.modifyStudent(student4Update);

        request.setAttribute("stu",student4Update);
        request.getRequestDispatcher("/views/Success-Student4Update.jsp").forward(request,response);

    }
}
