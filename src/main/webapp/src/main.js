require('font-awesome/scss/font-awesome.scss')
require('./scss/style.scss')
require('./scss/main.scss')

import Vue from 'vue'
import Router from 'Vue-router'
import App from 'components/App'
import LoginView from 'components/LoginView'
import MainView from 'components/MainView'
import StatView from 'components/StatView'
import VueResource from 'vue-resource'
import vueEcharts from './directives/echarts'
import pikaday from './directives/pikaday'

Vue.directive('echarts', vueEcharts)
Vue.directive('pikaday', pikaday)

Vue.use(VueResource)
Vue.use(Router)

var router = new Router()

router.map({
  '/login': {
    component (resolve) {
      require(['./components/LoginView'], resolve)
    }
  },
  '/user': {
    component (resolve) {
      require(['./components/MainView'], resolve)
    }
  },
  '/stat': {
    component (resolve) {
      require(['./components/StatView'], resolve)
    }
  }
})

router.beforeEach(function(){
    window.scrollTo(0,0)
})

router.alias({
  '/' : '/login'
})

router.start(App, '#app')
