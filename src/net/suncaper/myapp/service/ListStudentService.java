package net.suncaper.myapp.service;

import net.suncaper.myapp.common.domain.Student;
import net.suncaper.myapp.common.utils.PageInfo;

import java.util.List;

public interface ListStudentService {
    List<Student> findAllStudent();
    PageInfo<Student> findAllStudentByPage(int pageNo, int pageSize);
}
