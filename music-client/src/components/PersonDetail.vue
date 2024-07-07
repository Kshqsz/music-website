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
            </el-tab-pane>
          </el-tabs>
        </div>
    </el-card>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
    data() {
        return {
            newPassword: '',
            reNewPassword: ''
        }
    },
    computed: {
        ...mapGetters([
            'user',
            'starList'
        ])
    },
    methods: {
        cancel() {
            this.newPassword = "",
            this.reNewPassword = ""
        },
        updatePassword() {
            alert("修改密码");
        }
    }
}
</script>

<style>
.user-info {
  display: flex;
}

.user-name {
  margin-left: 20px; 
  margin-bottom: 20px;
  font-size: 35px; 
}
</style>