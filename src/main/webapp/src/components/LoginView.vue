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
          <input class="login-input" v-model="user.username">
        </div>
        <div class="input-row" >
          <label for="input-username" class="input-label">密码</label>
          <input class="login-input" v-model="user.password" type="password">
        </div>
      </div>
      <div class="login-footer">
        <button class="login-btn" @click="login">登录</button>
      </div>
    </div>
    <tip v-show="showTip" :show.sync="showTip" transition="appear">
      <span slot="body">{{errorTxt}}</span>
    </tip>
  </div>
</template>

<script>
import config from '../api/config'
import tip from './tip'

export default {
  name: 'LoginView',

  data () {
    return {
      user: {
        username: '',
        password: ''
      },
      showTip: false,
      errorTxt: ''
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
      let self = this
      if (this.isValid) {
        this.$http.post(config.loginUrl, {
          user_name: this.user.username,
          user_psd: this.user.password
        }).then( (response) => {
          var data = eval(response.data)
          if (data.success) {
            self.$route.router.go('/user')
          } else {
            self.showTip = true
            self.errorTxt = data.msg
          }
        }, () => {
          self.showTip = true
          self.errorTxt = '发生了未知的错误'
        })
      } else {
        this.showTip = true
        this.errorTxt = '用户名或密码为空！'
      }
    }
  },

  components: {
    tip
  }
}
</script>
