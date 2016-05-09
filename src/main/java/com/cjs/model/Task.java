package com.cjs.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * Created by xiaowu on 2016/5/8.
 */
@Entity
@Table(name="Task")
public class Task implements Serializable {
    private Integer id;
    private Integer user_id;
    private String task_name;
    private String task_content;
    private String start_time;
    private String end_time;
    private Integer task_priority;//优先级
    private String task_longitude;//经度
    private String task_latitude;//纬度
    private Integer task_done;//是否完成  1是  2否

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id",length=22,nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="user_id",length=22,nullable = false)
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Column(name="task_name",length=255)
    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    @Column(name="task_content",length=255)
    public String getTask_content() {
        return task_content;
    }

    public void setTask_content(String task_content) {
        this.task_content = task_content;
    }

    @Column(name="start_time",length=255)
    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    @Column(name="end_time",length=255)
    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    @Column(name="task_priority",length=22)
    public Integer getTask_priority() {
        return task_priority;
    }

    public void setTask_priority(Integer task_priority) {
        this.task_priority = task_priority;
    }

    @Column(name="task_longitude",length=255)
    public String getTask_longitude() {
        return task_longitude;
    }

    public void setTask_longitude(String task_longitude) {
        this.task_longitude = task_longitude;
    }

    @Column(name="task_latitude",length=255)
    public String getTask_latitude() {
        return task_latitude;
    }

    public void setTask_latitude(String task_latitude) {
        this.task_latitude = task_latitude;
    }

    @Column(name="task_done",length=22)
    public Integer getTask_done() {
        return task_done;
    }

    public void setTask_done(Integer task_done) {
        this.task_done = task_done;
    }
}
