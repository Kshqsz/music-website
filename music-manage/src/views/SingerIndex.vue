<template>
  <div>
    <div class="top">
      <div class="search">
        <el-input v-model="input" placeholder="请输入内容" style="width: 200px;" class="in"></el-input>
        <el-button type="primary" class="button">搜索</el-button>
      </div>
      <el-button type="primary" class="add" @click="add()">新增歌手</el-button>
    </div>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="id"
        label="ID"
        width="100">
      </el-table-column>
      <el-table-column
        prop="name"
        label="名称"
        width="100">
      </el-table-column>
      <el-table-column
        prop="sex"
        label="性别"
        width="100">
      </el-table-column>
      <el-table-column
        prop="birth"
        label="生日"
        width="120">
      </el-table-column>
      <el-table-column
        prop="pic"
        label="图片"
        width="140">
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
      <el-table-column label="查看歌曲">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="searchsong(scope.$index, scope.row)">查看歌曲</el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
    </el-table>


    <el-dialog title="修改歌手信息" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="歌手姓名" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="活动区域" :label-width="formLabelWidth">
          <el-select v-model="form.region" placeholder="请选择活动区域">
            <el-option label="区域一" value="shanghai"></el-option>
            <el-option label="区域二" value="beijing"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>
    <el-button type="primary" class="button" onclick="window.print()">打印预览</el-button>
    </div>
</template>

<script>
export default {
  data() {
    return {
      dialogFormVisible: false,
      form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '120px',
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
  },
  methods:{
    searchsong () {
      this.$router.push('/sinsong');
    },
    handleEdit () {
      this.dialogFormVisible=true
    },
    add () {
      this.$router.push('/addsinger');
    }
  }
}
</script>

<style scoped>
.top{
  display: flex;
  justify-content: space-between;
  margin-bottom: 25px;
}
.search .button{
  margin-left: 20px;
}
.add{
  margin-right: 110px;
}
</style>