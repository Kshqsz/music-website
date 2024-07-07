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
        prop="name"
        label="名称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="sex"
        label="性别"
        width="180">
      </el-table-column>
      <el-table-column
        prop="birth"
        label="生日"
        width="180">
      </el-table-column>
      <el-table-column
        prop="pic"
        label="图片"
        width="180">
      </el-table-column>
      <el-table-column
        prop="location"
        label="籍贯"
        width="180">
      </el-table-column>
      <el-table-column
        prop="introduction"
        label="个人简介">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        id: '111',
        pic: '图片',
        name: '周杰伦',
        sex: '男',
        location: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1519 弄'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1516 弄'
      }]
    }
  }
}
</script>