<!-- <template>
  <el-card class="box-card" style="height: 80vh;" >
    <div class="main"><i class="el-icon-warning" style="font-size: 15px;">响应净网行动，严禁利用管理系统上传、传播色情暴力等违法内容，一经查处将冻结账号！</i>
    </div>
    <el-upload class="upload-demo" action='http://localhost:8181/student/upload' :on-preview="handlePreview"
      :on-remove="handleRemove" :before-remove="beforeRemove" :limit="1" :on-exceed="handleExceed" :file-list="fileList"
      :before-upload="beforeUpload">
      <div>

        <div class="select">
          <el-select v-model="value9" filterable remote reserve-keyword clearable placeholder="请选择任课导师"
            :remote-method="remoteMethod" :loading="loading">
            <el-option v-for="teacher in states" :key="teacher.tea_no" :label="teacher.tea_name" :value="teacher.tea_no">
            </el-option>
          </el-select>
        </div>
        <el-button type="primary" @click="uploadFileToBackend"><i class="el-icon-upload"
            style="font-size: 25px;">点击上传报告</i></el-button>
      </div>
      <div slot="tip" class="el-upload__tip" style="font-size: 15px;">只能上传word文件，且不超过20MB</div>
    </el-upload>
  </el-card>
</template> -->
<template>
  <el-card class="box-card" style="height: 80vh;" >
    <div class="main"><i class="el-icon-warning" style="font-size: 15px;">响应净网行动，严禁利用管理系统上传、传播色情暴力等违法内容，一经查处将冻结账号！</i>
    </div>
    <div class="centered-container">
      <el-upload class="upload-demo" action='http://localhost:8181/student/upload' :on-preview="handlePreview"
        :on-remove="handleRemove" :before-remove="beforeRemove" :limit="1" :on-exceed="handleExceed" :file-list="fileList"
        :before-upload="beforeUpload">
        <div class="centered-content">
          <div class="select">
            <el-select v-model="value9" filterable remote reserve-keyword clearable placeholder="请选择任课导师"
              :remote-method="remoteMethod" :loading="loading">
              <el-option v-for="teacher in states" :key="teacher.tea_no" :label="teacher.tea_name" :value="teacher.tea_no">
              </el-option>
            </el-select>
          </div>
          <el-button type="primary" @click="uploadFileToBackend"><i class="el-icon-upload"
              style="font-size: 25px;">点击上传报告</i></el-button>
        </div>
        <div slot="tip" class="el-upload__tip" style="font-size: 15px;">只能上传word文件，且不超过20MB</div>
      </el-upload>
    </div>
  </el-card>
</template>

<style>
.centered-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.centered-content {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>

<script>
import axios from 'axios';
import Cookies from 'js-cookie';
export default {
  name: "student_upload",
  data() {
    return {
      form: new FormData(),
      fileList: [],//文件上传
      uploadfile: null,
      uploadUrl: 'localhost:8181/student/upload',
      /*------------------------------选择导师*/
      options4: [],
      value9: 0,//最终向后端提交的教师名
      list: [],
      loading: false,
      states: []//模拟从后端获取数据
      // ---------------------------------
    };
  },
  methods:
  // -----------------------------------文件上传
  {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },
    beforeUpload(file) {
      const isWord = file.name.endsWith('.doc') || file.name.endsWith('.docx');
      const isLt20M = file.size / 1024 / 1024 < 20;
      if (!isWord) {
        this.$message.error('上传文件只能是 word 格式!');
      }
      if (!isLt20M) {
        this.$message.error('上传文件大小不能超过 20MB!');
      }
      this.uploadfile = file;

      const formData = new FormData();
      formData.append('file', file);
      formData.append('stu_no', Cookies.get('userId'));
      formData.append('tea_no', this.value9);
      for (const pair of formData.entries()) {
        console.log(pair[0] + ': ' + pair[1]);
      }
      this.form = formData;

      return isWord && isLt20M;
    },
    // ------------------------------------
    handleSelect(value) {
      // 通过教师姓名获取对应的教师工号
      const selectedTeacher = this.states.find(teacher => teacher.tea_name === value);
      const number = selectedTeacher ? selectedTeacher.tea_no : '';
      console.log(number);
    },

    // -------------------------------------搜索
    remoteMethod(query) {
      if (query !== '') {
        this.loading = true;
        setTimeout(() => {
          this.loading = false;
          this.options4 = this.list.filter(item => {
            return item.label.toLowerCase()
              .indexOf(query.toLowerCase()) > -1;
          });
        }, 200);
      } else {
        this.options4 = [];
      }
    }
  },
  mounted() {
    // 发送 HTTP 请求获取教师数据
    axios.post('http://localhost:8181/student/getTeachers')
      .then(response => {
        // 将返回的教师数据转换为包含教师姓名和工号的数组
        const teacherData = response.data.map(teacher => ({
          // teacher.number: tea_no,
          // teacher.name:tea_name,
          tea_no: teacher.tea_no,
          tea_name: teacher.tea_name,
        }));
        // 将教师姓名和工号的数组赋值给 states[]
        this.states = teacherData;
        console.log(this.states);
      })
      .catch(error => {
        // 处理请求失败的逻辑
      });
  },
  uploadFileToBackend() {
    // 创建一个FormData对象
    const formData = new FormData();
    // 将文件对象添加到formData中
    formData.append('file', this.uploadFile);
    formData.append('stu_no', Cookies.get(userId));
    formData.append('tea_no', this.value9);

    // 使用axios或其他网络请求库发送异步请求
    axios.post('http://localhost:8181/student/upload', formData)
      .then(response => {
        // 请求成功的处理逻辑
        console.log(response);
      })
      .catch(error => {
        // 请求失败的处理逻辑
        console.error(error);
      });
  }
  // --------------------------------------
}
</script>

<style scoped>
.main {
  margin-bottom: 20vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.select {
  margin-bottom: 15vh;
}
</style>
<!--
后端应用程序可以通过 HTTP 请求中的 multipart/form-data 类型的请求体来获取上传的文件。具体实现方式取决于你使用的后端开发语言和框架。

例如，如果你使用 Node.js 和 Express 框架，你可以使用 multer 中间件来处理文件上传：

const express = require('express');
const multer  = require('multer');
const upload = multer({ dest: 'uploads/' });

const app = express();

app.post('/upload', upload.single('file'), (req, res) => {
console.log(req.file);
res.send('File uploaded!');
});

app.listen(3000);
复制
上面的代码定义了一个名为 /upload 的接口，用于处理文件上传。multer 中间件会将上传的文件保存在服务器的 uploads 目录下，并将文件信息添加到 req.file 属性中。

不同的后端开发语言和框架可能有不同的实现方式，你可以查阅相关文档了解更多信息-->
