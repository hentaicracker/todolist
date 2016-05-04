<template>
  <div class="container">

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

    <div id="list-view">
      <div class="search">
        <i class="fa fa-search search-icon" aria-hidden="true"></i>
        <input type="text">
      </div>
      <div class="todo-list">
        <ul>
          <li class="active">
            <div class="t-inner">
              <a class="t-check" href="">
                <i class="fa fa-square-o list-icon" aria-hidden="true"></i>
              </a>
              <a class="t-content" href="">任务1</a>
              <span class="time">3月13日</span>
            </div>
            <div class="t-line bottom"></div>
          </li>
          <li>
            <div class="t-inner">
              <a class="t-check" href="">
                <i class="fa fa-square-o list-icon" aria-hidden="true"></i>
              </a>
              <a class="t-content" href="">任务2</a>
              <span class="time">3月13日</span>
            </div>
            <div class="t-line bottom"></div>
          </li>
        </ul>
      </div>
      <div class="add-task" title="添加任务">
        <i class="fa fa-plus" aria-hidden="true"></i>
      </div>
    </div>

    <div id="detail-view">
      <div class="detail-header">
        <span>任务1</span>
      </div>
      <div class="detail-content">
        <p>任务详情任务详情任务详情任务详情任务详情任务详情任务详情</p>
      </div>
      <div class="delete-btn">
        <i class="fa fa-pencil" aria-hidden="true" title="编辑"></i>
        <i class="fa fa-floppy-o" aria-hidden="true" title="保存"></i>
        <i class="fa fa-trash" aria-hidden="true" title="删除"></i>
      </div>
    </div>
  </div>
</template>
