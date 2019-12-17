package net.suncaper.myapp.servlet;

import net.suncaper.myapp.common.domain.Student;
import net.suncaper.myapp.dao.StudentDao;
import net.suncaper.myapp.service.StudentService;
import net.suncaper.myapp.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toupdatestu")
public class ToUpdateStuServlet extends HttpServlet {
     StudentService studentService = new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idTxt = request.getParameter("id");
        int id = Integer.parseInt(idTxt);

        Student student = studentService.findStudentById(id);
//        System.out.println(student);
        request.setAttribute("stu",student);
        request.getRequestDispatcher("/views/showStudent4Update.jsp").forward(request,response);
    }
}
