package net.suncaper.myapp.service;

import net.suncaper.myapp.common.domain.Student;
import net.suncaper.myapp.common.utils.PageInfo;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    PageInfo<Student> findAllStudentByPage(int pageNo, int pageSize);

    int removeStudentByPrimaryKey(int id);
}
