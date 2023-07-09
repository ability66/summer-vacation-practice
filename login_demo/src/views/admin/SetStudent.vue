<template>
  <el-card class="box-card" style="height: 79vh">
    <div>
      <div id="stu_change" >
        <div class="empty"></div>
        <el-form ref="form" :model="form" label-width="200px">
          <el-form-item label="姓名">
            <el-input v-model="form.stu_name" style="width: 70%;" placeholder="请输入内容" clearable></el-input>
          </el-form-item>
          <el-form-item label="学号">
            <el-input v-model="form.stu_no" style="width: 70%;" placeholder="请输入内容" clearable></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-input v-model="form.stu_sex" style="width: 70%;" placeholder="请输入内容" clearable></el-input>
          </el-form-item>
          <el-form-item label="班号">
            <el-input v-model="form.class_no" style="width: 70%;" placeholder="请输入内容" clearable></el-input>
          </el-form-item>
          <el-form-item label="专业">
            <el-input v-model="form.ter_no" style="width: 70%;" placeholder="请输入内容" clearable></el-input>
          </el-form-item>
          <el-form-item label="入学时间">
            <el-input v-model="form.stu_year" style="width: 70%;" placeholder="请输入内容" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">确定编辑</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </el-card>
</template>

<script>
import axios from 'axios';
import Cookies from 'js-cookie';

export default {
  stu_name: "student_info_change",
  data() {
    return {
      form: {
        stu_name: '',
        stu_sex: '',
        stu_year: '',
        ter_no:'',
        class_no:'',
      }
    }
  },
  methods: {
    onSubmit() {
      // 获取表单数据
      const formData = this.form;
      // 发送POST请求到服务器端API
      axios.post('http://localhost:8181/admin/setStudent', formData,{
        headers: {
            'Content-Type': 'application/json;charset=UTF-8'
          }
      })
        .then(response => {
          // 处理响应数据
          console.log('OKOK');
        })
        .catch(error => {
          // 处理错误
          console.error(error);
        });
    }
  }
}
</script>

<style scoped>
.container{
  width: 100%;
  height: 100%;
  /*background-color: #42b983;*/
  /*flex弹性布局*/
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-repeat: no-repeat;
  background-size: cover;
  background-color: blanchedalmond;
  user-scalable:yes;

}
.output{
  line-height: 40px;
  align-items: center;
  width: 70%;
  height: 70%;
  border-radius: 30px;
  overflow: hidden;/*圆角*/
  /*  background-color: #eeeeee;*/
  user-scalable:yes;
}
.empty{
  margin-top: 60px;
}
</style>