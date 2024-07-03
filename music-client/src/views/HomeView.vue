<template>
  <div id = "home">
    <el-container>
      <el-header>
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <el-menu-item> 
                <i class="el-icon-service"></i> 
                <span style="color: #000; font-size: large;">Music</span>
            </el-menu-item>

            <el-menu-item index="/homepage">首页</el-menu-item>
            <el-menu-item index="2">歌单</el-menu-item>
            <el-menu-item index="3">歌手</el-menu-item>
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
            <el-menu-item class="flex-spacer" disabled></el-menu-item>

            <el-menu-item index="/login" class="right-menu-item">登录</el-menu-item>
            <el-menu-item index="/register" class="right-menu-item">注册</el-menu-item>
        </el-menu>

      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
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
.el-menu-demo {
    display: flex;
    align-items: center;
}

.flex-spacer {
    flex: 1;
}

.right-menu-item {
    margin-left: auto;
}
</style>