<template>
  <div>
    <div class="data">
      <div class="box1">
        <i class="el-icon-user"></i>
        <div>
          <strong>{{usernumber}}</strong>
          <br>
          用户总数
        </div>
      </div>
      <div class="box1">
        <i class="el-icon-mic"></i>
        <div>
          <strong>{{songnumber}}</strong>
          <br>
          歌曲总数
        </div>
      </div>
      <div class="box1">
        <i class="el-icon-service"></i>
        <div>
          <strong>{{singernumber}}</strong>
          <br>
          歌手总数
        </div>
      </div>
      <div class="box1">
        <i class="el-icon-monitor"></i>
        <div>
          <strong>{{mvnumber}}</strong>
          <br>
          视频总数
        </div>
      </div>
    </div>
    <div class="chart">
      <div class="box2" id="main"></div>
      <div class="box2"></div>
      <div class="box2"></div>
      <div class="box2"></div>
    </div>
  </div>
</template>

<script>
import * as echarts from 'echarts/core';
// 引入柱状图图表，图表后缀都为 Chart
import { BarChart } from 'echarts/charts';
// 引入标题，提示框，直角坐标系，数据集，内置数据转换器组件，组件后缀都为 Component
import {
  TitleComponent,
  TooltipComponent,
  GridComponent,
  DatasetComponent,
  TransformComponent
} from 'echarts/components';
// 标签自动布局、全局过渡动画等特性
import { LabelLayout, UniversalTransition } from 'echarts/features';
// 引入 Canvas 渲染器，注意引入 CanvasRenderer 或者 SVGRenderer 是必须的一步
import { CanvasRenderer } from 'echarts/renderers';


export default {
  created(){
      echarts.use([
        TitleComponent,
        TooltipComponent,
        GridComponent,
        DatasetComponent,
        TransformComponent,
        BarChart,
        LabelLayout,
        UniversalTransition,
        CanvasRenderer
      ]);
  },
  mounted() {
    var myChart = echarts.init(document.getElementById('main'));
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
      data: [5, 20, 36, 10, 10, 20]
    }
  ]
});
  },
  data() {
    return {
      usernumber: '1',
      songnumber: '1',
      singernumber: '1',
      mvnumber: '1'

    };
  }
}

</script>


<style >
.data{
  display: flex;
  justify-content: space-between;
  padding: 0 60px
}
i{
  font-size: 50px;
  margin-right: 50px;
}
.box1{
  display: flex;
  border: 1px solid black; 
  padding: 20px;
}
.chart{
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
  margin-top: 30px;
}
.box2{
  margin-bottom: 30px;
  width: 600px;
  height: 200px;
  border: 1px solid black; 

}
</style>