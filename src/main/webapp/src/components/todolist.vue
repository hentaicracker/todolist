<template>
  <div id="list-view">
    <div class="search">
      <i class="fa fa-search search-icon" aria-hidden="true"></i>
      <input type="text" v-model="searchText">
    </div>
    <div class="todo-list">
      <ul>
        <li v-for="task in tasks | search" :class="{active: task.task_id === activeTask.task_id}">
          <div class="t-inner">
            <input class="toggle" type="checkbox" :checked="task.task_done" @change="toggleTask(task)">
            <a class="t-content" @click="updateActiveTask(task)">{{task.task_name}}</a>
            <span class="time">3月13日</span>
          </div>
          <div class="t-line bottom"></div>
        </li>
      </ul>
    </div>
    <div>
      <button class="add-task" title="添加任务" @click="addTask">
        <i class="fa fa-plus" aria-hidden="true"></i>
      </button>
    </div>
  </div>
</template>

<script>
  import { updateActiveTask, toggleTask, addTask } from '../vuex/actions'

  export default {

    props: ['tasks'],

    data () {
      return {
        searchText: ''
      }
    },

    filters: {
      search (tasks) {
        return tasks.filter( (task) => task.task_name.indexOf(this.searchText) > -1)
      }
    },

    vuex: {
      getters: {
        activeTask: state => state.activeTask
      },
      actions: {
        updateActiveTask,
        toggleTask,
        addTask
      }
    }

  }
</script>
