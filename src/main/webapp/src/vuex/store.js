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
  errorText: '',
  showMask: false,
  province: ''
}

const mutations = {

  RECIEVE_TASKS (state, tasks) {
    state.tasks = tasks.data
  },

  RECIEVE_USER (state, user) {
    state.user = user.data
  },

  ADD_TASK (state, id, taskType) {
    const newTask = {
      id: id,
      task_name: '',
      task_content: '',
      task_done: false,
      task_type: taskType
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
  },

  UPDATE_PLACE (state, place) {
    state.activeTask.task_place = place
  },

  TOGGLE_MASK (state) {
    state.showMask = !state.showMask
  }

}

export default new Vuex.Store({
  state,
  mutations
})
