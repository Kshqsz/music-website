<template>
  <div id = "home">
    <el-container>
      <el-header>
        <el-menu :default-active="this.activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" router>
            <el-menu-item> 
                <i class="el-icon-headset" style="font-size: 30px;"></i> 
                &nbsp;
                <span style="color: #000; font-size: large;">Spoon-music</span>
            </el-menu-item>

            <el-menu-item index="/homePage">首页</el-menu-item>
            <el-menu-item index="/song">歌曲</el-menu-item>
            <el-menu-item index="/singer">歌手</el-menu-item>
            <el-menu-item>
                <el-input 
                    v-model="message"
                    prefix-icon="el-icon-search" 
                    placeholder="搜索" 
                    style="width: 300px;" 
                    @keyup.enter.native="search()">
                </el-input>
            </el-menu-item>

            <!-- 用于占位的菜单项 -->
            <span class="flex-spacer"></span>

            <el-menu-item index="/login" v-if="!this.isLogin">登录</el-menu-item>
            <el-menu-item index="/register" v-if="!this.isLogin">注册</el-menu-item>
            <el-dropdown v-if="this.isLogin">
              <span class="el-dropdown-link">
                <el-avatar :size="55"/>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item>个人信息</el-dropdown-item>
                <el-dropdown-item>我的收藏</el-dropdown-item>
                <el-dropdown-item>
                  <span @click="exit()">退出</span>
                </el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
        </el-menu>

      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
      <el-footer>
        <span class="copyright">© Copyright 2024 Created By Han Shoukun and Wu Yuhuai </span>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
    computed: {
      ...mapGetters([
        "activeIndex",
        "isLogin"
      ])
    },
    data() {
      return {
          message: '',
      }
    },
    methods: {
        search() {
            this.$message.success("开始搜索");
        },
        exit() {
          this.$store.commit("setIsLogin", false);
        }
    }
}
</script>

<style>
.copyright {
  position: relative;
  top: 50%;
  width: 500px;
  height: 27px;
  margin-left: calc(50% - 245px);
}
.el-menu-demo {
    display: flex;
    align-items: center;
}

.flex-spacer {
    flex: 1;
}
.el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
</style>