<template>
  <div class="login-container">
    <div id="login">
      <div class="login-header">
        <h1>个人任务管理系统</h1>
        <h2>登录</h2>
      </div>
      <div class="login-main">
        <div class="input-row">
          <label for="input-username" class="input-label">用户名</label>
          <input class="login-input" id="input-username" type="text" >
        </div>
        <div class="input-row">
          <label for="input-username" class="input-label">密码</label>
          <input class="login-input" id="input-username" type="password" >
        </div>
      </div>
      <div class="login-footer">
        <button class="login-btn">登录</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LoginView'
}
</script>
