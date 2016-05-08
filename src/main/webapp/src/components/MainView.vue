<template>
  <div class="main-container">

    <sidebar :user="user" :show.sync="show" :count="count" :done-count="doneCount"></sidebar>
    <todolist :tasks="tasks | isDone"></todolist>
    <detail></detail>

  </div>
</template>

<script>
  import sidebar from './sidebar'
  import todolist from './todolist'
  import detail from './detail'
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
        tasks: state => state.tasks
      },
      actions: {
        getUserData,
        getTasksData
      }
    },

    data () {
      return {
        show: 'all',
        filters: filters
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
      detail
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
