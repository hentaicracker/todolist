import Vue from 'vue'
import Vuex from 'vuex'
import api from '../api'

Vue.use(Vuex)

const state = {
  tasks: [],
  user: {},
  activeTask: {}
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
      task_name: '',
      task_content: '',
      task_done: false
    }
    state.tasks.push(newTask)
    state.activeTask = newTask
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

  DELETE_TASK (state, task) {
    state.tasks.$remove(task)
  },

  SET_ACTIVE_TASK (state, task) {
    state.activeTask = task
  }

}

export default new Vuex.Store({
  state,
  mutations
})
