<template>
  <div>
    <el-container>
      <el-header>
        <div class="head">
          <div class="lef" style="margin-top: 12px">
            <i class="el-icon-headset" style="font-size: 30px"></i>
            <strong style="font-size: 20px"> Spoon-music 后台管理 </strong>
          </div>
          <div class="rig">
            <el-col :span="12">
              <el-dropdown>
                <span class="el-dropdown-link">
                  <el-avatar>admin</el-avatar>
                </span>
                <el-dropdown-menu slot="dropdown" split-button="true">
                  <el-dropdown-item
                    ><button
                      @click="loginout"
                      style="background-color: transparent; border: none"
                    >
                      退出登录
                    </button></el-dropdown-item
                  >
                </el-dropdown-menu>
              </el-dropdown>
            </el-col>

            <div></div>
          </div>
        </div>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <el-col :span="20">
            <el-menu
              default-active="/home"
              class="el-menu-vertical-demo"
              router="true"
            >
              <el-menu-item index="/home" router="true">
                <span slot="title">
                  <i class="el-icon-s-home"></i>
                  系统首页
                </span>
              </el-menu-item>
              <el-menu-item index="/song" router="true">
                <span slot="title">
                  <i class="el-icon-mic"></i>
                  歌曲管理
                </span>
              </el-menu-item>
              <el-menu-item index="/singer" router="true">
                <span slot="title">
                  <i class="el-icon-headset"></i>
                  歌手管理
                </span>
              </el-menu-item>
              <el-menu-item index="user" router="true">
                <span slot="title">
                  <i class="el-icon-user"></i>
                  用户管理
                </span>
              </el-menu-item>
            </el-menu>
          </el-col>
        </el-aside>
        <el-main><router-view></router-view></el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  methods: {
    loginout() {
      this.$router.push("/");
    },
  },
};
</script>
<style>
.head {
  display: flex;
  justify-content: space-between;
  padding-bottom: 10px;
  border-bottom: 1px solid black;
}
</style>