import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource)

const config = {
  loginUrl: 'data.json',
  userDataUrl: 'data.json'
}

export default {
  getData (cb) {
    vue.http.get(userDataUrl).then( (response) => {
      let data = JSON.parse(response)
      callback(data)
    })
  }
}

export default config
