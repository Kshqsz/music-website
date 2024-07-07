<template>
  <div>
    <div class="data">
      <div class="box1">
        <i class="el-icon-user"></i>
        <div>
          <strong>200</strong>
          <br>
          用户总数
        </div>
      </div>
      <div class="box1">
        <i class="el-icon-mic"></i>
        <div>
          <strong>200</strong>
          <br>
          歌曲总数
        </div>
      </div>
      <div class="box1">
        <i class="el-icon-service"></i>
        <div>
          <strong>200</strong>
          <br>
          歌手总数
        </div>
      </div>
      <div class="box1">
        <i class="el-icon-monitor"></i>
        <div>
          <strong>200</strong>
          <br>
          视频总数
        </div>
      </div>
    </div>
    <div class="chart">
      <div class="box2"></div>
      <div class="box2"></div>
      <div class="box2"></div>
      <div class="box2"></div>
    </div>
  </div>
</template>


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
  height: 200px;
  border: 1px solid black; 

}
</style>