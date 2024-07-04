<template>
  <div class="song-audio">
    <audio 
        ref="player"
        :src="url"
        controls="controls"
        preload="true"
        @canplay="startPlay"
        @ended="ended"
    ></audio>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
    name: 'song-audio',
    computed: {
        ...mapGetters([
            'id',
            'url',
            'isPlay'
        ])
    },
    watch: {
        isPlay: function() {
            this.togglePlay();
        }
    },
    methods: {
        startPlay() {
            let player = this.$refs.player;
            player.play();
        },
        ended() {
            this.isPlay = false
        },
        togglePlay() {
            let player = this.$refs.player;
            if (this.isPlay) {
                setTimeout(() => {
                    player.play();
                }, 500)
            } else {
                player.pause()
            }
        }
    }
}
</script>

<style>
    .song-audio {
        display: inline;
    }
</style>