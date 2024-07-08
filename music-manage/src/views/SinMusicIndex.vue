<template>
  <div class="info">
    <div class="left">
      <img src="../assets/img/dzq.jpg" alt="">
      <p>邓紫棋</p>
      <p>女</p>
      <p>经历</p>
      <p>邓紫棋，英文名G.E.M.，是一位中国香港籍流行歌手和词曲创作人。
        她在音乐界取得了巨大成功，不仅在中国内地、香港和台湾拥有大量粉丝，
        也在国际上赢得了知名度。邓紫棋的音乐风格多样，
        横跨流行、R&B、电子等多种风格，深受听众喜爱。</p>
        <el-button type="primary" class="add" @click="handleEdit ()">新增歌曲</el-button>
        <el-dialog title="添加歌曲" :visible.sync="dialogFormVisible">
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
    </div>
    <div class="right">
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
    </div>
    
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
      
    ]
    }
  },
  methods:{
    handleEdit () {
      this.dialogFormVisible=true
    },
  }
}
</script>

<style>
.info{
  display: flex;
}
.left{
 
  width: 400px;
  margin-right: 100px;
 
}
.left img{
  width: 300px;
  height: 300px;
}
</style>