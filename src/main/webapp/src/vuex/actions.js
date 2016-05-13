import api from '../api/index'
import config from '../api/config'
import store from './store'

export const toggleActive = makeAction('TOGGLE_ACTIVE')
export const updateActiveTask = makeAction('SET_ACTIVE_TASK')

function makeAction (type) {
  return ({ dispatch }, ...args) => dispatch(type, ...args)
}

export const getTasksData = ({dispatch}) => {
  api.getData(config.tasksUrl, (tasks) => {
    dispatch('RECIEVE_TASKS', tasks)
  })
}
export const getUserData = ({dispatch}) => {
  api.getData(config.userDataUrl, (user) => {
    dispatch('RECIEVE_USER', user)
  })
}
export const addTask = ({dispatch}) => {
  api.getData(config.addTaskUrl, (id) => {
    dispatch('ADD_TASK', id)
  })
}
export const editTaskTitle = ({dispatch}, value) => {
  api.sendData(config.saveTaskUrl, {
    task_name: value
  }, (response) => {
    var data = eval(response)
    if(data.success) {
      dispatch('EDIT_TASK_TITLE', value)
    } else {
      dispatch('SHOW_ERROR', data.msg)
    }
  }, () => {
    dispatch('SHOW_ERROR', '网络错误')
  })
}
export const editTaskContent = ({dispatch}, value) => {
  api.sendData(config.saveContentUrl, {
    task_content: value
  }, (response) => {
    var data = eval(response)
    if(data.success) {
      dispatch('EDIT_TASK_CONTENT', value)
    } else {
      dispatch('SHOW_ERROR', data.msg)
    }
  }, () => {
    dispatch('SHOW_ERROR', '网络错误')
  })
}
export const deleteTask = ({dispatch}) => {
  api.sendData(config.deleteTaskUrl, {
    task_id: store.state.activeTask.task_id
  }, (response) => {
    var data = eval(response)
    if(data.success) {
      dispatch('DELETE_TASK')
    } else {
      dispatch('SHOW_ERROR', data.msg)
    }
  }, () => {
    dispatch('SHOW_ERROR', '网络错误')
  })
}
export const toggleTask = ({dispatch}) => {
  api.sendData(config.toggleTaskUrl, {
    task_id: store.state.activeTask.task_id
  }, (response) => {
    var data = eval(response)
    if(data.success) {
      dispatch('TOGGLE_TASK')
    } else {
      dispatch('SHOW_ERROR', data.msg)
    }
  }, () => {
    dispatch('SHOW_ERROR', '网络错误')
  })
}
export const addTime = ({dispatch}, time) => {
  api.sendData(config.addTimeUrl, {
    task_id: store.state.activeTask.task_id,
    end_time: time
  }, (response) => {
    var data = eval(response)
    if(data.success) {
      dispatch('UPDATE_TIME', time)
    } else {
      dispatch('SHOW_ERROR', data.msg)
    }
  }, () => {
    dispatch('SHOW_ERROR', '网络错误')
  })
}
