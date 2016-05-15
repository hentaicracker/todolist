package com.cjs.service.impl;

import com.cjs.dao.TaskDao;
import com.cjs.model.Task;
import com.cjs.service.TaskService;
import com.cjs.service.base.BaseServiceImpl;
import com.cjs.util.session.SessionUtil;
import com.cjs.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xiaowu on 2016/5/8.
 */
@Component
public class TaskServiceImpl extends BaseServiceImpl<Task> implements TaskService {
    @Autowired
    private TaskDao taskDao;

    @Override
    public void addTask(Task task) {
        taskDao.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        taskDao.deleteByProperty("id", id);
    }

    @Override
    public void modifyTask(Task task) {
        Integer id = task.getId();
        if (task.getTask_done() == 0) {
            task.setTask_done(1);
        } else {
            task.setTask_done(0);
        }
        taskDao.executeUpdate("update Task t set t.task_done = " + task.getTask_done() + " where id = ?", id);
    }

    @Override
    public int newTask() {
        Task task = new Task();
        task.setUser_id(SessionUtil.getCurrentUser().getId());
        task.setTask_done(0);
        taskDao.save(task);
        return task.getId();
    }

    @Override
    public void updateTask(Task task) {
        int id = task.getId();
        if (!StringUtil.isEmpty(task.getEnd_time())) {
            taskDao.executeUpdate("update Task t set t.end_time = '" + task.getEnd_time() + "' where t.id = ? ", id);
        }
        if (!StringUtil.isEmpty(task.getTask_name())) {
            taskDao.executeUpdate("update Task t set t.task_name = '" + task.getTask_name() + "' where t.id = ? ", id);
        }
        if (!StringUtil.isEmpty(task.getTask_content())) {
            taskDao.executeUpdate("update Task t set t.task_content = '" + task.getTask_content() + "' where t.id = ? ", id);
        }

    }
    @Override
    public List<Task> findUserOwnTask() {
        Integer user_id = SessionUtil.getCurrentUser().getId();
        List<Task> tasks = taskDao.findByProperty("user_id", user_id);
       return tasks;
    }
}
