<template>
  <div>    
    <el-card class="box-card" >
      <span class = "title">Spoon-music 用户登录</span>
      <br>
      <el-form label-width="30px" router>
        <el-form-item  prop="username">
            <el-input 
              prefix-icon="el-icon-user" 
              placeholder = "用户名" 
              style="width: 400px;" 
              v-model="loginForm.username">
            </el-input>
        </el-form-item>
        <el-form-item  prop="password">
            <el-input 
              prefix-icon="el-icon-lock" 
              type = "password" 
              placeholder = "密码" 
              @keyup.enter.native="login" 
              style="width: 400px;" 
              v-model="loginForm.password">
            </el-input>
        </el-form-item>
        <el-form-item style="padding-left:50px;">
            <el-button 
              type = "primary" 
              @click = "login()" 
              style="width: 300px;"
              >登录
            </el-button>
        </el-form-item>
      </el-form>
    </el-card>
    <img src="../assets/img/guitar.jpg" alt="" class="background-image">
  </div>
</template>

<script>
import axios from '@/utils/axios'
import mixins from '@/mixins'
export default {
  mixins: [mixins],
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    login() {
      axios.post("/user/login", this.loginForm).then(async res => {
        if (res.data.code === 0) {
          this.$store.commit("setToken", res.data.data.token);
          this.$store.commit("setActiveIndex", '/homePage');
          this.$store.commit("setIsLogin", true);
          this.$store.commit("setUserId", res.data.data.userId);
          this.$store.commit("setUser", res.data.data.user);
          this.$store.commit("setUsername", this.loginForm.username);
          await this.getStarList(res.data.data.userId);
          this.$router.push('/homePage');
          this.$message.success("登录成功~ 欢迎你 " + this.loginForm.username + "~");
        } else {
          this.$message.error("用户名或密码错误");
        }
      })
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