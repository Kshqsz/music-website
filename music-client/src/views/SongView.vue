
<template>
  <div>
    <el-card class="song-card">
      <el-table
        :data="songList"
        stripe
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
            <CaretRightOutlined style="font-size: 25px;" @click="play(scope.row.id, scope.row.url)" v-if="!scope.row.isPlay"></CaretRightOutlined> 
            <PauseOutlined style="font-size: 25px;" @click="play(scope.row.id, scope.row.url)" v-else></PauseOutlined> 
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
export default {
  components: {
    CaretRightOutlined,
    HeartOutlined,
    PauseOutlined,
    HeartFilled
  },
  computed: {
      ...mapGetters([
          'isPlay'
      ])
  },
  data() {
    return {
      songList: [
        { id: 0, url: "http://localhost:8080/song/一路向北.mp3", name: "一路向北", singer: "周杰伦", isPlay: false, isStar: false},
        { id: 1, url: "http://localhost:8080/song/七里香.mp3", name: "七里香", singer: "周杰伦", isPlay: false, isStar: false},
        { id: 2, url: "http://localhost:8080/song/晴天.mp3", name: "晴天", singer: "周杰伦", isPlay: false, isStar: false},
      ],
    }
  },
  methods: {
    play(id, url) {
      this.songList[id].isPlay = !this.songList[id].isPlay;
      this.$store.commit('setUrl', url);
      if (this.isPlay) {
        this.$store.commit('setIsPlay', false);
      } else {
        this.$store.commit('setIsPlay', true);
      }
    },
    star(id) {
      this.songList[id].isStar = !this.songList[id].isStar
    }
  }
}
</script>

<style>
.song-card {
  margin-left: 15%;
  margin-right: 15%;
}
</style>