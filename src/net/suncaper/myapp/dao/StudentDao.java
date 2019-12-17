package net.suncaper.myapp.dao;

import net.suncaper.myapp.common.domain.Student;
import net.suncaper.myapp.common.utils.PageInfo;

import java.util.List;

public interface StudentDao {
    List<Student> selectAllStudent();

    PageInfo<Student> selectAllStudentByPage(int pageNo, int pageSize);

    int deleteStudentByPrimaryKey(int id);

    Student selectStudentByPrimaryKey(int id);

    void updateStudent(Student student4Update);
}
