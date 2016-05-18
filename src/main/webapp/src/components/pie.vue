<template>
  <div class="pie" v-echarts="pieChartOption">

  </div>
</template>

<script>
export default {

  props: ['tasks'],

  data () {
    return {
      doneCount: this.tasks.filter( (task) => task.task_done ).length
    }
  },

  computed: {
    undoCount () {
      let count = this.tasks.length
      return count - this.doneCount
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
.pie {
  width: 100%;
  height: 100%;
}
</style>
