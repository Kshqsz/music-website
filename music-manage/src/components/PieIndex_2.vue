<template>
  <div id="pie2"></div>
</template>

<script>
import * as echarts from 'echarts';

export default {
  props:['data'],
  mounted(){
    var myChart = echarts.init(document.getElementById('pie2'));
    myChart.setOption({
      title: {
      text: '歌手性别比',
      x : 'center'
    },
      series: [
    {
      type: 'pie',
      data: [
        {
          value: this.data.man,
          name: '男'
        },
        {
          value: this.data.female,
          name: '女'
        }
      ],
      radius: '50%'
    }
  ]
    })
  }
}
</script>

<style scoped>
#pie2{
  width: 600px;
  height: 300px;
}
</style>
