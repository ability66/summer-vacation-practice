<template>
  <el-card class="box-card" style="height: 79vh">
    <div>
      <div id="stu_change" >
        <div class="empty"></div>
        <el-form ref="form" :model="form" label-width="200px">
          <el-form-item label="姓名">

            <el-input v-model="form.name" style="width: 70%;" placeholder="请输入内容" clearable></el-input>

          </el-form-item>
          <el-form-item label="学号">
            <el-input v-model="form.no" style="width: 70%;" placeholder="请输入内容" clearable></el-input>
          </el-form-item>
          <el-form-item label="班级">
            <el-input v-model="form.stu_class" style="width: 70%;" placeholder="请输入内容" clearable></el-input>
          </el-form-item>
          <el-form-item label="学院">
            <el-input v-model="form.college" style="width: 70%;" placeholder="请输入内容" clearable></el-input>
          </el-form-item>
          <el-form-item label="专业">
            <el-input v-model="form.major" style="width: 70%;" placeholder="请输入内容" clearable></el-input>
          </el-form-item>
          <el-form-item label="入学时间">
            <el-col :span="24">
              <el-date-picker type="date" placeholder="选择日期" v-model="form.date"
                              style="width: 70%;"></el-date-picker>
            </el-col>
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
export default {
  name: "student_info_change",
  data() {
    return {
      form: {
        name: '',
        no: '',
        date: '',
        stu_class: '',
        college:'',
        major:'',
      }
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
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