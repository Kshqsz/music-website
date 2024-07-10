<template>
  <div class="avatar-row">
    <div v-for="item in singerList" :key="item.id">
      <el-avatar :size="309" :shape="'circle'">
        <img
          :src="item.pic"
          @click="goDetail(item.id)"
          style="cursor: pointer"
        />
      </el-avatar>
      <div class="avatar-text">{{ item.name }}</div>
    </div>
  </div>
</template>

<script>
import axios from "../utils/axios";
import mixins from "@/mixins";
export default {
  mixins: [mixins],
  data() {
    return {
      singerList: [],
    };
  },
  methods: {
    async list() {
      await axios.get("/singer/list").then((res) => {
        if (res.data.code === 0) {
          this.singerList = res.data.data;
        } else {
          this.$message.error("服务错误");
        }
      });
    },
  },
  created() {
    this.list();
  },
};
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