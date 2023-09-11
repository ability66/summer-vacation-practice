<template>
  <!--  <div id="stu_course" class="container">
      <div class="output">-->
  <el-card class="box-card" style="height: 79vh">
    <el-table :data="tableData" style="width: 100%;font-size: 20px;">
      <el-table-column prop="time" label=""></el-table-column>
      <el-table-column prop="monday" label="星期一"></el-table-column>
      <el-table-column prop="tuesday" label="星期二"></el-table-column>
      <el-table-column prop="wednesday" label="星期三"></el-table-column>
      <el-table-column prop="thursday" label="星期四"></el-table-column>
      <el-table-column prop="friday" label="星期五"></el-table-column>
    </el-table>
  </el-card>
  <!--    </div>
    </div>-->
</template>

<script>
import axios from 'axios';
import Cookies from 'js-cookie';
export default {
  data() {
    return {
      tableData:[
        // {
        //   time: '8:00-9:00',
        //   monday: '1',
        //   tuesday: '2',
        //   wednesday: '3',
        //   thursday: '4',
        //   friday: '5'
        // },
        // {
        //   time: '9:00-10:00',
        //   monday: '1',
        //   tuesday: '2',
        //   wednesday: '3',
        //   thursday: '4',
        //   friday: '5'
        // }
      ]
       // 用于存储学生成绩的数组
    };
  },
  mounted() {
    this.getGrades(); // 在页面加载完成后自动调用获取成绩的方法
  },
  methods: {
    getGrades() {
      console.log("学生课表")
      const stu_no = Cookies.get('userId');; // 要请求的学生学号
          // 映射表，将中文的星期几转换为英文属性名
    const weekdayMap = {
      "周一": "monday",
      "周二": "tuesday",
      "周三": "wednesday",
      "周四": "thursday",
      "周五": "friday"
    };
      // 发送请求获取学生成绩
      axios.post('http://localhost:8181/student/getClassTable', stu_no,{
        headers: {
          'Content-Type': 'application/json;charset=UTF-8'
        }
      })
        .then(response => {
          console.log(response.data);
          this.tableData = response.data.map(
            item=>(
              {
                time: `第${item.class_order}节`,
          [weekdayMap[item.class_weekday]]: item.sub_no // 使用映射表设置属性名
              }
            )
          );
        })
        .catch(error => {
          console.error(error);
        });
        console.log(this.grades);
    }
  }
};
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