<template>
  <div>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="ID"
        label="ID"
        width="180">
      </el-table-column>
      <el-table-column
        prop="pic"
        label="头像"
        width="180">
      </el-table-column>
      <el-table-column
        prop="username"
        label="用户名">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        ID: '2201',
        username: 'wwwwb白',
        pic: '图片'
      }, {
        ID: '2201',
        username: 'wwwwb白',
        pic: '图片'
      }, {
        ID: '2201',
        username: 'wwwwb白',
        pic: '图片'
      }, {
        ID: '2201',
        username: 'wwwwb白',
        pic: '图片'
      }]
    }
  }
}
</script>