package com.cjs.controller;

import com.cjs.controller.base.BaseController;
import com.cjs.model.Task;
import com.cjs.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiaowu on 2016/5/9.
 */
@Controller
@RequestMapping(value="/task")
public class TaskController extends BaseController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value="/addTask")
    @ResponseBody
    public void addTask(Task task){
        taskService.addTask(task);
    }

    @RequestMapping(value="/deleteTask")
    @ResponseBody
    public void deleteTask(Integer task_id){
        taskService.deleteTask(task_id);
    }

    @RequestMapping(value="/modifyTask")
    @ResponseBody
    public void modifyTask(Task task){
        taskService.modifyTask(task);
    }
}
