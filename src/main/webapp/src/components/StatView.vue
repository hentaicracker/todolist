<template>
  <div class="stat-container">
    <div class="header">
      <ul>
        <li>
          <a :class="{active: done}" @click="doneChart">
            <span>完成情况统计</span>
          </a>
        </li>
        <li>
          <a :class="{active: map}" @click="mapChart">
            <span>地图可视化统计</span>
          </a>
        </li>
      </ul>
    </div>

    <div class="stat-pie-content" v-show="done">
      <ul class="stat-title">
        <li>商务旅行</li>
        <li>日常事务</li>
        <li>预购清单</li>
      </ul>
      <div class="stat-content">
        <pie class="stat-pie" :tasks="plane"></pie>
        <pie class="stat-pie" :tasks="todos"></pie>
        <pie class="stat-pie" :tasks="purchase"></pie>
      </div>
    </div>

    <div class="stat-map-content" v-show="map">
      <map ></map>
    </div>
  </div>
  <a class="stat-close" title="关闭" v-link="'user'">+</a>
</template>

<script>
import pie from './pie'
import map from './map'

export default {

  name: 'StatView',

  data () {
    return {
      map: false,
      done: true
    }
  },

  vuex: {
    getters: {
      tasks: state => state.tasks
    }
  },

  computed: {
    plane () {
      return this.tasks.filter((task) => task.task_type === 1)
    },
    todos () {
      return this.tasks.filter((task) => task.task_type === 2)
    },
    purchase () {
      return this.tasks.filter((task) => task.task_type === 3)
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
    pie, map
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

  .stat-pie-content {
    height: 100%;
    width: 100%;

    .stat-title {
      width: 100%;
      height: 100px;

      li {
        float: left;
        height: 100%;
        line-height: 180px;
        text-align: center;
        width: calc(100%/3);
      }
    }

    .stat-content{
      height: 100%;

      .stat-pie {
        width: calc(100%/3);
        float: left;
        padding-bottom: 200px;
      }
    }

  }

  .stat-map-content {
    height: 100%;
    width: 100%;
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
