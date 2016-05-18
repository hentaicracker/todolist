<template>
  <div class="stat-container">
    <div class="header">

    </div>
  </div>
  <a class="stat-close" title="关闭" v-link="'user'">+</a>
</template>

<script>
export default {

  name: 'StatView',

  data () {
    return {
      doneCount: this.tasks.filter( (task) => !task.task_done ).length
    }
  },

  computed: {
    undoCount () {
      let count = this.tasks.length
      return count - this.doneCount
    }
  },

  vuex: {
    getters: {
      tasks: state => state.tasks
    }
  },

  created () {
    var vm = this
    vm.pieChartOption = {
      backgroundColor: '#2c343c',
      visualMap: {
          show: false,
          min: 80,
          max: 600,
          inRange: {
              colorLightness: [0, 1]
          }
      },
      tooltip: {},
      series: [
          {
              name: '任务统计',
              type: 'pie',
              radius: '55%',
              data:[
                  {value: vm.doneCount * 100, name:'已完成'},
                  {value: vm.undoCount * 100, name:'未完成'}
              ],
              roseType: 'angle',
              label: {
                  normal: {
                      textStyle: {
                          color: 'rgba(255, 255, 255, 0.3)'
                      }
                  }
              },
              labelLine: {
                  normal: {
                      lineStyle: {
                          color: 'rgba(255, 255, 255, 0.3)'
                      }
                  }
              },
              itemStyle: {
                  normal: {
                      color: '#2c5cec',
                      shadowBlur: 200,
                      shadowColor: 'rgba(0, 0, 0, 0.5)'
                  }
              }
          }
      ]
    }
  }

}
</script>

<style lang="sass">
.stat-container {
  height: 100%;
  width: 100%;
  background-color: #2c343c;
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
