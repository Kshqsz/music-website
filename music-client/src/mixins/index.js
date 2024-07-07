import { mapGetters } from "vuex";
import axios from "@/utils/axios"
export default {
    computed: {
        ...mapGetters([
            'isPlay',
            'userId',
            'starList'
        ])
    },
    methods: {
        goDetail(id) {
            this.$router.push({path: `singer-detail/${id}`})
        },
        play(id, url, pic, title, artist) {
            this.$store.commit('setUrl', url);
            this.$store.commit('setPicUrl', pic);
            this.$store.commit('setTitle', title);
            this.$store.commit('setArtist', artist);
            this.$store.commit('setId', id);
            if (this.isPlay) {
              this.$store.commit('setIsPlay', false);
            } else {
              this.$store.commit('setIsPlay', true);
            }
        },
        async getStarList(id) {
            await axios.get(`/user/starList/${id}`).then(res => {
              if (res.data.code === 0) {
                this.$store.commit("setStarList", res.data.data);
              } else {
                this.$message.error("服务错误");
              }
            })
        },
        async star(id) {
          await axios.post(`/user/star/${id}`).then(async res => {
            if (res.data.code === 0) {
              await this.getStarList(this.userId);
              this.$message.success("收藏成功~");
            } else {
              await this.cancelStar(id);
              this.$message.success("取消收藏成功~");
            }
          })
        },
        isStar(id) {
          for (let i = 0; i < this.starList.length; i++) {
            if (id == this.starList[i].id) {
              return true;
            }
          }
          return false;
        },
        async cancelStar(songId) {
          await axios.delete(`/user/cancelStar/${songId}`).then(async res => {
            if (res.data.code === 0) {
              await this.getStarList(this.userId);
            } else {
              this.$message.errror("服务错误");
            }
          }) 
        }
    },
}