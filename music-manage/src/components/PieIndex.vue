<template>
  <div id="pie"></div>
</template>

<script>
import * as echarts from 'echarts';

export default {

  mounted(){
    var myChart = echarts.init(document.getElementById('pie'));
    myChart.setOption({
      series: [
    {
      type: 'pie',
      data: [
        {
          value: 335,
          name: '直接访问'
        },
        {
          value: 234,
          name: '联盟广告'
        },
        {
          value: 1548,
          name: '搜索引擎'
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
#pie{
  width: 600px;
  height: 300px;
}
</style>
