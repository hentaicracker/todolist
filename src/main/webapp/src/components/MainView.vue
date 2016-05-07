<template>
  <div class="main-container">

    <sidebar :user="user" :show.sync="show"></sidebar>
    <todolist :tasks="tasks | isDone"></todolist>
    <detail></detail>

  </div>
</template>

<script>
  import sidebar from './sidebar'
  import todolist from './todolist'
  import detail from './detail'
  import state from '../vuex/store'

  export default {

    name: 'MainView',

    data () {
      let userData = state.user
      return {
        user: userData,
        tasks: userData.taskLists,
        show: 'all'
      }
    },

    filters: {
      isDone (list) {
        if (this.show === 'done') {
          return list.filter( (task) => {
            task.task_done === true
          })
        } else if (this.show === 'undo') {
          return list.filter( (task) => {
            task.task_done === false
          })
        } else {
          return
        }
      }
    },

    components: {
      sidebar,
      todolist,
      detail
    }

  }
</script>
