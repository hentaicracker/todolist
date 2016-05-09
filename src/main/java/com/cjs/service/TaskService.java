package com.cjs.service;

import com.cjs.model.Task;

/**
 * Created by xiaowu on 2016/5/8.
 */
public interface TaskService {
    void addTask(Task task);

    void deleteTask(Integer task_id);

    void modifyTask(Task task);

}
