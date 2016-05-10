package com.cjs.service.impl;

import com.cjs.dao.TaskDao;
import com.cjs.model.Task;
import com.cjs.service.TaskService;
import com.cjs.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
