<template>
  <el-card class="box-card" style="height: 80vh">
    <el-upload
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :before-remove="beforeRemove"
        :limit="1"
        :on-exceed="handleExceed"
        :file-list="fileList"
        :before-upload="beforeUpload">
      <div>
        <div class="main"><i class="el-icon-warning"
                             style="font-size: 15px;">响应净网行动，严禁利用管理系统上传、传播色情暴力等违法内容，一经查处将冻结账号！</i>
        </div>
        <el-button type="primary"><i class="el-icon-upload" style="font-size: 25px;">点击上传报告</i></el-button>
      </div>
      <div slot="tip" class="el-upload__tip" style="font-size: 15px;">只能上传word文件，且不超过20MB</div>
    </el-upload>
  </el-card>
</template>

<script>
export default {
  name: "student_upload",
  data() {
    return {
      fileList: []
    };
  },
  methods: {
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
      return isWord && isLt20M;
    }
  }
}
</script>

<style scoped>

.main {
  margin-bottom: 20vh;
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
