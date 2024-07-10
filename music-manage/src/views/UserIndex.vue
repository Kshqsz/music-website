<template>
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"> </el-table-column>
      <el-table-column label="头像" width="180">
        <template slot-scope="scope">
          <img
            :src="tableData[scope.$index].avatar"
            alt=""
            style="width: 85px"
          />
        </template>
      </el-table-column>
      <el-table-column prop="username" label="用户名"> </el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-button type="danger" @click="handleDelete(scope.row.id)"
            >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "@/utils/axios";
export default {
  data() {
    return {
      tableData: [],
    };
  },
  methods: {
    async listUser() {
      await axios.get("/admin/listUser").then((res) => {
        if (res.data.code === 0) {
          this.tableData = res.data.data;
        }
      });
    },
    async handleDelete(id) {
      this.$confirm("你确定要删除吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(async () => {
        await axios.delete(`/admin/deleteUser/${id}`).then((res) => {
          if (res.data.code === 0) {
            this.$message.success("删除成功");
            this.listUser();
          }
        });
      });
    },
  },
  created() {
    this.listUser();
  },
};
</script>