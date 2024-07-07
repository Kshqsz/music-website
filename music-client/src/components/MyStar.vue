<template>
  <div>
    <el-card>
        <div class="user-info">
            <el-avatar :size="259" :shape="'circle'">
            <img :src="user.avatar" />
            </el-avatar>
            <div>
                <h1 class="user-name">{{ this.user.username}}</h1>
            </div>
        </div>
        <el-table
        :data="starList"
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
            <CaretRightOutlined style="font-size: 25px;" @click="play(scope.row.id, scope.row.url, scope.row.pic, scope.row.name, scope.row.singerName)" v-if="(!isPlay || (isPlay && title !== scope.row.name))"></CaretRightOutlined> 
            <PauseOutlined style="font-size: 25px;" @click="play(scope.row.id, scope.row.url, scope.row.pic, scope.row.name, scope.row.singerName)" v-if="(isPlay && title === scope.row.name)"></PauseOutlined> 
              &nbsp;&nbsp;&nbsp;&nbsp;
            <HeartOutlined style="font-size: 25px;" @click="star(scope.row.id)" v-if="!isStar(scope.row.id)"></HeartOutlined> 
            <HeartFilled style="font-size: 25px;" @click="star(scope.row.id)" v-else></HeartFilled>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
import {CaretRightOutlined, PauseOutlined, HeartFilled, HeartOutlined} from "@ant-design/icons-vue"
import { mapGetters } from 'vuex';
import mixins from "@/mixins";
export default {
  mixins: [mixins],
    components: {
      CaretRightOutlined,
      PauseOutlined,
      HeartFilled,
      HeartOutlined
    },
    computed: {
      ...mapGetters([
          'user',
          'starList',
          'isPlay',
          'title'
      ])
    }
}
</script>

<style>

</style>