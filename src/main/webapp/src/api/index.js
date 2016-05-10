import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource)

export default {
  getData (url, cb) {
    Vue.http.get(url).then( (response) => {
      cb(response)
    })
  }
}
