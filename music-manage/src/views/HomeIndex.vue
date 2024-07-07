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
      <div class="box2" id="main">
       
      </div>
      <div class="box2">
        
      </div>
      <div class="box2">
        <histogram-index></histogram-index>
      </div>
      <div class="box2">
        <PieIndex></PieIndex>
      </div>
    </div>
  </div>
</template>

<script>


import HistogramIndex  from '@/components/HistogramIndex.vue';
import PieIndex from '@/components/PieIndex.vue';
export default {
  components:{
    HistogramIndex,
    PieIndex
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


<style scoped>
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
  height: 300px;
  border: 1px solid black; 

}
</style>