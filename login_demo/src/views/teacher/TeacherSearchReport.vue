<template>
  <el-card class="box-card" style="height: 80vh">
  <div class="container-SearchTeacher" style="text-align: left">
    <el-breadcrumb separator-class="el-icon-arrow-right" class="el-icon">
      <el-breadcrumb-item :to="{ path: '/Admin' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>教师查询</el-breadcrumb-item>
      <el-breadcrumb-item>查询报告</el-breadcrumb-item>
    </el-breadcrumb>

    <el-form
      ref="form"
      :model="form"
      label-width="80px"
      :inline="true"
      style="text-align: left"
    >
      <el-form-item label="报告名称: ">
        <el-input style="width: 250px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary">搜索</el-button>
      </el-form-item>
    </el-form>
    <div
      style="
        height: 40vh;
        width: 1000px;
        background-color: #5de051;
        border-radius: 15px;
        overflow: hidden;
        border: 1px;
        margin-bottom: 15px;
      "
    >
      <!-- 放置报告内容，没写 -->
    </div>
    <el-form
      ref="form"
      :model="form"
      label-width="80px"
      :inline="true"
      style="text-align: left"
    >
      <el-form-item style="margin-left: 444px;">
        <el-button type="primary" style="margin-right: 25px;">查重</el-button>
        <span style="font-size: 20px;">查重率:</span>
      </el-form-item>
    </el-form>
  </div>
  </el-card>
</template>
    <script>
export default {
  name: "SearchTeacher",
  data() {
    return {
      input: "",
    };
  },
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
</style>