<template>
  <div class="main-container">

    <sidebar :user="user" :show.sync="show" :count="count" :done-count="doneCount"></sidebar>
    <todolist :tasks="tasks | isDone"></todolist>
    <detail></detail>
    <tip v-show="showTip" :show.sync="showTip" transition="appear">
      <span slot="body">{{errorText}}</span>
    </tip>

  </div>
</template>

<script>
  import sidebar from './sidebar'
  import todolist from './todolist'
  import detail from './detail'
  import tip from './tip'
  import { getUserData, getTasksData } from '../vuex/actions'

  const filters = {
    all: tasks => tasks,
    done: tasks => tasks.filter( (task) => !task.task_done ),
    undo: tasks => tasks.filter( (task) => task.task_done )
  }

  export default {

    name: 'MainView',

    vuex: {
      getters: {
        user: state => state.user,
        tasks: state => state.tasks,
        errorText: state => state.errorText,
        showError: state => state.showError
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
      isDone () {
        return this.filters[this.show](this.tasks)
      }
    },

    components: {
      sidebar,
      todolist,
      detail,
      tip
    },

    created () {
      this.getUserData()
      this.getTasksData()
    },

    computed: {
      doneCount () {
        return this.filters['undo'](this.tasks).length
      },
      count () {
        return this.tasks.length
      }
    }

  }
</script>
