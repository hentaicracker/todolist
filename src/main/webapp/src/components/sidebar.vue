<template>
  <div id="sidebar-view">
    <div class="user">
      <img :src="user.avatar">
      <span>{{user.nick_name}}</span>
    </div>
    <div class="project-list">
      <ul>
        <li :class="{active: show === 'all'}" >
          <a @click="filterTask('all')">
            <i class="fa fa-tasks list-icon" aria-hidden="true"></i>
            <span>所有任务</span>
          </a>
        </li>
        <li class="not-all" :class="{active: show === 'done'}">
          <a @click="filterTask('done')">
            <i class="fa fa-square-o list-icon" aria-hidden="true"></i>
            <span>未完成</span>
            <span>{{count - doneCount}}</span>
          </a>
        </li>
        <li class="not-all" :class="{active: show === 'undo'}">
          <a @click="filterTask('undo')">
            <i class="fa fa-check-square-o list-icon" aria-hidden="true"></i>
            <span>已完成</span>
            <span>{{doneCount}}</span>
          </a>
        </li>
      </ul>
    </div>
    <div class="sign-out">
      <i class="fa fa-sign-out sign-out-icon" aria-hidden="true"></i>
      <a>退出</a>
    </div>
  </div>
</template>

<script>
export default {

  props: ['user', 'show', 'count', 'doneCount'],

  methods: {
    filterTask (str) {
      this.show = str
    }
  }
}
</script>
