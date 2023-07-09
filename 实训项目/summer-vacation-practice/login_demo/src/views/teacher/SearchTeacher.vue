<template>
  <el-card class="box-card" style="height: 80vh">
  <div class="container-SearchTeacher">
    <el-breadcrumb separator-class="el-icon-arrow-right" class="el-icon">
      <el-breadcrumb-item>首页</el-breadcrumb-item>
      <el-breadcrumb-item>教师查询</el-breadcrumb-item>
      <el-breadcrumb-item>个人信息</el-breadcrumb-item>
    </el-breadcrumb>
<div class="info">
    <el-form
      ref="form"
      :model="form"
      label-width="80px"
      :inline="true"
      style="text-align: left"
    >
      <el-form-item label="姓名 ">
        <el-input
          v-model="form.name"
          style="width: 250px"
          :disabled="true"
        ></el-input>
      </el-form-item>
      <el-form-item label="工号 ">
        <el-input
          v-model="form.workno"
          style="width: 250px"
          :disabled="true"
        ></el-input>
      </el-form-item>
    </el-form>
    <el-form
      ref="form"
      :model="form"
      label-width="80px"
      :inline="true"
      style="text-align: left"
    >
      <el-form-item label="学院号 ">
        <el-input
          v-model="form.academyno"
          style="width: 250px"
          :disabled="true"
        ></el-input>
      </el-form-item>
      <el-form-item label="职称 ">
        <el-input
          v-model="form.positionname"
          style="width: 250px"
          :disabled="true"
        ></el-input>
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
  name: "SearchTeacher",
  data() {
    return {
      form: {
        name: "",
        workno: "",
        academyno: "",
        positionname: "",
      },
    };
  },
  methods:{
    getTeacherInfo(){
      console.log("getTeacherInfo");
      const workno = Cookies.get('userId');
      axios.post('http://localhost:8181/teacher/getMessage',workno,{
        headers: {
          'Content-Type': 'application/json;charset=UTF-8'
        }
      })
        .then(response => {
          this.form.name = response.data.tea_name;
          this.form.workno = response.data.tea_no;
          this.form.academyno = response.data.tea_col_no;
          this.form.positionname = response.data.tea_level;
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  created() {
    this.getTeacherInfo();
  }
  ,
mounted(){
  this.getTeacherInfo();
}
};
</script>
  <style>
.container-SearchTeacher {
  /*height: 100%;*/
  background-color: #fff;
}
.el-icon {
  margin-top: 15px;
  margin-bottom: 15px;
  font-size: 15px;
}
.info{
  margin-top: 13vh;
  display: flex;
  align-items: center;
}
</style>