<template>
  <div>
    <div id="his"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts';


export default{
  props:['data'],
  
  mounted() {
    const keys = Object.keys(this.data);
    const values = Object.values(this.data);
   // const colors = ['red','blue','green','yellow','pink','black']
    var myChart = echarts.init(document.getElementById('his'));
    myChart.setOption({
    title: {
      text: '歌手歌曲数',
      x : 'center'
    },
    tooltip: {},
    xAxis: {
      data:keys
    },
    yAxis: {},
    series: [
      {
        name: '销量',
        type: 'bar',
        data: values,
        /* itemStyle: {
          color: params => colors[params.dataIndex] || 'brown'
        } */
      }
    ]
    });
 },
}
</script>

<style scoped>
#his{
  width: 600px;
  height: 300px;
}
</style>
