<template>
  <div class="login-container">
    <div id="register" class="height">
      <div class="login-header">
        <h1>个人任务管理系统</h1>
        <h2>注册</h2>
      </div>
      <div class="login-main">
        <div class="input-row">
          <label for="input-username" class="input-label">用户名</label>
          <input class="login-input" v-model="user.username">
        </div>
        <div class="input-row">
          <label for="input-username" class="input-label">昵称</label>
          <input class="login-input" v-model="user.nick_name">
        </div>
        <div class="input-row">
          <label for="input-username" class="input-label">密码</label>
          <input class="login-input" v-model="user.password" type="password">
        </div>
        <div class="input-row">
          <label for="input-username" class="input-label">确认密码</label>
          <input class="login-input" v-model="user.checkPassword" type="password" @keyup.enter="register">
        </div>
      </div>
      <div class="login-footer">
        <button class="login-btn" @click="register">注册</button>
        <button class="login-btn" v-link="'login'">直接登录</button>
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
        password: '',
        nick_name: '',
        checkPassword: ''
      },
      showTip: false,
      errorTxt: ''
    }
  },

  computed: {
    validation () {
      return {
        name: !!this.user.username.trim(),
        password: !!this.user.password.trim(),
        nickname: !!this.user.nick_name.trim(),
        checkPassword: !!this.user.checkPassword.trim()
      }
    },
    isValid () {
      let validation = this.validation
      return Object.keys(validation).every((key) => {
        return validation[key]
      })
    },
    checkPwd () {
      return this.user.password.trim() === this.user.checkPassword.trim()
    }
  },

  methods: {
    register () {
      let self = this
      if (!this.checkPwd) {
        this.showTip = true
        this.errorTxt = '两次密码输入不一致'
      } else if (this.isValid) {
        this.$http.post(config.registerUrl, {
          user_name: this.user.username,
          user_psd: this.user.password,
          nick_name: this.user.nick_name
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
        this.errorTxt = '请补全信息！'
      }
    }
  },

  components: {
    tip
  }
}
</script>
