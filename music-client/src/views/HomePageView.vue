<template>
  <div>
    <div>
      <el-carousel :interval="3000" type="card" height="400px" width="">
        <el-carousel-item v-for="item in imageList" :key="item.id">
            <img :src="item.url" alt="" class="image">
        </el-carousel-item>
      </el-carousel>
    </div>
    <h2>推荐歌手</h2>
    <div class="avatar-row1">
      <div v-for="item in singerList" :key="item.id">
        <el-avatar :size="213" :shape="'round'">
          <img :src="item.url" @click=goDetail(item.id) />
        </el-avatar>
        <div class="avatar-text1">{{ item.name }}</div>
      </div>
    </div>
    <h2>推荐歌曲</h2>
    <el-table
        :data="songList"
        style="width: 100%">
        <el-table-column prop="id" width="300">
          <template slot-scope="scope">
              <span>{{ scope.$index + 1}}</span>
          </template>
        </el-table-column>
        <el-table-column
          prop="name"
          label="歌名"
          width="300">
        </el-table-column>
        <el-table-column
          prop="singer"
          label="歌手">
        </el-table-column>
        <el-table-column>
          <template slot-scope="scope">
            <CaretRightOutlined style="font-size: 25px;" @click="play(scope.row.id, scope.row.url)" v-if="!scope.row.isPlay"></CaretRightOutlined> 
            <PauseOutlined style="font-size: 25px;" @click="play(scope.row.id, scope.row.url)" v-else></PauseOutlined> 
              &nbsp;&nbsp;&nbsp;&nbsp;
            <HeartOutlined style="font-size: 25px;" @click="star(scope.row.id)" v-if="!scope.row.isStar"></HeartOutlined> 
            <HeartFilled style="font-size: 25px;" @click="star(scope.row.id)" v-else></HeartFilled> 
          </template>
        </el-table-column>
    </el-table>
  </div>
</template>

<script>
import {CaretRightOutlined, HeartOutlined, PauseOutlined, HeartFilled} from "@ant-design/icons-vue"
export default {
  components: {
    CaretRightOutlined,
    HeartOutlined,
    PauseOutlined,
    HeartFilled
  },
    data() {
        return {
            imageList:[
                {id:0, url:require("../assets/img/jg.jpg")},
                {id:1, url:require("../assets/img/guitar.jpg")},
                {id:2, url:require("../assets/img/spoon.jpg")},
                {id:3, url:require("../assets/img/background.jpg")}   
            ],
            singerList:[
              {id: 0, url: require("@/assets/img/Jay.jpg"), name: "周杰伦"},
              {id: 1, url: require("@/assets/img/ljj.jpg"), name: "林俊杰"},
              {id: 2, url: require("@/assets/img/wlh.jpg"), name: "王力宏"},
              {id: 3, url: require("@/assets/img/tz.jpg"), name: "陶喆"},
              {id: 4, url: require("@/assets/img/dzq.jpg"), name: "邓紫棋"},
              {id: 5, url: require("@/assets/img/zl.jpg"), name: "赵雷"},
              {id: 6, url: require("@/assets/img/cyx.jpg"), name: "陈奕迅"},
            ],
            songList: [
              { id: 0, url: "http://localhost:8080/song/一路向北.mp3", name: "一路向北", singer: "周杰伦", isPlay: false, isStar: false},
              { id: 1, url: "http://localhost:8080/song/七里香.mp3", name: "七里香", singer: "周杰伦", isPlay: false, isStar: false},
              { id: 2, url: "http://localhost:8080/song/晴天.mp3", name: "晴天", singer: "周杰伦", isPlay: false, isStar: false},
          ],
        }
    },
    methods: {
      goDetail(id) {
        this.$router.push({path: `singer-detail/${id}`})
      }
    }
}
</script>

<style>
.avatar-text1 {
  padding-top: 10px;
  padding-left: 75px;
  padding-bottom: 30px;
  font-size: 15px;
  color: #333;
}
.avatar-row1 {
  display: flex;
  flex-wrap: wrap; /* 如果头像过多，可以换行 */
  gap: 22px; /* 控制每个头像之间的间距 */
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