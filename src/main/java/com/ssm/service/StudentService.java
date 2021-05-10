package com.ssm.service;

import com.ssm.domain.Student;


public interface StudentService {

    //登录
    public Student login(String student_id,String password);

    //注册
    public  int register(Student student);

    //注销
    public int logout(String student_id);

}
