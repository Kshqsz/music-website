<template>
  <div>
    <el-container>
      <el-header>
        <div class="head">
          <div class="lef">Spoon-music 后台管理</div>
          <div class="rig"> <el-avatar>admin</el-avatar><div>
    </div></div>
        </div>

      </el-header>
    <el-container>
      <el-aside width="200px">
        <el-col :span="20">
          <el-menu default-active="/home" class="el-menu-vertical-demo" router="true">
            <el-menu-item index="/home" router="true" >
              <span slot="title">系统首页</span>
            </el-menu-item>
            <el-menu-item index="/song" router="true">
              <span slot="title">歌单管理</span>
            </el-menu-item>
            <el-menu-item index="/singer" router="true">
              <span slot="title">歌手管理</span>
            </el-menu-item>
            <el-menu-item index="user" router="true">
              <span slot="title">用户管理</span>
            </el-menu-item>
          </el-menu>
        </el-col> 
      </el-aside>
      <el-main><router-view ></router-view></el-main>
    </el-container>
  </el-container>
  </div>
  
</template>

<script>

export default({
  setup() {
    
  },
})
</script>
<style>

.head{
  display: flex;
  justify-content: space-between;
  padding-bottom: 10px;
  border-bottom: 1px solid black
}
</style>