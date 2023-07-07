<template>
  <!--  <div id="stu_course" class="container">
      <div class="output">-->
  <el-card class="box-card" style="height: 80vh">
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
export default {
  name: "student_course",
  data() {
    return {
      tableData: [
        {
          time: '8:00-9:00',
          monday: '语文',
          tuesday: '数学',
          wednesday: '英语',
          thursday: '物理',
          friday: '化学'
        },
        {
          time: '9:00-10:00',
          monday: '数学',
          tuesday: '英语',
          wednesday: '物理',
          thursday: '化学',
          friday: '生物'
        },
        // 更多课程数据...
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