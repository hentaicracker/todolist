<template>
  <div id="sidebar-view">
    <div class="user">
      <img src="./build/images/avatar.png">
      <span>hentaicracker</span>
    </div>
    <div class="project-list">
      <ul>
        <li class="active">
          <a href="">
            <i class="fa fa-tasks list-icon" aria-hidden="true"></i>
            <span>所有任务</span>
          </a>
        </li>
        <li class="not-all">
          <a href="">
            <i class="fa fa-square-o list-icon" aria-hidden="true"></i>
            <span>未完成</span>
            <span>0</span>
          </a>
        </li>
        <li class="not-all">
          <a href="">
            <i class="fa fa-check-square-o list-icon" aria-hidden="true"></i>
            <span>已完成</span>
            <span>0</span>
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
