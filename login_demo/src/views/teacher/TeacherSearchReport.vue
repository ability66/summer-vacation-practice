<template>
  <div class="box-card" style="height: 80vh">
    <div style="text-align: left">
      <el-breadcrumb separator-class="el-icon-arrow-right" class="el-icon">
        <el-breadcrumb-item>首页</el-breadcrumb-item>
        <el-breadcrumb-item>教师查询</el-breadcrumb-item>
        <el-breadcrumb-item>查询报告</el-breadcrumb-item>
      </el-breadcrumb>

      <el-form ref="form" :model="form" label-width="80px" :inline="true" style="text-align: left">
        <el-form-item label="学号: ">
          <el-input style="width: 250px" v-model="stu_no"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search">搜索</el-button>
        </el-form-item>
      </el-form>
    </div>
    <!-- 放置报告内容，没写 -->

    <!--    <el-form
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
        </el-form>-->

    <el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleCurrentChange" border
      height="50vh" max-width="70%">
      <el-table-column align="center" type="index" width="50">
      </el-table-column>
      <el-table-column align="center" property="stu_no" label="学生学号" width="270">
      </el-table-column>
      <el-table-column align="center" property="tea_no" label="教师工号" width="270">
      </el-table-column>
      <el-table-column align="center" property="re_location" label="文件地址" width="270">
      </el-table-column>
      <el-table-column align="center" property="upload_date" label="上传时间">
      </el-table-column>
    </el-table>
    <div style="margin-top: 20px;"></div>
      <el-button @click="setCurrent()" style="margin-right: 50vw">取消选择</el-button>
      <div>
    <h2>查重结果</h2>
    <ul>
      <li v-for="(item, index) in result" :key="index">
        <p>文件名：{{ item.fileName }}</p>
        <p>学号：{{ item.stuNO }}</p>
        <p>查重结果：{{ item.result }}</p>
      </li>
    </ul>
  </div>
</div>
</template>
<script>
import axios from 'axios';
import Cookies from 'js-cookie';

export default {
  name: "SearchTeacher",
  data() {
    return {
      stu_no: '',
      tableData: [],
      currentRow: null,
      result: [],
      requestData:[]
    }
  },
  methods: {
    //根据re_no查询报告
    search() {
      console.log("search report");

      if (this.stu_no) {
        // 如果输入了学号，则调用selectStudent方法查询学生信息
        this.getReportByStu(this.stu_no);

      } else {
        // 否则调用getStudents方法获取所有学生信息
        this.getReport();
      }

    },
    getReportByStu(stu_no) {
      axios
        .post("http://localhost:8181/teacher/getReportByStu", {
          stu_no: stu_no,
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
          console.log(err);
        });
    },
    getReport() {
      console.log("get report");
      axios
        .post("http://localhost:8181/teacher/getReport",
          Cookies.get("userId")
          ,
          {
            headers: {
              "Content-Type": "application/json;charset=UTF-8"
            }
          }
        )
        .then(res => {
          this.tableData = res.data;
        })
        .catch(err => {
          console.log(err);
        });
    },

    setCurrent(row) {
      this.$refs.singleTable.setCurrentRow(row);
    },
    handleCurrentChange(val) {//该函数进行选择后的操作
      this.currentRow = val;
      if (val != null) {
        this.$confirm('对该报告进行查重, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          const requestData = {
            stu_no: this.currentRow.stu_no,
            tea_no: Cookies.get("userId")
          };
          axios
            .post("http://localhost:8181/teacher/checkReport",requestData, {
              headers: {
                "Content-Type": "application/json;charset=UTF-8"
              }
            })
            .then(res => {
              console.log("点击确定");
              this.result = res.data;
              console.log(this.result);
            })
            .catch(err => {
              console.log(err);
            });
        }).catch(() => {

        });
      }
    },
  },
  created() {
    // 组件创建后调用getStudents方法获取所有学生信息
    this.getReport();
  },
};
</script>
<style>
.el-icon {
  margin-top: 15px;
  margin-bottom: 15px;
  font-size: 15px;
}
</style>