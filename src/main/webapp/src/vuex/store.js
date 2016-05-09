import Vue from 'vue'
import Vuex from 'vuex'
import api from '../api'

Vue.use(Vuex)

const state = {
  tasks: [],
  user: {},
  activeTask: {},
  active: false
}

const mutations = {

  RECIEVE_TASKS (state, tasks) {
    state.tasks = tasks.data
  },

  RECIEVE_USER (state, user) {
    state.user = user.data
  },

  ADD_TASK (state) {
    const newTask = {
      task_name: '新任务',
      task_content: '',
      task_done: false
    }
    state.tasks.push(newTask)
    state.activeTask = newTask
    state.active = true
  },

  TOGGLE_TASK (state, task) {
    task.task_done = !task.task_done
  },

  EDIT_TASK_TITLE (state, text) {
    state.activeTask.task_name = text
  },

  EDIT_TASK_CONTENT (state, text) {
    state.activeTask.task_content = text
  },

  DELETE_TASK (state) {
    state.tasks.$remove(state.activeTask)
    state.activeTask = state.tasks[0]
  },

  SET_ACTIVE_TASK (state, task) {
    state.activeTask = task
  }

}

export default new Vuex.Store({
  state,
  mutations
})
