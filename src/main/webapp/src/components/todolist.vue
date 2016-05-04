<template>
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
</template>
