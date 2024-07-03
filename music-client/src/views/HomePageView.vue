<template>
  <div>
    <div>
      <el-carousel :interval="3000" type="card" height="450px" width="">
        <el-carousel-item v-for="item in imageList" :key="item.id">
            <img :src="item.url" alt="" class="image">
        </el-carousel-item>
      </el-carousel>
    </div>
    <h2>推荐歌手</h2>
    <div class="avatar-row">
      <div v-for="item in songList" :key="item.id">
        <el-avatar :size="309" :shape="'circle'">
          <img :src="item.url"/>
        </el-avatar>
        <div class="avatar-text">{{ item.name }}</div>
      </div>
    </div>
    <h2>推荐歌曲</h2>
    
  </div>
</template>

<script>
export default {
    data() {
        return {
            imageList:[
                {id:0, url:require("../assets/jg.jpg")},
                {id:1, url:require("../assets/guitar.jpg")},
                {id:2, url:require("../assets/spoon.jpg")},
                {id:3, url:require("../assets/background.jpg")}   
            ],
            songList:[
              {id: 0, url: require("@/assets/Jay.jpg"), name: "周杰伦"},
              {id: 1, url: require("@/assets/ljj.jpg"), name: "林俊杰"},
              {id: 2, url: require("@/assets/wlh.jpg"), name: "王力宏"},
              {id: 3, url: require("@/assets/tz.jpg"), name: "陶喆"},
              {id: 4, url: require("@/assets/dzq.jpg"), name: "邓紫棋"},
            ]
        }
    }
}
</script>

<style>
.avatar-text {
  padding-top: 10px;
  padding-left:150px;
  padding-bottom: 30px;
  font-size: 18px;
  color: #333;
}
.avatar-row {
  display: flex;
  flex-wrap: wrap; /* 如果头像过多，可以换行 */
  gap: 15px; /* 控制每个头像之间的间距 */
}
.image {
    object-fit: fill;
    width: 100%;
    height: 100%;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
}

.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
}
</style>