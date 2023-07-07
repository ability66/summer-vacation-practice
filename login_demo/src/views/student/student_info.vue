<template>
  <!--  <div class="container">-->
  <el-card class="box-card" style="height: 80vh">
    <div id="stu_info" class="output">
      <div class="empty"></div>
      <el-form ref="form" :model="form" label-width="200px">
        <div style="font-size: 20px">
          <el-form-item label="姓名">
            <el-input v-model="form.name" style="width: 70%;" disabled></el-input>
          </el-form-item>
          <el-form-item label="学号">
            <el-input v-model="form.no" style="width: 70%;" disabled></el-input>
          </el-form-item>
          <el-form-item label="班级">
            <el-input v-model="form.stu_class" style="width: 70%;" disabled></el-input>
          </el-form-item>
          <el-form-item label="学院">
            <el-input v-model="form.college" style="width: 70%;" disabled></el-input>
          </el-form-item>
          <el-form-item label="专业">
            <el-input v-model="form.major" style="width: 70%;" disabled></el-input>
          </el-form-item>
          <el-form-item label="入学时间">
            <el-col :span="24">
              <el-date-picker type="date" placeholder="选择日期" v-model="form.date"
                              style="width: 70%;" disabled></el-date-picker>
            </el-col>
          </el-form-item>
        </div>
      </el-form>
    </div>
  </el-card>
  <!--    <router-view></router-view>-->
  <!--  </div>-->
</template>

<script>
export default {
  name: "student_info_change",
  data() {
    return {
      form: {
        name: '张三',
        no: '123',
        date: '2023-05-03',
        stu_class: '2525',
        college: '计算机',
        major: '软件工程',
      }
    }
  },
  methods: {}
}
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