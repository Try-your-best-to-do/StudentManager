package com.ssm.service.impl;

import com.ssm.dao.StudentDao;
import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService") //spring页面层注释,相当于要给studentService注入
public class StudentServiceImpl implements StudentService {

    @Autowired  //spring依赖注入
    private StudentDao studentDao;

    @Override
    public Student login(String student_id, String password) {
        List<Student> students = studentDao.findAll();
        for (Student student : students){
            if (student.getStudent_id().equals(student_id)&&student.getPassword().equals(password)){
                return student;
            }
        }
        return null;
    }

    @Override
    public int register(Student student) {
        int flag = studentDao.saveStudent(student);
        return flag;
    }

    @Override
    public int logout(String student_id) {
        int flag = studentDao.Delete(student_id);
        return flag;
    }
}
