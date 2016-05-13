package com.cjs.service.impl;

import com.cjs.dao.TaskDao;
import com.cjs.model.Task;
import com.cjs.service.TaskService;
import com.cjs.service.base.BaseServiceImpl;
import com.cjs.util.session.SessionUtil;
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
    public void deleteTask(Integer task_id) {
        taskDao.deleteByProperty("task_id", task_id);
    }

    @Override
    public void modifyTask(Task task) {
        taskDao.update(task);
    }

    @Override
    public List<Task> findUserOwnTask() {
        Integer user_id = SessionUtil.getCurrentUser().getId();
        List<Task> tasks = taskDao.findByProperty("user_id", user_id);
       return tasks;
    }
}
