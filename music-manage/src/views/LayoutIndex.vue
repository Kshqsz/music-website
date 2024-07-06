<<<<<<< HEAD
<template>
  <div>
    <el-col :span="3">
    <el-menu default-active="/home" class="el-menu-vertical-demo" router="true">
      <el-menu-item index="/home" router="true" >
        <span slot="title">首页</span>
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
   <router-view ></router-view>
  </div>
  
</template>

<script>

export default({
  setup() {
    
  },
})
</script>
=======
<template>
  <div>
    <el-col :span="3">
    <el-menu default-active="/home" class="el-menu-vertical-demo" router="true">
      <el-menu-item index="/home" router="true" >
        <span slot="title">首页</span>
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
   <router-view ></router-view>
  </div>
  
</template>

<script>

export default({
  setup() {
    
  },
})
</script>
>>>>>>> 3be15a873ce2edf4393ccf0b313e590682569073
