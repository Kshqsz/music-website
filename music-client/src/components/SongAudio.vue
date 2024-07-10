<template>
  <div class="song-audio">
    <audio
      ref="player"
      :src="url"
      controls="controls"
      preload="true"
      @canplay="startPlay"
      @ended="ended"
      @timeupdate="timeupdate"
    ></audio>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "song-audio",
  computed: {
    ...mapGetters([
      "id",
      "url",
      "listOfSongs", // 存放的音乐
      "isPlay", // 播放状态
      "volume", // 音量
      "curTime", // 当前音乐的播放位置
      "changeTime", // 指定播放时刻
      "autoNext", // 用于触发自动播放下一首
    ]),
  },
  watch: {
    isPlay() {
      this.togglePlay();
    },
    changeTime() {
      this.$refs.player.currentTime = this.changeTime;
    },
    volume(val) {
      this.$refs.player.volume = val;
    },
  },
  methods: {
    startPlay() {
      let player = this.$refs.player;
      this.$store.commit("setDuration", player.duration);
      player.play();
      this.$store.commit("setIsPlay", true);
    },
    ended() {
      this.$store.commit("setIsPlay", false);
      this.$store.commit("setCurTime", 0);
      //this.$store.commit('setAutoNext', this.autoNext);
    },
    togglePlay() {
      let player = this.$refs.player;
      if (this.isPlay) {
        setTimeout(() => {
          player.play();
        }, 50);
      } else {
        player.pause();
      }
    },
    timeupdate() {
      this.$store.commit("setCurTime", this.$refs.player.currentTime);
    },
  },
};
</script>

<style>
.song-audio {
  display: inline;
}
</style>