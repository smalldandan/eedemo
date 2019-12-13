package net.suncaper.myapp.dao;

import net.suncaper.myapp.common.domain.Student;
import net.suncaper.myapp.common.utils.MyDbUtil;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectAllStudent() {
        String sql = " select id,name,stuNo,sex from student ";
        List<Student> allStudent = MyDbUtil.executeQuery(Student.class, sql);
        return allStudent;
    }
}
