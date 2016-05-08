<template>
  <div class="login-container">
    <div id="login">
      <div class="login-header">
        <h1>个人任务管理系统</h1>
        <h2>登录</h2>
      </div>
      <div class="login-main" :class="{redBorder: !validation.password || !validation.name}">
        <div class="input-row">
          <label for="input-username" class="input-label">用户名</label>
          <input class="login-input" v-model="user.username">
        </div>
        <div class="input-row" >
          <label for="input-username" class="input-label">密码</label>
          <input class="login-input" v-model="user.password" type="password">
        </div>
      </div>
      <ul class="errors">
        <li v-show="">用户名为空</li>
        <li v-show="">密码为空</li>
      </ul>
      <div class="login-footer">
        <button class="login-btn" @click="login">登录</button>
      </div>
    </div>
  </div>
</template>

<script>
import config from '../api/config'

export default {
  name: 'LoginView',

  data () {
    return {
      user: {
        username: '',
        password: ''
      }
    }
  },

  computed: {
    validation () {
      return {
        name: !!this.user.username.trim(),
        password: !!this.user.password.trim()
      }
    },
    isValid () {
      let validation = this.validation
      return Object.keys(validation).every((key) => {
        return validation[key]
      })
    }
  },

  methods: {
    login () {
      if (this.isValid) {
        this.$http.post(config.loginUrl, {
          username: this.user.username,
          password: this.user.password
        }).then( (response) => {
          let data = JSON.parse(response)
          if (data.success) {
            this.$route.router.go('/user')
          }
        }, (response) => {
          this.$route.router.go('/')
        })
      }
    }
  }
}
</script>
