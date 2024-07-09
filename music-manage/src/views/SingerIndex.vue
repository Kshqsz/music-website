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
        label="性别"
        width="100">
        <template slot-scope="scope">
          <span>{{ tableData[scope.$index].sex == 1  ? '男' : '女'}}</span>
        </template>
      </el-table-column>
      <el-table-column
        prop="birth"
        label="生日"
        width="120">
      </el-table-column>
      <el-table-column
        label="图片"
        width="140">
        <template slot-scope="scope">
          <img :src="tableData[scope.$index].pic" alt="" style="width: 85px;">
        </template>
      </el-table-column>
      <el-table-column
        prop="location"
        label="故乡"
        width="180">
      </el-table-column>
      <el-table-column label="查看歌曲">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="searchsong(scope.row.id)">查看歌曲</el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.row.id)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.row.id)">删除</el-button>
      </template> 
    </el-table-column>
    </el-table>




    <el-dialog title="修改歌手信息" :visible.sync="dialogFormVisible" class="dialog">
      <el-form ref="form" :model="form" label-width="80px">
        <el-upload
          style="background-color: gainsboro"
          class="avatar-uploader"
          action="/api/upload"
          :show-file-list="false"
          :on-success="uploadSuccess">
          <img v-if="imgUrl" :src="imgUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      <el-form-item label="歌手姓名">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="出生年份">
        <div class="block">
          <span class="demonstration"></span>
          <el-date-picker
            v-model="form.birth"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </div>
      </el-form-item>
      <el-form-item label="性别">
        <el-radio-group v-model="form.sex">
          <el-radio :label="1">男</el-radio>
          <el-radio :label="2">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="故乡">
        <el-input v-model="form.location"></el-input>
      </el-form-item>
      <el-form-item label="歌手描述">
        <el-input type="textarea" v-model="form.introduction"></el-input>
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
import axios from "@/utils/axios"
export default {
  data() {
    return {
      //formLabelWidth: '120px',
      dialogFormVisible: false,
      form: {
        name: '',
        birth: '',
        pic: '',
        sex: '',
        location: '',
        introduction: ''
      },
      initialForm: {
        name: '',
        birth: '',
        sex: '',
        location: '',
        introduction: ''
      },     
      tableData: [],
      imgUrl: ""
    }
  },
  methods:{
    uploadSuccess(response) {
      this.imgUrl = `${response.data}`;
      this.form.pic = `${response.data}`;
      this.$message.success("上传成功");  
    },
    searchsong (id) {
      this.$router.push({path: `sinsong/${id}`});
    },
    handleEdit(id) {
      axios.get(`/singer/${id}`).then(res => {
        if (res.data.code === 0) {
          this.form = res.data.data;
          this.imgUrl = this.form.pic;
          this.dialogFormVisible = true;
        }
      })
    },
    cancelForm() {
      this.dialogFormVisible = false;
      // 将表单字段重置为初始状态
      this.form = { ...this.initialForm };
    },
    saveForm() {
      // 处理保存表单数据的逻辑
      // 保存后关闭对话框
      this.dialogFormVisible = false;
    },

    async list() {
      await axios.get("/singer/list").then(res => {
        if (res.data.code === 0) {
          this.tableData = res.data.data;
        } else {
          this.$message.error("服务错误");
        }
      })
    },

    add () {
      this.$router.push('/addsinger');
    }
  },
  created() {
    this.list();
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
.dialog{
  margin-left: 320px;
  text-align: center;
  width: 1000px;
}
.avatar-uploader{
  
  width: 170px;
  height: 170px;
  margin-left: 150px;
  margin-bottom: 20px;
}
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    /* position: relative;
    overflow: hidden; */
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }

</style>