<template>
  <div class="container-TeacherSearchStudent">
    <el-breadcrumb separator-class="el-icon-arrow-right" class="el-icon">
      <el-breadcrumb-item :to="{ path: '/Admin' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>教师查询</el-breadcrumb-item>
      <el-breadcrumb-item>学生查询</el-breadcrumb-item>
    </el-breadcrumb>

    <el-form
      ref="form"
      :model="form"
      label-width="80px"
      :inline="true"
      style="text-align: left"
    >
      <el-form-item label="学生学号: ">
        <el-input style="width: 250px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary">查询</el-button>
      </el-form-item>
    </el-form>

    <el-form
      ref="form"
      :model="form"
      label-width="80px"
      :inline="true"
      style="text-align: left;"
    >
      <el-form-item label="姓名 ">
        <el-input
          v-model="form.name"
          style="width: 250px"
          :disabled="true"
        ></el-input>
      </el-form-item>
      <el-form-item label="学号 ">
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
      <el-form-item label="班级 ">
        <el-input
          v-model="form.classno"
          style="width: 250px"
          :disabled="true"
        ></el-input>
      </el-form-item>
      <el-form-item label="学院 ">
        <el-input
          v-model="form.academyname"
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
      <el-form-item label="专业 ">
        <el-input
          v-model="form.majorname"
          style="width: 250px"
          :disabled="true"
        ></el-input>
      </el-form-item>
      <el-form-item label="入学年 ">
        <el-date-picker
          v-model="value1"
          type="date"
          placeholder="入学年"
          :disabled="true"
          style="text-align: left;
          width: 250px;"
        ></el-date-picker>
      </el-form-item>
    </el-form>
  </div>
</template>
  <script>
export default {
  name: "SearchTeacher",
  data() {
    return {
      form: {
        name: "",
        workno: "",
        classno: "",
        academyno: "",
        majorname: "",
        enrollyear: "",
      },
    };
  },
};
</script>
  <style>
.container-TeacherSearchStudent {
  height: 100%;
  background-color: #fff;
}
.el-icon {
  margin-top: 15px;
  margin-bottom: 15px;
  font-size: 15px;
}
</style>