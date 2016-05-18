package com.cjs.controller;

import com.cjs.controller.base.BaseController;
import com.cjs.model.Task;
import com.cjs.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.Map;

/**
 * Created by xiaowu on 2016/5/9.
 */
@Controller
@RequestMapping(value="/task")
public class TaskController extends BaseController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/addTask")
    @ResponseBody
    public String addTask(Integer task_type){
        int taskid = taskService.addTask(task_type);
        String id = String.valueOf(taskid);
        return id;
    }

    @RequestMapping(value="/deleteTask")
    @ResponseBody
    public Map<String,Object> deleteTask(@RequestBody Task task){
        taskService.deleteTask(task.getId());
        return generateSuccessMsg("删除任务成功！");
    }

    @RequestMapping(value="/modifyTask")
    @ResponseBody
    public Map<String,Object> modifyTask(@RequestBody Task task){
        taskService.modifyTask( task.getId());
        return generateSuccessMsg("修改任务成功！");
    }

    @RequestMapping(value="/updateTask",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateTask(@RequestBody Task task){
        taskService.updateTask(task);
        return generateSuccessMsg("修改保存成功");
    }


    @RequestMapping(value="/findUserOwnTask")
    @ResponseBody
    public List<Task> findUserOwnTask() {
        return taskService.findUserOwnTask();
    }
}
