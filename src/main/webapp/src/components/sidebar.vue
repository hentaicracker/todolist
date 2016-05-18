<template>
  <div id="sidebar-view">
    <div class="user">
      <img src="../../build/images/avatar.png">
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
        <li :class="{active: show === 1}">
          <a @click="filterTask(1)">
            <i class="fa fa-plane list-icon" aria-hidden="true"></i>
            <span>商务旅行</span>
          </a>
        </li>
        <li :class="{active: show === 2}">
          <a @click="filterTask(2)">
            <i class="fa fa-list-alt list-icon" aria-hidden="true"></i>
            <span>日常事务</span>
          </a>
        </li>
        <li :class="{active: show === 3}">
          <a @click="filterTask(3)">
            <i class="fa fa-list-ul list-icon" aria-hidden="true"></i>
            <span>预购清单</span>
          </a>
        </li>
        <li>
          <a v-link="'stat'">
            <i class="fa fa-area-chart list-icon" aria-hidden="true"></i>
            <span>统计</span>
          </a>
        </li>
      </ul>
    </div>
    <div class="sign-out">
      <i class="fa fa-sign-out sign-out-icon" aria-hidden="true"></i>
      <a v-link="'login'">退出</a>
    </div>
  </div>
</template>

<script>
export default {

  props: ['user', 'show', 'count', 'doneCount'],

  methods: {
    filterTask (num) {
      this.show = num
    }
  }

}
</script>
