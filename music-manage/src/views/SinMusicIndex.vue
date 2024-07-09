<template>
  <div class="info">
    <div class="left">
      <img :src="form.pic" alt="">
      <p>{{form.name}}</p>
      <p>{{ form.sex == 1 ? '男' : "女" }}</p>
      <p>介绍</p>
      <p>{{ form.introduction }}</p>
          <el-button size="middle" type="primary" @click="dialogFormVisible=true">上传歌曲</el-button>
        <el-dialog title="添加歌曲" :visible.sync="dialogFormVisible">
          <el-form :model="form">
            <el-form-item label="歌曲名称" :label-width="formLabelWidth">
              <el-input v-model="song.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="歌手名称" :label-width="formLabelWidth">
              <el-input v-model="song.singerName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="上传封面" :label-width="formLabelWidth">
              <el-upload
                style="background-color: gainsboro"
                class="avatar-uploader"
                action="/api/upload"
                :show-file-list="false"
                :on-success="uploadSuccess">
                <img v-if="imgUrl" :src="imgUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            </el-form-item>
            <el-upload 
              action="/api/upload" 
              :headers="{'Authorization': token}"
              :auto-upload="true"
              :on-success="uploadSuccess1">
              <el-button size="middle" type="primary" style="margin-left: 200px;">点击上传歌曲</el-button>
            </el-upload>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="add()">确 定</el-button>
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
        prop="date"
        label="封面"
        width="180">
        <template slot-scope="scope">
          <img :src="tableData[scope.$index].pic" alt="" style="width: 70px;">
        </template>
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
import axios from "@/utils/axios"
export default {
  data() {
    return {
      singerId: 0,
      dialogFormVisible: false, 
      song: {
        singerName: '',
        name: '',
        pic: '',
        url: ''
      },
      form: {
        name: '',
        birth: '',
        sex: '',
        pic: '',
        location: '',
        introduction: ''
      },
      formLabelWidth: '120px',
      tableData: [],
      imgUrl: '',
    }
  },
  methods:{
    async getSongs() {
        await axios.get(`/song/getBySingerId/${this.singerId}`).then(res => {
          if (res.data.code === 0) {
            this.tableData = res.data.data;
          } else {
            this.$message.error("服务错误");
          }
        })
      },
    async add() {
      await axios.post("/admin/addSong", this.song).then(res => {
        if (res.data.code === 0) {
          this.$message.success("添加成功");
          this.dialogFormVisible = false;
        }
      })
    },  
    uploadSuccess(response) {
      this.imgUrl = `${response.data}`;
      this.song.pic = `${response.data}`;
      this.$message.success("封面上传成功");  
    },
    uploadSuccess1(response) {
        this.song.url = `${response.data}`;
        this.$message.success("歌曲上传成功");  
    },
    handleEdit () {
      this.dialogFormVisible=true
    },
    async getSinger(id) {
        await axios.get(`/singer/${id}`).then( res => {
          if (res.data.code === 0) {
            this.form = res.data.data;
            //this.getSongs(this.singer.id);
          } else {
            this.$message.error("服务错误");
          }
        })
      }
  },
  created() {
    this.singerId = this.$route.params.id;
    this.getSinger(this.singerId);
    this.getSongs();
  }
}
</script>

<style scoped>
.avatar-uploader{
  
  width: 100px;
  height: 100px;
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
    width: 100px;
    height: 100px;
    line-height: 100px;
    text-align: center;
  }
  .avatar {
    width: 100x;
    height: 100px;
    display: block;
  }
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