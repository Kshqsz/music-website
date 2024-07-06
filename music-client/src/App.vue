<template>
  <div id = "app">
    <router-view></router-view>
    <song-audio v-if="isLogin" v-show="false"></song-audio>
    <play-bar v-if="isLogin"></play-bar>
  </div>
</template>
<script>

import SongAudio from '@/components/SongAudio.vue'
import PlayBar from '@/components/PlayBar.vue'
import { mapGetters } from 'vuex';
  export default {
    computed: {
      ...mapGetters([
        'isLogin'
      ])
    },
    name: 'App',
    components: {
      SongAudio,
      PlayBar
    }
  }
</script>