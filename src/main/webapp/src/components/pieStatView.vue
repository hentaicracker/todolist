<template>
  <div class="stat-pie-content">
    <ul class="stat-title">
      <li>行程管理</li>
      <li>工作安排</li>
      <li>生活事务</li>
    </ul>
    <div class="stat-content">
      <pie class="stat-pie" :tasks="plane"></pie>
      <pie class="stat-pie" :tasks="todos"></pie>
      <pie class="stat-pie" :tasks="purchase"></pie>
    </div>
  </div>
</template>

<script>
import pie from './pie'

export default {

  name: 'pieStatView',

  vuex: {
    getters: {
      tasks: state => state.tasks
    }
  },

  computed: {
    plane () {
      return this.tasks.filter((task) => task.task_type === 1)
    },
    todos () {
      return this.tasks.filter((task) => task.task_type === 2)
    },
    purchase () {
      return this.tasks.filter((task) => task.task_type === 3)
    }
  },

  components: {
    pie
  }
}
</script>

<style lang="sass">
.stat-pie-content {
  height: 100%;
  width: 100%;

  .stat-title {
    width: 100%;
    height: 100px;

    li {
      float: left;
      height: 100%;
      line-height: 180px;
      text-align: center;
      width: calc(100%/3);
    }
  }

  .stat-content{
    height: 100%;

    .stat-pie {
      width: calc(100%/3);
      float: left;
      padding-bottom: 200px;
    }
  }

}
</style>
