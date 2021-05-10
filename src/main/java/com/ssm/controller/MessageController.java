package com.ssm.controller;

import com.ssm.domain.Event;
import com.ssm.exception.SysException;
import com.ssm.service.EventService;
import com.ssm.utils.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller  //springMVC注解
@RequestMapping("/message")  //springMVC注解的一级目录
public class MessageController {

    @Autowired //Spring注入
    private EventService eventService;

    @RequestMapping("/findAllMessage")     //springMVC注解的二级目录
    public String Message(HttpServletRequest request, Model model) throws SysException{
        try{
            List<Event> events = eventService.findByType(Type.MESSAGE,request.getParameter("student_id"));
            model.addAttribute("message",events);
            return "message";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }
    @RequestMapping("/findByMessageName")     //springMVC注解的二级目录
    public String MessageName(Event event, Model model) throws SysException{
        try{
            List<Event> events = eventService.findByName(event.getEvent(),event.getType(),event.getStudent_id());
            model.addAttribute("message",events);
            return "message";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }

    @RequestMapping("/addMessage")     //springMVC注解的二级目录
    public String MessageAdd(Event event, Model model) throws SysException{
        try{
            if(event.getEvent()!=null&&event.getEvent()!="") {
                int flag = eventService.saveEvent(event);
            }
            List<Event> events = eventService.findByType(Type.MESSAGE,event.getStudent_id());
            model.addAttribute("message",events);
            return "message";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }

    @RequestMapping("/deleteMessage")     //springMVC注解的二级目录
    public String messageDelete(Event event, Model model) throws SysException{
        try{
            if(event.getEvent()!=null&&event.getEvent()!=""){
                int flag = eventService.deleteEvent(event.getEvent());
            }
            List<Event> events = eventService.findByType(Type.MESSAGE,event.getStudent_id());
            model.addAttribute("message",events);
            return "message";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }

    @RequestMapping("/updateMessage")     //springMVC注解的二级目录
    public String updateMessage( Model model,HttpServletResponse response,HttpServletRequest request) throws SysException{
        try{
            String event = request.getParameter("event");
            String id = eventService.getId(event);
            model.addAttribute("id",id);
            return "updateMessage";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }

    @RequestMapping("/updateMessage1")     //springMVC注解的二级目录
    public String MessageAdd1(Event event, Model model) throws SysException{
        try{
            if(event.getEvent()!=null&&event.getEvent()!=""){
                int flag = eventService.update(event);
            }
            List<Event> events = eventService.findByType(Type.MESSAGE,event.getStudent_id());
            model.addAttribute("message",events);
            return "message";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }


}