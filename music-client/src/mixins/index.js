import { mapGetters } from "vuex";
export default {
    computed: {
        ...mapGetters([
            'isPlay',
        ])
    },
    methods: {
        goDetail(id) {
            this.$router.push({path: `singer-detail/${id}`})
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
    },
}