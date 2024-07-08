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
       <HistogramIndex_2 :data="singersonglist"></HistogramIndex_2>
      </div>
      <div class="box2">
        <PieIndex_2 :data="singersexlist"></PieIndex_2>
      </div>
      <div class="box2">
        <histogram-index :data="collectonsongslist"></histogram-index>
      </div>
      <div class="box2">
        <PieIndex :data="usersexlist"></PieIndex>
      </div>
    </div>
  </div>
</template>

<script>


import HistogramIndex  from '@/components/HistogramIndex.vue';
import HistogramIndex_2 from '@/components/HistogramIndex_2.vue';
import PieIndex from '@/components/PieIndex.vue';
import PieIndex_2 from '@/components/PieIndex_2.vue';
export default {
  components:{
    HistogramIndex,
    HistogramIndex_2,
    PieIndex,
    PieIndex_2
  },
  
  data() {
    return {
      usernumber: '1',
      songnumber: '1',
      singernumber: '1',
      mvnumber: '1',
      usersexlist:{'man':20,'female':10},
      singersexlist:{'man':30,'female':10},
      singersonglist:{'周杰伦':20,'林俊杰':10,'蔡依林':15,'陶喆':5},
      collectonsongslist:{'晴天':100,'七里香':80,'青花瓷':50,'以父之名':30,'倒带':25,'曹操':10}

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