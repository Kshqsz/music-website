<template>
  <div>    
    <el-card class="box-card" >
      <span class = "title">Spoon-music 用户登录</span>
      <br>
      <el-form label-width="30px" router>
        <el-form-item  prop="username">
            <el-input prefix-icon="el-icon-user" placeholder = "用户名" @keyup.enter.native="login" style="width: 400px;"></el-input>
        </el-form-item>
        <el-form-item  prop="password">
            <el-input prefix-icon="el-icon-lock" type = "password" placeholder = "密码" @keyup.enter.native="login" style="width: 400px;"></el-input>
        </el-form-item>
        <el-form-item style="padding-left:50px;">
            <el-button type = "primary" @click = "login" style="width: 300px;">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
    <img src="../assets/guitar.jpg" alt="" class="background-image">
  </div>
</template>

<script>
export default {
  methods: {
    toRegister() {
      this.$router.push("/register")
    }
  }
}
</script>

<style>
  .box-card {
    height: 610px;
    width: 500px;
    margin-top: 130px;
    margin-left: calc(80% - 250px);
    padding-top: 20px;
    opacity: 1;
  }
  .title {
      display: block;
      margin: 0 auto;
      font-size: 40px;
      text-align: center;
  }
  .background-image {
    position: absolute; /* 设置绝对定位 */
    top: 70px;
    left: 0;
    width: 100%;
    height: 85%;
    z-index: -1; /* 将图片放到最底层，不会覆盖原来的内容 */
    opacity: 1; /* 可以根据需要调整透明度 */
  } 
</style>