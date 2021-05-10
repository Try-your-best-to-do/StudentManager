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
@RequestMapping("/event")  //springMVC注解的一级目录
public class EventController {

    @Autowired //Spring注入
    private EventService eventService;

    @RequestMapping("/findAllSchedule")     //springMVC注解的二级目录
    public String schedule(HttpServletRequest request, Model model) throws SysException{
        try{
            List<Event> events = eventService.findByType(Type.SCHEDULE,request.getParameter("student_id"));
            model.addAttribute("schedules",events);
            return "main";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }
    @RequestMapping("/findByScheduleName")     //springMVC注解的二级目录
    public String scheduleName(Event event, Model model) throws SysException{
        try{
            List<Event> events = eventService.findByName(event.getEvent(),event.getType(),event.getStudent_id());
            model.addAttribute("schedules",events);
            return "main";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }

    @RequestMapping("/addSchedule")     //springMVC注解的二级目录
    public String scheduleAdd(Event event, Model model) throws SysException{
        try{
            if(event.getEvent()!=null&&event.getEvent()!="") {
                int flag = eventService.saveEvent(event);
            }
            List<Event> events = eventService.findByType(Type.SCHEDULE,event.getStudent_id());
            model.addAttribute("schedules",events);
            return "main";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }

    @RequestMapping("/deleteSchedule")     //springMVC注解的二级目录
    public String scheduleDelete(Event event, Model model) throws SysException{
        try{
            if(event.getEvent()!=null&&event.getEvent()!=""){
            int flag = eventService.deleteEvent(event.getEvent());
            }
            List<Event> events = eventService.findByType(Type.SCHEDULE,event.getStudent_id());
            model.addAttribute("schedules",events);
            return "main";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }

    @RequestMapping("/updateEvent")     //springMVC注解的二级目录
    public String updateEvent( Model model,HttpServletResponse response,HttpServletRequest request) throws SysException{
        try{
            String event = request.getParameter("event");
            String id = eventService.getId(event);
            model.addAttribute("id",id);
            return "updateSchedule";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }

    @RequestMapping("/updateEvent1")     //springMVC注解的二级目录
    public String scheduleAdd1(Event event, Model model) throws SysException{
        try{
            if(event.getEvent()!=null&&event.getEvent()!=""){
                int flag = eventService.update(event);
            }
            List<Event> events = eventService.findByType(Type.SCHEDULE,event.getStudent_id());
            model.addAttribute("schedules",events);
            return "main";
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("系统出错啦！请重新登录系统！");
        }
    }


}
