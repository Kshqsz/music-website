<template>
  <div>
    <div class="top">
      <div class="search">
        <el-input
          v-model="input"
          placeholder="请输入内容"
          style="width: 200px"
          class="in"
        ></el-input>
        <el-button type="primary" class="button" @click="search()"
          >搜索</el-button
        >
      </div>
      <el-button
        type="primary"
        round
        class="button"
        onclick="window.print()"
        style="margin-left: 800px"
        >打印预览</el-button
      >
      <el-button type="success" round @click="exportToExcel"
        >导出 Excel</el-button
      >
    </div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column type="index" label="编号" width="180"> </el-table-column>
      <el-table-column prop="date" label="封面" width="180">
        <template slot-scope="scope">
          <img :src="tableData[scope.$index].pic" alt="" style="width: 70px" />
        </template>
      </el-table-column>
      <el-table-column prop="name" label="歌曲" width="180"> </el-table-column>
      <el-table-column prop="singerName" label="歌手" width="180">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row.id)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "@/utils/axios";
import * as XLSX from "xlsx";
export default {
  data() {
    return {
      tableData: [],
      input: "",
    };
  },
  methods: {
    exportToExcel() {
      const workSheet = XLSX.utils.json_to_sheet(this.tableData);
      const workBook = XLSX.utils.book_new();
      XLSX.utils.book_append_sheet(workBook, workSheet, "Sheet1");
      XLSX.writeFile(workBook, "singer.xlsx");
    },
    search() {
      axios
        .get("/song/search", {
          params: {
            keyword: this.input,
          },
        })
        .then((res) => {
          if (res.data.code === 0) {
            this.tableData = res.data.data.songList;
          }
        });
    },
    async listSong() {
      await axios.get("/song/list").then((res) => {
        if (res.data.code === 0) {
          this.tableData = res.data.data;
        } else {
          this.$message.error("服务错误");
        }
      });
    },
    async handleDelete(id) {
      this.$confirm("你确定要删除吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(async () => {
        await axios.delete(`/admin/deleteSong/${id}`).then((res) => {
          if (res.data.code === 0) {
            this.$message.success("删除成功");
            this.listSong();
          }
        });
      });
    },
  },
  created() {
    this.listSong();
  },
};
</script>

<style>
.top {
  display: flex;
  margin-bottom: 25px;
}
.search .button {
  margin-left: 20px;
}
.button {
  margin-left: 20px;
}
</style>
