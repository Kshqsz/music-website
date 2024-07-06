<template>
    <div>
      <el-card class="singer-card">
        <div class="singer-info">
          <el-avatar :size="259" :shape="'circle'">
            <img :src="singer.pic" />
          </el-avatar>
          <div>
            <h1 class="singer-name">{{singer.name}}</h1>
            <span class="singer-basicInfo">
                性别:  &nbsp;{{ singer.sex === 1 ? "男" : "女" }}
                <br><br>
                &nbsp;&nbsp;&nbsp;生日: &nbsp; {{ singer.birth }}
                <br><br>
                &nbsp;&nbsp;&nbsp;故乡: &nbsp; {{ singer.location }}
            </span>
          </div>
        </div>
        <div class="custom-tabs">
          <el-tabs>
            <el-tab-pane label="歌曲">
              <el-table
              :data="songList"
              style="width: 100%">
              <el-table-column prop="id" width="200">
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
                  <CaretRightOutlined style="font-size: 25px;" @click="play(scope.row.url, scope.row.pic, scope.row.name, scope.row.singerName)" v-if="(!isPlay || (isPlay && title !== scope.row.name))"></CaretRightOutlined> 
            <PauseOutlined style="font-size: 25px;" @click="play(scope.row.url, scope.row.pic, scope.row.name, scope.row.singerName)" v-if="(isPlay && title === scope.row.name)"></PauseOutlined> 
                    &nbsp;&nbsp;&nbsp;&nbsp;
                  <HeartOutlined style="font-size: 25px;" @click="star(scope.row.id)" v-if="!scope.row.isStar"></HeartOutlined> 
                  <HeartFilled style="font-size: 25px;" @click="star(scope.row.id)" v-else></HeartFilled> 
                </template>
              </el-table-column>
              </el-table>
            </el-tab-pane>
            <el-tab-pane label="详情">
              {{singer.introduction}}
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-card>
    </div>
  </template>

<script>
import {CaretRightOutlined, HeartOutlined, PauseOutlined, HeartFilled} from "@ant-design/icons-vue"
import axios from "../utils/axios"
import { mapGetters } from "vuex"
import mixins from "@/mixins"
export default {
  mixins: [mixins],
  computed: {
    ...mapGetters([
      'isPlay',
      'title'
    ])
  },  
  components: {
    CaretRightOutlined,
    HeartOutlined,
    PauseOutlined,
    HeartFilled
  },
    data() {
        return {
            singerId: '',
            singer: {},
            songList: [],
        }
    },
    methods: {
      async getSongs(singerId) {
        await axios.get(`/song/getBySingerId/${singerId}`).then(res => {
          if (res.data.code === 0) {
            this.songList = res.data.data;
          } else {
            this.$message.error("服务错误");
          }
        })
      },
      async getSinger(id) {
        await axios.get(`/singer/${id}`).then( res => {
          if (res.data.code === 0) {
            this.singer = res.data.data;
            this.getSongs(this.singer.id);
          } else {
            this.$message.error("服务错误");
          }
        })
      }
    },  
    created() {
        this.singerId = this.$route.params.id;
        this.getSinger(this.singerId);
    }
}
</script>
<style>
.singer-info {
  display: flex;
}

.singer-name {
  margin-left: 20px; 
  margin-bottom: 20px;
  font-size: 35px; 
}
.singer-basicInfo {
  margin-top:20px;
  margin-left: 20px; 
  font-size: 22px; 
}
.el-tabs {
    margin-top: 40px;
}
</style>