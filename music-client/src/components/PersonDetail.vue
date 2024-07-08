<template>
    <el-card class="user-card">
        <div class="user-info">
            <el-avatar :size="259" :shape="'circle'">
            <img :src="user.avatar" />
            </el-avatar>
            <div>
                <h1 class="user-name">{{ this.user.username}}</h1>
            </div>
        </div>
        <div class="custom-tabs">
          <el-tabs>
            <el-tab-pane label="修改密码">
                <el-form label-width="30px" router>
                    <el-form-item  prop="newPassword">
                        <el-input 
                        prefix-icon="el-icon-lock" 
                        placeholder = "新密码" 
                        type = "password" 
                        style="width: 400px;"
                        v-model="passwordForm.newPassword">
                    </el-input>
                    </el-form-item>
                    <el-form-item  prop="reNewPassword">
                        <el-input 
                        prefix-icon="el-icon-lock" 
                        type = "password" 
                        placeholder = "确认密码" 
                        style="width: 400px;" 
                        v-model="passwordForm.reNewPassword">
                        </el-input>
                    </el-form-item>
                    <el-form-item >
                        <el-button 
                        type = "primary" 
                        @click = "updatePassword()" 
                        style="width: 200px;"
                        >保存
                        </el-button>
                        <el-button 
                        @click = "cancel()" 
                        style="width: 200px;"
                        >取消
                        </el-button>
                    </el-form-item>
                </el-form>
            </el-tab-pane>
            <el-tab-pane label="修改头像">
                <el-upload 
                    ref="uploadRef"
                    class="avatar-uploader" 
                    :show-file-list="false"
                    :auto-upload="true"
                    action="/api/upload"
                    name="file"
                    :headers="{'Authorization': token}"
                    :on-success="uploadSuccess"
                    >
                    <img :src="imgUrl" class="avatar" style="width: 278px;"/>
                </el-upload>
                <br />
                <el-button type="primary" icon="el-icon-plus" size="large"  @click="chooseImg()" style="width: 200px">
                    选择图片
                </el-button>
                <br>
                <br>
                <el-button type="success" icon="el-icon-upload" size="large" @click="updateAvatar()" style="width: 200px">
                    上传头像
                </el-button>
            </el-tab-pane>
          </el-tabs>
        </div>
    </el-card>
</template>

<script>
import { mapGetters } from 'vuex';
import store from '@/store'
import axios from '@/utils/axios';
export default {
    computed: {
        ...mapGetters([
            'user',
            'starList',
            'avatar'
        ])
    },
    data() {
        return {
            passwordForm: {
                newPassword: "",
                reNewPassword: "",
            },
            imgUrl: '',
            token: store.state.token,
        }
    },
    methods: {
        cancel() {
            this.passwordForm.newPassword = "",
            this.passwordForm.reNewPassword = ""
        },
        updatePassword() {
            axios.put("/user/updatePassword", this.passwordForm).then(res => {
                if (res.data.code === 0) {
                    this.$message.success("修改成功");
                    this.cancel();
                } else {
                    this.$message.error("两次密码不一致！");
                }
            })
        },
        uploadSuccess(response) {
            this.imgUrl = `${response.data}`
        },
        chooseImg() {
            this.$refs.uploadRef.$el.querySelector('input').click()
        },
        async updateAvatar() {
            await axios.post("/user/updateAvatar", this.imgUrl).then(res => {
                if (res.data.code === 0) {
                    this.$store.commit("setUser", res.data.data);
                    this.$store.commit("setAvatar", res.data.data.avatar);
                    this.$message.success("头像上传成功~");
                } else {
                    this.$message.error("服务错误");
                }
            })
            this.$store.commit("setAvatar", this.imgUrl);
        }
    },
    created() {
        this.imgUrl = this.user.avatar || require('@/assets/img/avatar.jpg');
        if (this.imgUrl === null) {
            this.imgUrl = require('@/assets/img/avatar.jpg');
        }
    }
}
</script>

<style lang="scss">
.avatar-uploader {
    :deep() {
        .avatar {
            width: 178px;
            height: 178px;
            display: block;
        }

        .el-upload {
            border: 1px dashed var(--el-border-color);
            border-radius: 6px;
            cursor: pointer;
            position: relative;
            overflow: hidden;
            transition: var(--el-transition-duration-fast);
        }

        .el-upload:hover {
            border-color: var(--el-color-primary);
        }

        .el-icon.avatar-uploader-icon {
            font-size: 28px;
            color: #8c939d;
            width: 278px;
            height: 278px;
            text-align: center;
        }
    }
}
.user-info {
  display: flex;
}

.user-name {
  margin-left: 20px; 
  margin-bottom: 20px;
  font-size: 35px; 
}
</style>