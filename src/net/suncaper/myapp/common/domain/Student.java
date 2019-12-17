package net.suncaper.myapp.common.domain;

public class Student {
   private int id;
   private String name;
   private String stuNo;
   private String sex;

    public Student() {
    }

    public Student(int id, String name, String stuNo, String sex) {
        this.id = id;
        this.name = name;
        this.stuNo = stuNo;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getStuNo() {
        return stuNo;
    }

    public Student setStuNo(String stuNo) {
        this.stuNo = stuNo;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Student setSex(String sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
