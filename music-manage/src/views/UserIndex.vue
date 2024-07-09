<template>
  <div>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="id"
        label="ID"
        width="180">
      </el-table-column>
      <el-table-column
        label="头像"
        width="180">
        <template slot-scope="scope">
          <img :src="tableData[scope.$index].avatar" alt="" style="width: 85px;">
        </template>
      </el-table-column>
      <el-table-column
        prop="username"
        label="用户名">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "@/utils/axios"
export default {
  data() {
    return {
      tableData: []
    }
  },
  methods: {
    async listUser() {
      await axios.get("/admin/listUser").then(res => {
        if (res.data.code === 0) {
          this.tableData = res.data.data;
        }
      })
    }
  },
  created() {
    this.listUser();
  }
}
</script>