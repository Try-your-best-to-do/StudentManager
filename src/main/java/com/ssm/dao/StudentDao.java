package com.ssm.dao;

import com.ssm.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 学生、用户Dao接口
* */
@Repository //spring持久层注解
public interface StudentDao {

    //查询所有
    @Select("select * from student")
    public List<Student> findAll();

    //保存账户
    @Insert("insert into student (student_id,password,name,sex,class_grade,major,phone) values (#{student_id},#{password},#{name},#{sex},#{class_grade},#{major},#{phone})")
    public  int  saveStudent(Student student);

    //删除账户
    @Delete("delete from student where student_id = #{student_id}")
    public int Delete(String student_id);

    //根据id查询用户
    @Select("select * from student where student_id = #{student_id}")
    public Student findById(String student_id);

    //根据名字模糊查询
    @Select("select * from student where name like #{name}")
    public List<Student> findByName(String name);

    //修改密码
    @Update("update student set password = #{password} where student_id = #{student_id}")
    public int updateStudent(String student_id,String password);

}
