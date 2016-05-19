<template>
  <div class="stat-container">
    <div class="header">
      <ul>
        <li>
          <a :class="{active: done}" v-link="{ path: '/stat/pie' }" @click="doneChart">
            <span>完成情况统计</span>
          </a>
        </li>
        <li>
          <a :class="{active: map}" v-link="{ path: '/stat' }" @click="mapChart">
            <span>行程预览</span>
          </a>
        </li>
      </ul>
    </div>

    <router-view></router-view>

    <div class="stat-map-content" v-show="map">
      <map class="stat-map"></map>
    </div>
  </div>
  <a class="stat-close" title="关闭" v-link="{path: '/user'}">+</a>
</template>

<script>
import map from './map'

export default {

  name: 'StatView',

  data () {
    return {
      map: true,
      done: false
    }
  },

  methods: {
    doneChart () {
      this.done = true
      this.map = false
    },
    mapChart () {
      this.done = false
      this.map = true
    },
  },

  components: {
    map
  }

}
</script>

<style lang="sass">
.stat-container {
  height: 100%;
  width: 100%;
  background-color: #2c343c;
  color: #fff;

  .header {
    height: 100px;
    text-align: center;

    ul {
      width: 300px;
      height: 100%;
      margin: 0 auto;

      li {
        float: left;
        width: 50%;
        height: 100%;
        padding-top: 60px;
        line-height: 40px;

        &:first-of-type a {
          border-right: 0;
          border-radius: 5px 0 0 5px;
        }
        &:last-of-type a {
          border-radius: 0 5px 5px 0;
        }

        a {
          cursor: pointer;
          height: 100%;
          width: 100%;
          display: block;
          border: 1px solid #fff;
          color: #fff;

          &.active{
            color: #436EEE;
            background-color: #fff;
          }
          &:hover {
            color: #436EEE;
            background-color: rgba(#fff, 0.8);
          }
        }
      }
    }
  }

  .stat-map-content {
    height: 100%;
    width: 100%;

    .stat-map {
      height: 100%;
      width: 100%;
    }
  }
}
.stat-close {
  position: absolute;
  top: 20px;
  right: 20px;
  font-size: 40px;
  color: #fff;
  transform: rotate(45deg);
  cursor: pointer;
  &:hover {
    color: #436EEE;
  }
}
</style>
