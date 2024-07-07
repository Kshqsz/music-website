<template>
  <div class="play-bar">
    <div class="kongjian">
        <!-- 上一首 -->
        <div class="item">
            <svg class="icon">
                <use xlink:href="#icon-ziyuanldpi"></use>
            </svg>
        </div>
        <!-- 播放 -->
        <div class="item" @click="togglePlay()">
            <svg class="icon">
                <use :xlink:href="playButtonUrl"></use>
            </svg>
        </div>
        <!-- 下一首 -->
        <div class="item">
            <svg class="icon">
                <use xlink:href="#icon-ziyuanldpi1"></use>
            </svg>
        </div>
                <!-- 歌曲图片 -->
        <div class="item-img">
            <img :src="picUrl" alt="">
        </div>
        <!-- 播放进度 -->
        <div class="playing-speed">
            <!-- 播放开始时间 -->
            <div class="current-time">
                {{ nowTime }}
            </div>
            <div class="progress-box">
                <div class="item-song-title">
                    <div>{{ this.title }}</div>
                    <div>{{ this.artist }}</div>
                </div>
                <div class="progress" ref="progress" @mousemove="mousemove">
                    <!-- 进度条 -->
                    <div ref="bg" class="bg" @click="updatemove">
                        <div ref="curProgress" class="cur-progress" :style="{width: curLength + '%'}"></div>
                    </div>
                    <div class="idot" ref="idot" :style="{left: curLength + '%'}" @mousedown="mousedown" @mouseup="mouseup"></div>
                </div>
            </div>
            <!-- 播放结束时间 -->
            <div class="left-time">
                {{ songTime }}
            </div>
            <!-- 音量 -->
            <div class="item item-volume">
                <svg v-if="volume == 0" class="icon">
                    <use xlink:href="#icon-yinliangjingyinheix"></use>
                </svg>
                <svg v-else class="icon">
                    <use xlink:href="#icon-yinliang1"></use>
                </svg>
                <el-slider class="volume" v-model="volume" :vertical="true"></el-slider>
            </div>
            <!-- 收藏 -->
            <div class="item" @click="star(id)">
                <svg class="icon">
                    <use xlink:href="#icon-xihuan"></use>
                </svg>
            </div>
            <!-- 当前播放的歌曲列表 -->
            <div class="item">
                <svg class="icon">
                    <use xlink:href="#icon-liebiao"></use>
                </svg>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import mixins from '@/mixins';
export default {
    mixins: [mixins],
    name: 'play-bar',
    data() {
        return {
            nowTime: '00:00',
            songTime: '00:00',
            curLength: 0,
            progressLength: 0,
            mouseStartX: 0,
            tag: false,
            volume: 50,
        }
    },
    computed: {
        ...mapGetters([
            'isPlay',
            'id',
            'url',
            'playButtonUrl',
            'picUrl',
            'title',
            'artist',
            'duration',
            'curTime',
        ])
    },
    watch: {
        isPlay() {
            if (this.isPlay) {
                this.$store.commit('setPlayButtonUrl', '#icon-zanting');
            } else {
                this.$store.commit('setPlayButtonUrl', '#icon-bofang');
            }
        },
        curTime() {
            this.nowTime = this.formatSeconds(this.curTime);
            this.songTime = this.formatSeconds(this.duration);
            this.curLength = (this.curTime / this.duration) * 100;
        },
        volume() {
            this.$store.commit('setVolume', this.volume / 100);
        }
    },
    methods: {
        togglePlay() {
            if (this.isPlay) {
                this.$store.commit('setIsPlay', false);
            } else {
                this.$store.commit('setIsPlay', true);
            }
        },
        formatSeconds(value) {
            let theTime = parseInt(value);
            let result = '';
            let minute = parseInt((theTime / 60) % 60);
            let second = parseInt(theTime % 60);
            if (minute) {
                if (minute < 10) {
                    result += '0' + minute + ":";
                } else {
                    result += minute + ":";
                }
            } else {
                result += "00:";
            }
            if (second) {
                if (second < 10) {
                    result += '0' + second;
                } else {
                    result += second;
                }
            } else {
                result += "00";
            }
            return result;
        },
        mousedown(e) {
            this.mouseStartX = e.clientX;
            this.tag = true;
        },
        mouseup() {
            this.tag = false;
        },
        mousemove(e) {
            if (!this.duration) {
                return false;
            }
            if (this.tag) {
                let movementX = e.clientX - this.mouseStartX;
                let curLength = this.$refs.curProgress.getBoundingClientRect().width;
                let newPercent = (movementX + curLength) / this.progressLength * 100;
                if (newPercent > 100) {
                    newPercent = 100;
                }
                this.curLength = newPercent;
                this.mouseStartX = e.clientX;
                this.changeTime(newPercent);
            }
        },
        changeTime(percent) {
            let newCurTime = (percent * 0.01) * this.duration;
            this.$store.commit('setChangeTime', newCurTime);
        },
        updatemove(e) {
            if (!this.tag) {
                let curLength = this.$refs.bg.offsetLeft;
                let newPercent = ((e.clientX - curLength) / this.progressLength) * 100;
                if (newPercent > 100) {
                    newPercent = 100;
                } else if (newPercent < 0) {
                    newPercent = 0;
                }
                this.curLength = newPercent;
                this.changeTime(newPercent);
            }
        }
    },
    mounted() {
        this.progressLength = this.$refs.progress.getBoundingClientRect().width;
        document.querySelector('.item-volume').addEventListener('click', function(e) {
            document.querySelector('.volume').classList.add('show-volume');
            e.stopPropagation();
        }, false);
        document.querySelector('.volume').addEventListener('click', function(e) {
            e.stopPropagation();
        }, false);
        document.addEventListener('click', function() {
            document.querySelector('.volume').classList.remove('show-volume');
        })
    }
}
</script>

<style lang="scss" scoped>
@import "../assets/css/play-bar.scss";
</style>