import api from '../api/index'
import util from '../api/util'
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
  api.getData(config.userDataUrl, (data) => {
    var user = util.checkoutData(data)
    dispatch('RECIEVE_USER', user)
  })
}
export const addTask = ({dispatch}) => {
  api.getData(config.addTaskUrl, (id) => {
    var id = util.checkoutData(id)
    dispatch('ADD_TASK', id.data)
  })
}
export const editTaskTitle = ({dispatch}, value) => {
  api.sendData(config.saveTaskUrl, {
    id: store.state.activeTask.id,
    task_name: value
  }, (response) => {
    var data = util.checkoutData(response)
    if(data.data.success) {
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
    id: store.state.activeTask.id,
    task_content: value
  }, (response) => {
    var data = util.checkoutData(response)
    if(data.data.success) {
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
    id: store.state.activeTask.id
  }, (response) => {
    var data = util.checkoutData(response)
    if(data.data.success) {
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
    id: store.state.activeTask.id
  }, (response) => {
    var data = util.checkoutData(response)
    if(data.data.success) {
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
    id: store.state.activeTask.id,
    end_time: time
  }, (response) => {
    var data = util.checkoutData(response)
    if(data.data.success) {
      dispatch('UPDATE_TIME', time)
    } else {
      dispatch('SHOW_ERROR', data.msg)
    }
  }, () => {
    dispatch('SHOW_ERROR', '网络错误')
  })
}
