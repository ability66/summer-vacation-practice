<template>
  <el-card class="box-card" style="height: 80vh;position: relative">
    <div class="container-SearchTeacher" style="text-align: left">
      <el-breadcrumb separator-class="el-icon-arrow-right" class="el-icon">
        <el-breadcrumb-item>首页</el-breadcrumb-item>
        <el-breadcrumb-item>教师查询</el-breadcrumb-item>
        <el-breadcrumb-item>成绩设置</el-breadcrumb-item>
      </el-breadcrumb>

      <!-- <el-form ref="form" :model="form" label-width="80px" :inline="true" style="text-align: left">
        <el-form-item label="课程名: ">
          <el-input  style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search">搜索</el-button>
        </el-form-item>
      </el-form> -->

      <el-table :data="tableData" border style="width: 75vw">
        <el-table-column fixed prop="stu_no" label="学号" width="500">
      </el-table-column>
      <el-table-column prop="sub_no" label="学科号" width="500" aria-posinset="center"> </el-table-column>
      <el-table-column prop="grade" label="得分" width="500"> </el-table-column>
        <!-- <el-table-column fixed="right" label="操作" width="250">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>

        </el-table-column> -->
      </el-table>
    </div>
  </el-card>
</template>
<script>
import axios from 'axios';
import Cookies from 'js-cookie';
export default {
  data() {
    return {
      form:'',
      tableData: []
    };
  },
  mounted() {
    this.getStudentInfo();
  },
  methods: {
    search() {
      console.log("search grade");

      if (this.sub_no) {
        // 如果输入了学号，则调用selectStudent方法查询学生信息
        this.getReportByStu(this.stu_no);

      } else {
        // 否则调用getStudents方法获取所有学生信息
        this.getReport();
      }

    },
    getStudentInfo() {
      const tea_no = Cookies.get('userId');
      axios.post('http://localhost:8181/teacher/getStudent' ,{
          tea_no: Cookies.get("userId")
        }, {
          headers: {
            "Content-Type": "application/json;charset=UTF-8"
          }
        })
        .then(res => {
          this.tableData = res.data;
        })
        .catch(err => {
          console.error(err);
        });
    },
    handleEdit(row) {
      // 处理编辑逻辑
      console.log("编辑学生信息", row);
    }
  }
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