<template>
  <div class="container-SearchTeacher" style="text-align: left">
    <el-breadcrumb separator-class="el-icon-arrow-right" class="el-icon">
      <el-breadcrumb-item :to="{ path: '/Admin' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>教师查询</el-breadcrumb-item>
      <el-breadcrumb-item>成绩设置</el-breadcrumb-item>
    </el-breadcrumb>

    <el-form
      ref="form"
      :model="form"
      label-width="80px"
      :inline="true"
      style="text-align: left"
    >
      <el-form-item label="课程名: ">
        <el-input style="width: 250px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary">搜索</el-button>
      </el-form-item>
    </el-form>

    <el-table :data="tableData" border style="width: 725px">
      <el-table-column fixed prop="stuno" label="学号" width="180">
      </el-table-column>
      <el-table-column prop="name" label="姓名" width="180"> </el-table-column>
      <el-table-column prop="score" label="得分" width="180"> </el-table-column>
      <el-table-column fixed="right" label="操作" width="180">
        <template>
          <!-- <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button> -->
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
      <script>
export default {
  name: "SearchTeacher",
  data() {
    return {
      input: "",
      tableData: [
        {
          stuno: "10086",
          name: "张三",
          score: "90",
        },
      ],
    };
  },
};
</script>
      <style>
.container-SearchTeacher {
  height: 100%;
  background-color: #fff;
}
.el-icon {
  margin-top: 15px;
  margin-bottom: 15px;
  font-size: 15px;
}
</style>