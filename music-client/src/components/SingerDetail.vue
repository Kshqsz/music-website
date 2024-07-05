<template>
    <div>
      <el-card class="singer-card">
        <div class="singer-info">
          <el-avatar :size="259" :shape="'circle'">
            <img :src="singer.url" />
          </el-avatar>
          <div>
            <h1 class="singer-name">{{singer.name}}</h1>
            <span class="singer-basicInfo">
                性别：xxx
                &nbsp;
                生日：xxx
                &nbsp;
                故乡：xxx
            </span>
          </div>
        </div>
        <div class="custom-tabs">
          <el-tabs>
            <el-tab-pane label="歌曲">
              <el-table
              :data="songList"
              style="width: 100%">
              <el-table-column prop="id" width="200">
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
            </el-tab-pane>
            <el-tab-pane label="详情">
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-card>
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
            singerId: '',
            singer: {},
            singerList:[
                {id: 0, url: require("@/assets/img/Jay.jpg"), name: "周杰伦"},
                {id: 1, url: require("@/assets/img/ljj.jpg"), name: "林俊杰"},
                {id: 2, url: require("@/assets/img/wlh.jpg"), name: "王力宏"},
                {id: 3, url: require("@/assets/img/tz.jpg"), name: "陶喆"},
                {id: 4, url: require("@/assets/img/dzq.jpg"), name: "邓紫棋"},
                {id: 5, url: require("@/assets/img/zj.jpg"), name: "张杰"},
                {id: 6, url: require("@/assets/img/zl.jpg"), name: "赵雷"},
                {id: 8, url: require("@/assets/img/xs.jpg"), name: "许嵩"},
                {id: 9, url: require("@/assets/img/cyx.jpg"), name: "陈奕迅"},
                {id: 10, url: require("@/assets/img/ljr.jpg"), name: "梁静茹"},
                {id: 11, url: require("@/assets/img/lj.jpg"), name: "李健"},
                {id: 12, url: require("@/assets/img/zxy.jpg"), name: "张学友"},
                {id: 13, url: require("@/assets/img/zxz.jpg"), name: "张信哲"},
                {id: 14, url: require("@/assets/img/fhcq.jpg"), name: "凤凰传奇"},
                {id: 15, url: require("@/assets/img/xw.jpg"), name: "许巍"},
            ],
            songList: [
            ]
        }
    },
    created() {
        this.singerId = this.$route.params.id;
        this.singer = this.singerList[this.singerId];
    }
}
</script>
<style>
.singer-info {
  display: flex;
}

.singer-name {
  margin-left: 20px; 
  margin-bottom: 20px;
  font-size: 35px; 
}
.singer-basicInfo {
  margin-top:20px;
  margin-left: 20px; 
  font-size: 25px; 
}
.el-tabs {
    margin-top: 40px;
}
</style>