<template>
  <el-card class="box-card" style="height: 79vh">
    <div style="position: relative;height: 100%">

      <div>
        <h3 style="font-size: 40px">查询学生信息</h3>
      </div>
      <div class="demo-input-wrapper">
        <span>请输入学生学号：</span>
        <el-input tag="input" placeholder="请输入内容" prefix-icon="el-icon-search" v-model="stu_no"></el-input>
        <el-button type="primary" @click="search">查询</el-button>
      </div>
      <el-table :data="tableData" STYLE="font-size: 18px;" height="555" >
        <el-table-column label="学号" width="150">
          <template slot-scope="scope">
            <span>{{ scope.row.stu_no }}</span>
          </template>
        </el-table-column>
        <el-table-column label="姓名" width="150">
          <template slot-scope="scope">
            <span>{{ scope.row.stu_name }}</span>
          </template>
        </el-table-column>
        <el-table-column label="性别" width="150">
          <template slot-scope="scope">
            <span>{{ scope.row.stu_sex }}</span>
          </template>
        </el-table-column>
        <el-table-column label="专业" width="150">
          <template slot-scope="scope">
            <span>{{ scope.row.ter_no }}</span>
          </template>
        </el-table-column>
        <el-table-column label="入学时间" width="150">
          <template slot-scope="scope">
            <span>{{ scope.row.stu_year }}</span>
          </template>
        </el-table-column>
        <!--        <el-table-column label="操作">-->
        <!--          <template slot-scope="scope">-->
        <!--            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->
        <!--          </template>-->
        <!--        </el-table-column>-->
      </el-table>

    </div>
  </el-card>
</template>

<style scoped>
/*#background{
    border:1px solid rgba(255, 2, 2, 0.979);
    margin-left: 3%;
    margin-right: 0px;
    height: 1000px;
    width: 94%;
}*/
/*.el-table{
    border:1px solid rgba(253, 228, 3, 0.979);
    width: 100%;
    margin-left: 0;
    margin-right: 1000px;
}*/
.demo-input-wrapper {
  display: flex;
  width: 70%;
}
.demo-input-wrapper span {
  /* border:1px solid rgba(253, 228, 3, 0.979);*/
  font-size: 25px;
  width:40vw;
  height: 38px;
}

</style>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      stu_no: '',
      tableData: [],
    };
  },
  methods: {
    getStudents() {
      console.log("getStudents")
      // 发送GET请求到服务器端API获取所有学生信息
      axios
          .post('http://localhost:8181/admin/getStudents')
          .then((response) => {
            // 处理响应数据
            this.tableData = response.data;
          })
          .catch((error) => {
            // 处理错误
            console.error(error);
          });
    },

    selectStudent(stuNo) {
      const stu_no = stuNo;
      // 发送POST请求到服务器端API查询学生信息
      axios
          .post('http://localhost:8181/admin/selectStudent', stu_no,{
            headers: {
              'Content-Type': 'application/json;charset=UTF-8'
            }
          })
          .then((response) => {
            // 处理响应数据
            this.tableData = [];
            this.tableData[0] = response.data;

            console.log(response.data);
            console.log(this.tableData);
          })
          .catch((error) => {
            // 处理错误
            console.error(error);
          });
    },
    search() {
      console.log("search");
      // 获取学生学号
      const stuNo = this.stu_no;

      if (stuNo) {
        // 如果输入了学号，则调用selectStudent方法查询学生信息
        this.selectStudent(stuNo);

      } else {
        // 否则调用getStudents方法获取所有学生信息
        this.getStudents();
      }

    },
  },
  created() {
    // 组件创建后调用getStudents方法获取所有学生信息
    console.log("created")
    this.getStudents();
  },
};

</script>