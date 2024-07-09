<template>
  <div>
    <div class="search">
        <el-input v-model="input" placeholder="请输入内容" style="width: 200px;" class="in"></el-input>
        <el-button type="primary" class="button">搜索</el-button>
      </div>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        type="index"
        label="编号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="歌曲"
        width="180">
      </el-table-column>
      <el-table-column
        prop="singerName"
        label="歌手"
        width="180">
      </el-table-column>
      <el-table-column
        prop="date"
        label="上传时间"
        width="180">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
      </el-table-column>
    </el-table>
    <el-button type="primary" class="button" onclick="window.print()">打印预览</el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        date: '2016-05-02',
        singerName: '周杰伦',
        name: '一路向北'
      },
      {
        date: '2016-05-02',
        singerName: '周杰伦',
        name: '一路向北'
      },
      {
        date: '2016-05-02',
        singerName: '周杰伦',
        name: '一路向北'
      },
      {
        date: '2016-05-02',
        singerName: '周杰伦',
        name: '一路向北'
      },
      {
        date: '2016-05-02',
        singerName: '周杰伦',
        name: '一路向北'
      },
      {
        date: '2016-05-02',
        singerName: '周杰伦',
        name: '一路向北'
      },]
    }
  }
}
</script>

<style>
.button{
  margin-left: 20px;
}
</style>
