package com.cjs.controller;

import com.cjs.controller.base.BaseController;
import com.cjs.model.Task;
import com.cjs.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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

    @RequestMapping(value="/addTask")
    @ResponseBody
    public Map<String,Object> addTask(Task task){
        taskService.addTask(task);
        return generateSuccessMsg("添加任务成功！");
    }

    @RequestMapping(value="/deleteTask")
    @ResponseBody
    public Map<String,Object> deleteTask(Integer task_id){
        taskService.deleteTask(task_id);
        return generateSuccessMsg("删除任务成功！");
    }

    @RequestMapping(value="/modifyTask")
    @ResponseBody
    public Map<String,Object> modifyTask(Task task){
        taskService.modifyTask(task);
        return generateSuccessMsg("修改任务成功！");
    }


    @RequestMapping("/newTask")
    @ResponseBody
    public String  newTask(){
        int taskid = taskService.newTask();
        String id = String.valueOf(taskid);
        return id;
    }

    @RequestMapping("/updateTask")
    @ResponseBody
    public Map<String, Object> updateTask(Task task){
        taskService.updateTask(task);
        return generateSuccessMsg("修改保存成功");
    }

    @RequestMapping(value="/findUserOwnTask")
    @ResponseBody
    public List<Task> findUserOwnTask() {
        return taskService.findUserOwnTask();
    }


}
