package com.ssm.controller;


import com.ssm.domain.Student;
import com.ssm.exception.SysException;
import com.ssm.service.StudentService;
import com.ssm.utils.DoCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;


@Controller   //SpringMVC注解
@RequestMapping("/student")  //SpringMVC请求的一级目录
public class StudentController {

    @Autowired  //交给spring管理，降低程序耦合
    private StudentService studentService;

    @RequestMapping("/login")
    public String login(Student student, Model model, HttpServletResponse response)throws SysException{
        try{

            Student student1 = studentService.login(student.getStudent_id(),student.getPassword());
            if (student1 != null){
                DoCookie.setCookie("name",student1.getName());
                response.addCookie(DoCookie.getCookie());
                DoCookie.setCookie("student_id",student1.getStudent_id());
                response.addCookie(DoCookie.getCookie());
                response.sendRedirect("/event/findAllSchedule?student_id="+student1.getStudent_id());
                return "main";
            }else {
                model.addAttribute("msg","登陆失败！请输入账号密码重试！");
                return "login";
            }
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("登录出现错误了，请重新检查信息再试一次吧！");
        }
    }

    @RequestMapping("/register")
    public String register(Student student, Model model) throws SysException {
        try{
            if (student.getPassword()!=""&&student.getStudent_id()!=""&&student.getName()!=""){
                int flag = studentService.register(student);
                if (flag == 1){
                    model.addAttribute("msg","注册成功！");
                    return "login";
                }else {
                    model.addAttribute("msg","注册失败！请重新注册！");
                    return "register";
                }
            }else {
                model.addAttribute("msg","注册失败！请重新注册！");
                return "register";
            }

        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("您输入的注册信息不符合规范，请重新输入信息再试一次吧！");
        }

    }

    @RequestMapping("/logout")
    public String logout(Student student,Model model) throws SysException{
        try{
            int flag = studentService.logout(student.getStudent_id());
            if (flag == 1){
                model.addAttribute("msg","注销成功！");
                return "login";
            }else {
                model.addAttribute("msg","注销失败！");
                return "main";
            }
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("注销出现错误了，请重新检查信息再试一次吧！");
        }
    }

    @RequestMapping("/toRegister")
    public String change(){
        return "register";
    }
}
