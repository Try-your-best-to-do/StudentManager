package com.ssm.dao;

import com.ssm.domain.Event;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 事件Dao接口
*
* */

@Repository //spring持久层注解
public interface EventDao {
    //查询所有
    @Select("select * from event")
    public List<Event> findAll();

    //保存事件
    @Insert("insert into event (student_id,announcer,date,event,done,out_in,amount,type) values (#{student_id},#{announcer},#{date},#{event},#{done},#{out_in},#{amount},#{type})")
    public  int  saveEvent(Event event);

    //删除事件
    @Delete("delete from event where id = #{id}")
    public int Delete(Integer id);

    //删除唯一的事件，可行版
    @Delete("delete from event where  event = #{event}")
    public int deleteEvent(String event);

    @Update("update event set event = #{event}, announcer=#{announcer}, date=#{date}, done=#{done}, out_in=#{out_in}, amount=#{amount} where id=#{id} ")
    public int update(Event event);

    //根据id查询
    @Select("select * from event where student_id = #{student_id}")
    public List<Event> findByStudentId(String student_id);

    //根据id查询
    @Select("select * from event where id = #{id}")
    public Event findById(Integer id);

    //根据事件类型查询
    @Select("select * from event where type = #{type} and student_id=#{student_id}")
    public List<Event> findByType(@Param("type") Integer type, @Param("student_id") String student_id);

    //模糊查询
    @Select("select * from event where event like #{event} and type = #{type} and student_id=#{student_id}")
    List<Event> findByName(@Param("event") String event,@Param("type") Integer type,@Param("student_id") String student_id);

    //根据发布者查询
    @Select("select * from event where announcer = #{announcer} and type = #{type} and student_id = #{student_id}")
    public List<Event> findByAnnouncer(@Param("announcer") String announcer,@Param("type") Integer type,@Param("student_id") String student_id);

    //根据完成情况查询
    @Select("select * from event where done = #{done} and type = #{type} and student_id = #{student_id}")
    public List<Event> findByDone(@Param("done") Integer done,@Param("type") Integer type,@Param("student_id") String student_id);

    //根据是收入还是指出查询
    @Select("select * from event where out_in = #{out_in} and type = #{type},student_id = #{student_id}")
    public List<Event> findByOut_in(@Param("out_in") Integer out_in,@Param("type") Integer type,@Param("student_id") String student_id);

    //根据event获取id
    @Select("select id from event where event = #{event}")
    public  String getId(String event);
}
