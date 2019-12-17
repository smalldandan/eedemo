package net.suncaper.myapp.dao;

import net.suncaper.myapp.common.domain.Student;
import net.suncaper.myapp.common.utils.CountObject;
import net.suncaper.myapp.common.utils.MyDbUtil;
import net.suncaper.myapp.common.utils.PageInfo;

import java.sql.Connection;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    //不分页显示学生信息
    @Override
    public List<Student> selectAllStudent() {
        String sql = " select id,name,stuNo,sex from student ";
        return MyDbUtil.executeQuery(Student.class, sql);
    }

    //分页显示学生记录
    @Override
    public PageInfo<Student> selectAllStudentByPage(int pageNo, int pageSize) {
        // 一个方法中同时执行多次SQL 语句: 先获取同一个连接.再用这个连接去执行多个SQL 语句
        Connection conn = MyDbUtil.getConnection();

        PageInfo<Student> rs;

        String sql1 =" select count(*) 'count' from student ";
        List<CountObject> list = MyDbUtil.executeQuery(conn,CountObject.class,sql1);
        int count = (int) list.get(0).getCount();//计算总记录条数

        String sql2 =" SELECT id,name,stuNo,sex FROM student limit ?,? ";
        List<Student> students = MyDbUtil.executeQuery(conn,Student.class, sql2, (pageNo - 1) * pageSize, pageSize);
        //计算参数并执行sql查询，返回一个 List<Student>

        //将 List<Student> 封装成pageInfo<Student>
        rs = new PageInfo<>(pageNo, pageSize, count, students);


        MyDbUtil.closeConnection();
//        System.out.println(rs);

        return rs;
    }

    @Override
    public int deleteStudentByPrimaryKey(int id) {

        String sql = "delete from student where id = ?";
        int i = MyDbUtil.executeUpdate(sql, id);
//        返回值是更新的行数，effect rows
//        System.out.println(i);
        return i;

    }

    @Override
    public Student selectStudentByPrimaryKey(int id) {

        String sql =" SELECT id,name,stuNo,sex FROM student where id = ? ";

        List<Student> students = MyDbUtil.executeQuery(Student.class, sql, id);
        return students.size()>0?students.get(0):null;

    }

    @Override
    public void updateStudent(Student student4Update) {
        String sql = " update student set name = ?,stuNo = ?,sex = ? where id = ? ";
        MyDbUtil.executeUpdate(sql,student4Update.getName(),student4Update.getStuNo(),student4Update.getSex(),student4Update.getId());
    }

    public static void main(String[] args) {
//        测试用例
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.selectStudentByPrimaryKey(24);
        System.out.println(student.getName());
    }
}
