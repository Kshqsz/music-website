<template>
  <div>
    <div id="ma"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts';


export default{
  
  mounted() {
    const colors = ['red','blue','green','yellow','pink','black']
    var myChart = echarts.init(document.getElementById('ma'));
    myChart.setOption({
    title: {
      text: 'ECharts 入门示例'
    },
    tooltip: {},
    xAxis: {
      data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
    },
    yAxis: {},
    series: [
      {
        name: '销量',
        type: 'bar',
        data: [5, 20, 36, 10, 10, 20],
        itemStyle: {
          color: params => colors[params.dataIndex] || 'brown'
        }
      }
    ]
    });
 },
}
</script>

<style scoped>
#ma{
  width: 600px;
  height: 300px;
}
</style>
