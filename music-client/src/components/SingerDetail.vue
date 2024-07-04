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
        <el-tabs>
            <el-tab-pane label="歌曲">
                歌曲
            </el-tab-pane>
            <el-tab-pane label="详情">
                详情
            </el-tab-pane>
        </el-tabs>
      </el-card>
    </div>
  </template>

<script>
//import {CaretRightOutlined, HeartOutlined, PauseOutlined, HeartFilled} from "@ant-design/icons-vue"
export default {
//     components: {
//     CaretRightOutlined,
//     HeartOutlined,
//     PauseOutlined,
//     HeartFilled
//   },
    data() {
        return {
            singerId: '',
            singer: {},
            singerList:[
                {id: 0, url: require("@/assets/Jay.jpg"), name: "周杰伦"},
                {id: 1, url: require("@/assets/ljj.jpg"), name: "林俊杰"},
                {id: 2, url: require("@/assets/wlh.jpg"), name: "王力宏"},
                {id: 3, url: require("@/assets/tz.jpg"), name: "陶喆"},
                {id: 4, url: require("@/assets/dzq.jpg"), name: "邓紫棋"},
                {id: 5, url: require("@/assets/zj.jpg"), name: "张杰"},
                {id: 6, url: require("@/assets/zl.jpg"), name: "赵雷"},
                {id: 8, url: require("@/assets/xs.jpg"), name: "许嵩"},
                {id: 9, url: require("@/assets/cyx.jpg"), name: "陈奕迅"},
                {id: 10, url: require("@/assets/ljr.jpg"), name: "梁静茹"},
                {id: 11, url: require("@/assets/lj.jpg"), name: "李健"},
                {id: 12, url: require("@/assets/zxy.jpg"), name: "张学友"},
                {id: 13, url: require("@/assets/zxz.jpg"), name: "张信哲"},
                {id: 14, url: require("@/assets/fhcq.jpg"), name: "凤凰传奇"},
                {id: 15, url: require("@/assets/xw.jpg"), name: "许巍"},
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
  font-size: 35px; 
}
.singer-basicInfo {
  margin-left: 20px; 
  font-size: 25px; 
}
.el-tabs {
    margin-top: 40px;
}
</style>