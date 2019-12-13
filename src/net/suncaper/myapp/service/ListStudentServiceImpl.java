package net.suncaper.myapp.service;

import net.suncaper.myapp.common.domain.Student;
import net.suncaper.myapp.dao.StudentDao;
import net.suncaper.myapp.dao.StudentDaoImpl;

import java.util.List;

public class ListStudentServiceImpl implements ListStudentService {
    StudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> findAllStudent() {
        return studentDao.selectAllStudent();
    }
}
