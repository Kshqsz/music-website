<template>
  <div>
    <el-card>
        <div class="user-info">
            <el-avatar :size="259" :shape="'circle'">
            <img :src="user.avatar" />
            </el-avatar>
            <div>
                <h1 class="user-name">{{ this.user.username}}</h1>
            </div>
        </div>
        <el-table
        :data="starList"
        style="width: 100%">
        <el-table-column prop="id" width="300">
          <template slot-scope="scope">
              <span>{{ scope.$index + 1}}</span>
          </template>
        </el-table-column>
        <el-table-column
          prop="name"
          label="歌名"
          width="300">
        </el-table-column>
        <el-table-column
          prop="singerName"
          label="歌手">
        </el-table-column>
        <el-table-column>
          <template slot-scope="scope"> 
            <CaretRightOutlined style="font-size: 25px;" @click="play(scope.row.id, scope.row.url, scope.row.pic, scope.row.name, scope.row.singerName)" v-if="(!isPlay || (isPlay && title !== scope.row.name))"></CaretRightOutlined> 
            <PauseOutlined style="font-size: 25px;" @click="play(scope.row.id, scope.row.url, scope.row.pic, scope.row.name, scope.row.singerName)" v-if="(isPlay && title === scope.row.name)"></PauseOutlined> 
              &nbsp;&nbsp;&nbsp;&nbsp;
            <HeartOutlined style="font-size: 25px;" @click="star(scope.row.id)" v-if="!isStar(scope.row.id)"></HeartOutlined> 
            <HeartFilled style="font-size: 25px;" @click="star(scope.row.id)" v-else></HeartFilled>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
      <el-upload 
          class="avatar-uploader" 
          :show-file-list="false"
          :auto-upload="true"
          action="/api/upload"
          :headers="{'Authorization': token}"
          :on-success="uploadSuccess1"
          >
          <img v-if="imgUrl" :src="imgUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>
      <br>
      <el-upload 
          action="/api/upload" 
          :headers="{'Authorization': token}"
          :auto-upload="true"
          :on-success="uploadSuccess">
          <el-button size="middle" type="primary">点击上传</el-button>
      </el-upload>
  </div>
</template>

<script>
import {CaretRightOutlined, PauseOutlined, HeartFilled, HeartOutlined} from "@ant-design/icons-vue"
import { mapGetters } from 'vuex';
import mixins from "@/mixins";
import store from '@/store'
export default {
  mixins: [mixins],
    components: {
      CaretRightOutlined,
      PauseOutlined,
      HeartFilled,
      HeartOutlined
    },
    computed: {
      ...mapGetters([
          'user',
          'starList',
          'isPlay',
          'title'
      ])
    },
    data() {
      return {
        song: {
          singerName: '',
          name: '',
          pic: '',
          url: '',
        },
        token: store.state.token,
        imgUrl: "",
      }
    },
    methods: {
      uploadSuccess(response) {
        this.song.url = `${response.data}`;
        this.$message.success("上传成功");  
      },
      uploadSuccess1(response) {
        this.imgUrl = `${response.data}`;
        this.song.pic = `${response.data}`;
        this.$message.success("上传成功");  
      }
    }
}
</script>

<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
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