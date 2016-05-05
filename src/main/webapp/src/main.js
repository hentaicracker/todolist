require('font-awesome/scss/font-awesome.scss')
require('./scss/style.scss')
require('./scss/main.scss')

import Vue from 'vue'
import Router from 'Vue-router'
import App from 'components/App'
import LoginView from 'components/LoginView'
import MainView from 'components/MainView'
import VueResource from 'vue-resource'

Vue.use(VueResource)
Vue.use(Router)

var router = new Router()

router.map({
  '/login': {
    component: LoginView
  },
  '/user': {
    component: MainView
  }
})

router.beforeEach(function(){
    window.scrollTo(0,0)
})

router.alias({
  '/' : '/login'
})

router.start(App, '#app')
