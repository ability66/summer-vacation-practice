<template>
  <el-card class="box-card" style="height: 80vh">
    <el-table
        :data="tableData3"
        height="522"
        border
        style="width: 100%;/*font-size: 20px;*/">
      <el-table-column
          align="center"
          prop="course_no"
          label="课程号"
          width="300">
      </el-table-column>
      <el-table-column
          align="center"
          prop="course_name"
          label="课程名"
          width="300">
      </el-table-column>
      <el-table-column
          align="center"
          prop="score"
          label="成绩">
      </el-table-column>
    </el-table>
  </el-card>
</template>

<script>
export default {
  name: "student_score",
  data() {
    return {
      tableData3: [{
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }, {
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }, {
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }, {
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }, {
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }, {
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }, {
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }, {
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }, {
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }, {
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }, {
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }, {
        course_no: '2016-05-03',
        course_name: '王小虎',
        score: '上海市普陀区金沙江路 1518 弄'
      }
      ]
    }
  }
}
</script>

<style scoped>
.container {
  width: 100%;
  height: 100%;
  /*background-color: #42b983;*/
  /*flex弹性布局*/
  display: flex;
  justify-content: center;
  align-items: center;
  background-repeat: no-repeat;
  background-size: cover;
  background-color: blanchedalmond;
}

.output {
  align-items: center;
  width: 70vw;
  height: 70vh;
  border-radius: 30px;
  overflow: hidden; /*圆角*/
  background-color: #eeeeee;
}

</style>