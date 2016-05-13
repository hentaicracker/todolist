import Vue from 'vue'
import Vuex from 'vuex'
import api from '../api'

Vue.use(Vuex)

const state = {
  tasks: [],
  user: {},
  activeTask: {},
  active: false,
  showError: false,
  errorText: ''
}

const mutations = {

  RECIEVE_TASKS (state, tasks) {
    state.tasks = tasks.data
  },

  RECIEVE_USER (state, user) {
    state.user = user.data
  },

  ADD_TASK (state, task) {
    const newTask = {
      task_id: task.task_id,
      task_name: '',
      task_content: '',
      task_done: false
    }
    state.tasks.push(newTask)
    state.activeTask = newTask
    state.active = true
  },

  TOGGLE_ACTIVE (state) {
    state.active = false
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
  },

  SHOW_ERROR (state, error) {
    state.showError = true
    state.errorText = error
  },

  UPDATE_TIME (state, time) {
    state.activeTask.end_time = time
  }

}

export default new Vuex.Store({
  state,
  mutations
})
