<template>
<div class="mapView" v-echarts="mapOption">

</div>
</template>

<script>
require('echarts/map/js/china')

export default {

  name: 'MapView',

  data () {
    return {
      mapOption: {}
    }
  },

  created () {
    this.mapOption = {
      backgroundColor: '#436EEE',
      tooltip : {
          trigger: 'item'
      },
      toolbox: {
          show : true,
          orient: 'vertical',
          x:'right',
          y:'center',
          feature : {
              mark : {show: true},
              dataView : {show: true, readOnly: false}
          }
      },
      series : [
          {
              tooltip: {
                  trigger: 'item',
                  formatter: '{b}'
              },
              name: '选择器',
              type: 'map',
              mapType: 'china',
              mapLocation: {
                  x: 'left',
                  y: 'top',
                  width: '30%'
              },
              roam: true,
              selectedMode : 'single',
              itemStyle:{
                normal: {
                    areaColor: '#fff',
                    borderColor: '#436EEE'
                },
                emphasis: {
                    areaColor: '#436EEE',
                    borderColor: '#fff',
                    label:{show:true}
                }
              },
              data:[
                  {name: '北京', selected:false},
                  {name: '天津', selected:false},
                  {name: '上海', selected:false},
                  {name: '重庆', selected:false},
                  {name: '河北', selected:false},
                  {name: '河南', selected:false},
                  {name: '云南', selected:false},
                  {name: '辽宁', selected:false},
                  {name: '黑龙江', selected:false},
                  {name: '湖南', selected:false},
                  {name: '安徽', selected:false},
                  {name: '山东', selected:false},
                  {name: '新疆', selected:false},
                  {name: '江苏', selected:false},
                  {name: '浙江', selected:false},
                  {name: '江西', selected:false},
                  {name: '湖北', selected:false},
                  {name: '广西', selected:false},
                  {name: '甘肃', selected:false},
                  {name: '山西', selected:false},
                  {name: '内蒙古', selected:false},
                  {name: '陕西', selected:false},
                  {name: '吉林', selected:false},
                  {name: '福建', selected:false},
                  {name: '贵州', selected:false},
                  {name: '广东', selected:false},
                  {name: '青海', selected:false},
                  {name: '西藏', selected:false},
                  {name: '四川', selected:false},
                  {name: '宁夏', selected:false},
                  {name: '海南', selected:false},
                  {name: '台湾', selected:false},
                  {name: '香港', selected:false},
                  {name: '澳门', selected:false}
              ]
          }
      ],
      animation: false
    }
  }

}


</script>

<style lang="sass">
.mapView {
  width: 100%;
  height: 100%;
}
</style>
