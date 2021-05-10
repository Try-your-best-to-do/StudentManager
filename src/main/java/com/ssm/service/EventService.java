package com.ssm.service;

import com.ssm.domain.Event;



import java.util.List;

public interface EventService {

    //保存事件
    public  int  saveEvent(Event event);

    //删除事件
    public int Delete(Integer id);

    //删除唯一的事件，可行版
    public int deleteEvent(String event);

    public int update(Event event);

    //根据id查询
    public List<Event> findByStudentId(String student_id);

    //根据id查询
    public Event findById(Integer id);

    //根据事件类型查询
    public List<Event> findByType(Integer type,String student_id);

    //模糊查询
    List<Event> findByName(String event,Integer type,String student_id);

    //根据发布者查询
    public List<Event> findByAnnouncer(String announcer,Integer type,String student_id);

    //根据完成情况查询
    public List<Event> findByDone(Integer done,Integer type,String student_id);

    //根据是收入还是指出查询
    public List<Event> findByOut_in(Integer out_in,Integer type,String student_id);

    //根据event获取id
    public  String getId(String event);
}
