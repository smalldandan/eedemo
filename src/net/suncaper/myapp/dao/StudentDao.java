package net.suncaper.myapp.dao;

import net.suncaper.myapp.common.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectAllStudent();
}
