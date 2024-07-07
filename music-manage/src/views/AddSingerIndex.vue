<template>
  <div>
    <h1>新增歌手信息</h1>
    <form @submit.prevent="addSinger">
      <label for="name">姓名:</label>
      <input type="text" id="name" v-model="singer.name" required><br>
      
      <label for="gender">性别:</label>
      <select id="gender" v-model="singer.gender" required>
        <option value="male">男</option>
        <option value="female">女</option>
      </select><br>
      
      <label for="bio">个人简介:</label>
      <textarea id="bio" v-model="singer.bio" required></textarea><br>
      
      <label for="birthday">生日:</label>
      <input type="date" id="birthday" v-model="singer.birthday" required><br>
      
      <label for="address">地址:</label>
      <input type="text" id="address" v-model="singer.address" required><br>
      
      <label for="image">歌手头像:</label>
      <input type="file" id="image" @change="handleImageUpload"><br>
      
      <label for="songs">歌曲:</label>
      <input type="text" v-for="(song, index) in singer.songs" :key="index" v-model="singer.songs[index]" required><br>
      
      <button type="submit">提交</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      singer: {
        name: '',
        gender: 'male',
        bio: '',
        birthday: '',
        address: '',
        image: null,
        songs: []
      }
    };
  },
  methods: {
    addSinger() {
      // 实现保存歌手信息的逻辑，可以发送到后端API
      console.log(this.singer);
    },
    handleImageUpload(event) {
      const file = event.target.files[0];
      // 处理上传的图片文件
      console.log('上传图片:', file);
    }
  }
};
</script>

<style scoped>
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
}

h1 {
  text-align: center;
  color: #333;
}

form {
  margin-top: 20px;
}

label {
  font-weight: bold;
}

input, select, textarea {
  width: 100%;
  padding: 8px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  background-color: #007bff;
  color: #fff;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 4px;
}

button:hover {
  background-color: #0056b3;
}
</style>
