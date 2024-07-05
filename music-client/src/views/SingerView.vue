<template>
  <div class="avatar-row">
    <div v-for="item in singerList" :key="item.id">
      <el-avatar :size="309" :shape="'circle'">
        <img :src="item.url"  @click=goDetail(item.id) />
      </el-avatar>
      <div class="avatar-text">{{ item.name }}</div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      singerList:[
        {id: 0, url: require("@/assets/img/Jay.jpg"), name: "周杰伦"},
        {id: 1, url: require("@/assets/img/ljj.jpg"), name: "林俊杰"},
        {id: 2, url: require("@/assets/img/wlh.jpg"), name: "王力宏"},
        {id: 3, url: require("@/assets/img/tz.jpg"), name: "陶喆"},
        {id: 4, url: require("@/assets/img/dzq.jpg"), name: "邓紫棋"},
        {id: 5, url: require("@/assets/img/zj.jpg"), name: "张杰"},
        {id: 6, url: require("@/assets/img/zl.jpg"), name: "赵雷"},
        {id: 7, url: require("@/assets/img/xs.jpg"), name: "许嵩"},
        {id: 8, url: require("@/assets/img/cyx.jpg"), name: "陈奕迅"},
        {id: 9, url: require("@/assets/img/ljr.jpg"), name: "梁静茹"},
        {id: 10, url: require("@/assets/img/lj.jpg"), name: "李健"},
        {id: 11, url: require("@/assets/img/zxy.jpg"), name: "张学友"},
        {id: 12, url: require("@/assets/img/zxz.jpg"), name: "张信哲"},
        {id: 13, url: require("@/assets/img/fhcq.jpg"), name: "凤凰传奇"},
        {id: 14, url: require("@/assets/img/xw.jpg"), name: "许巍"},
      ]
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
.avatar-row {
  display: flex;
  flex-wrap: wrap; /* 如果头像过多，可以换行 */
  gap: 20px; /* 控制每个头像之间的间距 */
}
.avatar-text {
  padding-top: 10px;
  padding-left: 120px;
  padding-bottom: 30px;
  font-size: 18px;
  color: #333;
}
</style>