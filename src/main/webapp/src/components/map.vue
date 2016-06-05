<template>
<div class="map" v-echarts="mapOption">

</div>
</template>

<script>
require('echarts/map/js/china');

import geoCoordMap from '../api/map'

var BJData = [
    [{name:'北京'}, {name:'上海',value:95}],
    [{name:'北京'}, {name:'广州',value:90}],
    [{name:'北京'}, {name:'大连',value:80}],
    [{name:'北京'}, {name:'南昌',value:60}],
    [{name:'北京'}, {name:'拉萨',value:50}],
    [{name:'北京'}, {name:'常州',value:10}]
];

var planePath = 'path://M1705.06,1318.313v-89.254l-319.9-221.799l0.073-208.063c0.521-84.662-26.629-121.796-63.961-121.491c-37.332-0.305-64.482,36.829-63.961,121.491l0.073,208.063l-319.9,221.799v89.254l330.343-157.288l12.238,241.308l-134.449,92.931l0.531,42.034l175.125-42.917l175.125,42.917l0.531-42.034l-134.449-92.931l12.238-241.308L1705.06,1318.313z';


export default {

  data () {
    return {
      mapOption: {},
      geoCoordMap: geoCoordMap,
      BJData: BJData,
      planePath: planePath,
      series: []
    }
  },


  methods: {
    convertData (data) {
      var res = [];
      for (var i = 0; i < data.length; i++) {
          var dataItem = data[i];
          var fromCoord = geoCoordMap[dataItem[0].name];
          var toCoord = geoCoordMap[dataItem[1].name];
          if (fromCoord && toCoord) {
              res.push([{
                  coord: fromCoord
              }, {
                  coord: toCoord
              }]);
          }
      }
      return res;
    }
  },

  created () {
    this.series.push({
      type: 'lines',
      zlevel: 1,
      effect: {
          show: true,
          period: 6,
          trailLength: 0.7,
          color: '#fff',
          symbolSize: 3
      },
      lineStyle: {
          normal: {
              color: '#a6c84c',
              width: 0,
              curveness: 0.2
          }
      },
      data: this.convertData(this.BJData)
    },
    {
        type: 'lines',
        zlevel: 2,
        effect: {
            show: true,
            period: 6,
            trailLength: 0,
            symbol: planePath,
            symbolSize: 15
        },
        lineStyle: {
            normal: {
                color: '#a6c84c',
                width: 1,
                opacity: 0.4,
                curveness: 0.2
            }
        },
        data: this.convertData(this.BJData)
    },
    {
        type: 'effectScatter',
        coordinateSystem: 'geo',
        zlevel: 2,
        rippleEffect: {
            brushType: 'stroke'
        },
        label: {
            normal: {
                show: true,
                position: 'right',
                formatter: '{b}'
            }
        },
        symbolSize: function (val) {
            return val[2] / 8;
        },
        itemStyle: {
            normal: {
                color: '#a6c84c'
            }
        },
        data: this.BJData.map(function (dataItem) {
            return {
                name: dataItem[1].name,
                value: geoCoordMap[dataItem[1].name].concat([dataItem[1].value])
            };
        })
    })
    this.mapOption = {
      backgroundColor: '#2c343c',
      tooltip : {
          trigger: 'item'
      },
      legend: {
          orient: 'vertical',
          top: 'bottom',
          left: 'right',
          data:['北京 Top10'],
          textStyle: {
              color: '#fff'
          },
          selectedMode: 'single'
      },
      geo: {
          map: 'china',
          label: {
              emphasis: {
                  show: false
              }
          },
          roam: true,
          itemStyle: {
              normal: {
                  areaColor: '#323c48',
                  borderColor: '#404a59'
              },
              emphasis: {
                  areaColor: '#2a333d'
              }
          }
      },
      series: this.series
    }
  }
}
</script>

<style lang="sass">
.map {
  width: 100%;
  height: 100%;
}
</style>
