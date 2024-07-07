
<template>
  <div>
    <el-card class="song-card">
      <el-table
        :data="songList"
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
            <CaretRightOutlined style="font-size: 25px;" @click="play(scope.row.id,scope.row.url, scope.row.pic, scope.row.name, scope.row.singerName)" v-if="(!isPlay || (isPlay && title !== scope.row.name))"></CaretRightOutlined> 
            <PauseOutlined style="font-size: 25px;" @click="play(scope.row.id,scope.row.url, scope.row.pic, scope.row.name, scope.row.singerName)" v-if="(isPlay && title === scope.row.name)"></PauseOutlined> 
              &nbsp;&nbsp;&nbsp;&nbsp;
            <HeartOutlined style="font-size: 25px;" @click="star(scope.row.id)" v-if="!isStar(scope.row.id)"></HeartOutlined> 
            <HeartFilled style="font-size: 25px;" @click="star(scope.row.id)" v-else></HeartFilled>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
import {CaretRightOutlined, HeartOutlined, PauseOutlined, HeartFilled} from "@ant-design/icons-vue"
import { mapGetters } from "vuex"
import axios from "../utils/axios"
import mixins from "@/mixins"
export default {
  mixins: [mixins],
  components: {
    CaretRightOutlined,
    HeartOutlined,
    PauseOutlined,
    HeartFilled
  },
  computed: {
      ...mapGetters([
          'isPlay',
          'title',
          'userId',
          'starList'
      ])
  },
  data() {
    return {
      songList: [],
    }
  },
  methods: {
    async listSong() {
        await axios.get("/song/list").then(res => {
          if (res.data.code === 0) {
            this.songList = res.data.data;
          } else {
            this.$message.error("服务错误");
          }
        })
      },
  },
  created() {
    this.listSong();
  }
}
</script>

<style>
.song-card {
  margin-left: 15%;
  margin-right: 15%;
}
</style>