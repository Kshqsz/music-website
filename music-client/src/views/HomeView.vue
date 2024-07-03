<template>
  <div id = "home">
    <el-container>
      <el-header>
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" router>
            <el-menu-item> 
                <i class="el-icon-headset"></i> 
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

            <el-menu-item index="/login">登录</el-menu-item>
            <el-menu-item index="/register">注册</el-menu-item>
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
export default {
    data() {
      return {
          message: '',
      }
    },
    methods: {
        search() {
            this.$message.success("开始搜索");
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
</style>