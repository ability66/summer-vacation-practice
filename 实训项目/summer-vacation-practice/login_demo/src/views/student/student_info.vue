<template>
  <!--  <div class="container">-->
  <el-card class="box-card" style="height: 79vh">
    <div id="stu_info" class="output">
      <div class="empty"></div>
      <el-form ref="form" :model="form" label-width="200px">
        <div style="font-size: 20px">
          <el-form-item label="姓名">
            <el-input v-model="form.stu_name" style="width: 70%;" disabled></el-input>
          </el-form-item>
          <el-form-item label="学号">
            <el-input v-model="form.stu_no" style="width: 70%;" disabled></el-input>
          </el-form-item>
          <el-form-item label="专业">
            <el-input v-model="form.ter_no" style="width: 70%;" disabled></el-input>
          </el-form-item>
          <el-form-item label="入学时间">
            <el-input v-model="form.stu_year" style="width: 70%;" disabled></el-input>
          </el-form-item>
        </div>
      </el-form>
    </div>
  </el-card>
  <!--    <router-view></router-view>-->
  <!--  </div>-->
</template>

<script>
import axios from 'axios';
import Cookies from 'js-cookie';

export default {
  data() {
    return {
      form: {
        stu_name: '',
        stu_no: '',
        ter_no: '',//专业号
        stu_year: '',
      }
    };
  },
  methods: {
    getStudentInfo() {
      const stu_no = Cookies.get('userId'); // 要请求的学生学号
      console.log("学生信息");
      axios.post('http://localhost:8181/student/getMessage', stu_no,{
        headers: {
          'Content-Type': 'application/json;charset=UTF-8'
        }
      })
        .then(response => {
          console.log("response_data");
          this.form.stu_name = response.data.stu_name;
          this.form.stu_no = response.data.stu_no;
          this.form.stu_year = response.data.stu_year;
          console.log(this.form.stu_year);
          this.form.ter_no = response.data.ter_no;
        })
        .catch(error => {
          console.error(error);
        });
    }
  },
  mounted() {
    this.getStudentInfo();
  },
};
</script>

<style scoped>
/*.output{
  line-height: 40px;
  align-items: center;
  width: 90%;
  height: 90%;
  border-radius: 30px;
  overflow: hidden;!*圆角*!
  background-color: #eeeeee;
  user-scalable:yes;
}*/
.empty {
  margin-top: 10vh;
}
</style>