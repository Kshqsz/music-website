<template>
  <div id = "app">
    <router-view></router-view>
    <song-audio></song-audio>
    <play-bar></play-bar>
  </div>
</template>
<script>
import SongAudio from '@/components/SongAudio.vue'
import PlayBar from '@/components/PlayBar.vue'
  export default {
    name: 'App',
    components: {
      SongAudio,
      PlayBar
    }
  }
</script>