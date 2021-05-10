package com.ssm.service.impl;

import com.ssm.dao.EventDao;
import com.ssm.domain.Event;
import com.ssm.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EventService") //spring页面层注释,相当于要给EventService注入
public class EventServiceImpl implements EventService {

    @Autowired //spring依赖注入
    private EventDao eventDao;

    @Override
    public int saveEvent(Event event) {
        int flag = eventDao.saveEvent(event);
        return flag;
    }

    @Override
    public int Delete(Integer id) {
        int flag = eventDao.Delete(id);
        return flag;
    }

    @Override
    public int deleteEvent( String event) {
        int flag = eventDao.deleteEvent(event);
        return flag;
    }

    @Override
    public int update(Event event) {
        int flag = eventDao.update(event);
        return flag;
    }

    @Override
    public List<Event> findByStudentId(String student_id) {
        List<Event> events = eventDao.findByStudentId(student_id);
        return events;
    }

    @Override
    public Event findById(Integer id) {
        Event event = eventDao.findById(id);
        return event;
    }

    @Override
    public List<Event> findByType(Integer type,String student_id) {
        List<Event> events = eventDao.findByType(type,student_id);
        return events;
    }

    @Override
    public List<Event> findByName(String event, Integer type,String student_id) {
        List<Event> events = eventDao.findByName("%"+event+"%",type,student_id);
        return events;
    }

    @Override
    public List<Event> findByAnnouncer(String announcer, Integer type,String student_id) {
        List<Event> events = eventDao.findByAnnouncer(announcer,type,student_id);
        return events;
    }

    @Override
    public List<Event> findByDone(Integer done, Integer type,String student_id) {
        List<Event> events = eventDao.findByDone(done,type,student_id);
        return events;
    }

    @Override
    public List<Event> findByOut_in(Integer out_in, Integer type,String student_id) {
        List<Event> events = eventDao.findByOut_in(out_in,type,student_id);
        return events;
    }

    @Override
    public String getId(String event) {
        String id = eventDao.getId(event);
        return  id;
    }
}
