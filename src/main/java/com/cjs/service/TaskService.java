package com.cjs.service;

import com.cjs.model.Task;

import java.util.List;

/**
 * Created by xiaowu on 2016/5/8.
 */
public interface TaskService {
    void addTask(Task task);


    void deleteTask(Integer id);

    /**
     * 修改任务的状态 0未完成 1完成
     * @param id
     */
    void modifyTask(Integer id);

    /**
     * 创建新任务
     * @return
     */
    int newTask();

    /**
     * 更新任务对象
     * @param task
     */
    void updateTask(Task task);

    /**
     * 查找当前用户的所有任务
     * @return
     */
    List<Task> findUserOwnTask();


}
