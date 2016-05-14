package com.cjs.service;

import com.cjs.model.Task;

import java.util.List;

/**
 * Created by xiaowu on 2016/5/8.
 */
public interface TaskService {
    void addTask(Task task);

    void deleteTask(Integer task_id);

    void modifyTask(Integer id);


    int newTask();

    void updateTask(Task task);

    List<Task> findUserOwnTask();


}
