
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
          prop="singer"
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
    </el-card>
  </div>
</template>

<script>
import {CaretRightOutlined, HeartOutlined, PauseOutlined, HeartFilled} from "@ant-design/icons-vue"
import { mapGetters } from "vuex"
import axios from "../utils/axios"
export default {
  components: {
    CaretRightOutlined,
    HeartOutlined,
    PauseOutlined,
    HeartFilled
  },
  computed: {
      ...mapGetters([
          'isPlay',
          'title'
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
            this.songList.slice(0, 5);
          } else {
            this.$message.error("服务错误");
          }
        })
      },
    play(url, pic, title, artist) {
      this.$store.commit('setUrl', url);
      this.$store.commit('setPicUrl', pic);
      this.$store.commit('setTitle', title);
      this.$store.commit('setArtist', artist);
      if (this.isPlay) {
        this.$store.commit('setIsPlay', false);
      } else {
        this.$store.commit('setIsPlay', true);
      }
    },
    star(id) {
      this.songList[id].isStar = !this.songList[id].isStar
    }
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