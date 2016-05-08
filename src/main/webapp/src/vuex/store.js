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
      done: false
    }
    state.tasks.push(newTask)
    state.activeTask = newTask
  },

  TOGGLE_TASK (state) {
    state.activeTask.done = !state.activeTask.done
  },

  EDIT_TASK (state, text) {
    state.activeTask.task_content = text
  },

  DELETE_TASK (state) {
    state.tasks.$remove(state.activeTask)
  },

  SET_ACTIVE_TASK (state, task) {
    state.activeTask = task
  }

}

export default new Vuex.Store({
  state,
  mutations
})
