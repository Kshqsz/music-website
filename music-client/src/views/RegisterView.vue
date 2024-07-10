<template>
  <div>
    <el-card class="box-card">
      <span class="title">Spoon-music 用户注册</span>
      <br />
      <el-form label-width="30px" router>
        <el-form-item prop="username">
          <el-input
            prefix-icon="el-icon-user"
            placeholder="用户名"
            style="width: 400px"
            v-model="registerForm.username"
          >
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            prefix-icon="el-icon-lock"
            type="password"
            placeholder="密码"
            style="width: 400px"
            v-model="registerForm.password"
          >
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            prefix-icon="el-icon-lock"
            type="password"
            placeholder="确认密码"
            @keyup.enter.native="register()"
            style="width: 400px"
            v-model="registerForm.rePassword"
          >
          </el-input>
        </el-form-item>
        <el-form-item style="padding-left: 50px">
          <el-button @click="register()" style="width: 300px"> 注册 </el-button>
        </el-form-item>
      </el-form>
    </el-card>
    <img src="../assets/img/jg.jpg" alt="" class="background-image" />
  </div>
</template>

<script>
import axios from "@/utils/axios";
export default {
  data() {
    return {
      registerForm: {
        username: "",
        password: "",
        rePassword: "",
      },
    };
  },
  methods: {
    register() {
      axios.post("/user/register", this.registerForm).then((res) => {
        if (res.data.code === 0) {
          this.$message.success("注册成功~");
          this.$router.push("/login");
          this.$store.commit("setActiveIndex", "/login");
        } else {
          this.$message.error(res.data.data);
        }
      });
    },
  },
};
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