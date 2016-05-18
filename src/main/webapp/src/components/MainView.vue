<template>
  <div class="main-container">

    <sidebar :user="user" :show.sync="show"></sidebar>
    <todolist :tasks="tasks | taskType" :show.sync="showMask"></todolist>
    <detail v-show="!isEmptyObject(activeTask)"></detail>
    <tip v-show="showTip" :show.sync="showTip" transition="appear">
      <span slot="body">{{errorText}}</span>
    </tip>
    <mask v-show="showMask"></mask>

  </div>
</template>

<script>
  import sidebar from './sidebar'
  import todolist from './todolist'
  import detail from './detail'
  import tip from './tip'
  import mask from './mask'
  import { getUserData, getTasksData } from '../vuex/actions'

  const filters = {
    all: tasks => tasks,
    plane: tasks => tasks.filter( (task) => task.task_type === 1 ),
    todos: tasks => tasks.filter( (task) => task.task_done === 2),
    purchase: tasks => tasks.filter( (task) => task.task_done === 3)
  }

  export default {

    name: 'MainView',

    vuex: {
      getters: {
        user: state => state.user,
        tasks: state => state.tasks,
        errorText: state => state.errorText,
        showError: state => state.showError,
        activeTask: state => state.activeTask,
        showMask: state => state.showMask
      },
      actions: {
        getUserData,
        getTasksData
      }
    },

    data () {
      return {
        show: 'all',
        filters: filters,
        showTip: this.showError
      }
    },

    filters: {
      taskType () {
        return this.filters[this.show](this.tasks)
      }
    },

    components: {
      sidebar,
      todolist,
      detail,
      tip,
      mask
    },

    created () {
      this.getUserData()
      this.getTasksData()
    },

    methods: {
      isEmptyObject (obj) {
        for (let key in obj) {
          return false
        }
        return true
      }
    }

  }
</script>
