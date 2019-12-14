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
        List<Student> allStudent = MyDbUtil.executeQuery(Student.class, sql);
        return allStudent;
    }

    //分页显示学生记录
    @Override
    public PageInfo<Student> selectAllStudentByPage(int pageNo, int pageSize) {
        // 一个方法中同时执行多次SQL 语句: 先获取同一个连接.再用这个连接去执行多个SQL 语句
        Connection conn = MyDbUtil.getConnection();

        PageInfo<Student> rs = null;

        String sql1 =" select count(*) 'count' from student ";
        List<CountObject> list = MyDbUtil.executeQuery(conn,CountObject.class,sql1);
        int count = (int) list.get(0).getCount();//计算总记录条数

        String sql2 =" SELECT id,name,stuNo,sex FROM student limit ?,? ";
        List<Student> students = MyDbUtil.executeQuery(conn,Student.class, sql2, (pageNo - 1) * pageSize, pageSize);
        //计算参数并执行sql查询，返回一个 List<Student>

        //将 List<Student> 封装成pageInfo<Student>
        rs = new PageInfo<Student>(pageNo,pageSize,count,students);


        MyDbUtil.closeConnection();
        System.out.println(rs);

        return rs;
    }

    @Override
    public int deleteStudentByPrimaryKey(int id) {

        String sql = "delete from student where id = ?";
        int i = MyDbUtil.executeUpdate(sql, id);
        System.out.println(i);
        return i;

    }
}
