<template>
    <div>
        <el-card class="sres-card">
            <el-tabs>
                <el-tab-pane label="歌曲">
                    <el-table
                    :data="this.searchSongList"
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
                </el-tab-pane>
                <el-tab-pane label="歌手">
                    <div class="avatar-row1">
                        <div v-for="item in this.searchSingerList" :key="item.id">
                        <el-avatar :size="209" :shape="'circle'">
                            <img :src="item.pic"  @click=goDetail(item.id) style="cursor: pointer;"/>
                        </el-avatar>
                        <div class="avatar-text2">{{ item.name }}</div>
                    </div>
                    </div>
                </el-tab-pane>
            </el-tabs>
        </el-card>
    </div>
</template>

<script>

import { mapGetters } from 'vuex';
import {CaretRightOutlined, HeartOutlined, PauseOutlined, HeartFilled} from "@ant-design/icons-vue"
import mixins  from '@/mixins';
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
            'searchSongList',
            'searchSingerList'
        ])
    }
}
</script>

<style>
.sres-card {
    margin-left: 10%;
    margin-right: 10%;
}
.avatar-text2 {
  padding-top: 10px;
  padding-left: 76px;
  padding-bottom: 30px;
  font-size: 18px;
  color: #333;
}
</style>