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
                        v-model="newPassword" >
                        </el-input>
                    </el-form-item>
                    <el-form-item  prop="reNewPassword">
                        <el-input 
                        prefix-icon="el-icon-lock" 
                        type = "password" 
                        placeholder = "确认密码" 
                        style="width: 400px;" 
                        v-model="reNewPassword">
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
                    action="/upload"
                    name="file"
                    :headers="{'Authorization': token}"
                    :on-success="uploadSuccess"
                    >
                    <img v-if="imgUrl" :src="imgUrl" class="avatar" style="width: 278px;"/>
                    <img v-else :src="avatar" width="278" />
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
export default {
    computed: {
        ...mapGetters([
            'user',
            'starList',
        ])
    },
    data() {
        return {
            newPassword: '',
            reNewPassword: '',
            avatar: require('@/assets/img/default.png'),
            imgUrl: '',
            token: store.state.token,
        }
    },
    methods: {
        cancel() {
            this.newPassword = "",
            this.reNewPassword = ""
        },
        updatePassword() {
            alert("修改密码");
        },
        uploadSuccess(result) {
            this.imgUrl = result.data;
        },
        chooseImg() {
            console.log(this.token);
            this.$refs.uploadRef.$el.querySelector('input').click()
        }
    },
    created() {
        this.imgUrl = this.user.avatar || this.avatar;
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