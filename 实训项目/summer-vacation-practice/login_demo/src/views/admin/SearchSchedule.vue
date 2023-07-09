<template>
  <el-card class="box-card" style="height: 79vh">
    <div style="position: relative;height: 100%">

      <div style="font-size: 35px">
        查询课表信息
      </div>
      <div class="demo-input-wrapper">
        <span>请输入班号：</span>
        <el-input tag="input" placeholder="请输入内容" prefix-icon="el-icon-search" v-model="input2"></el-input>
        <el-button type="primary" @click="search">查询</el-button>
      </div>
      <div class="output">
        <el-table :data="tableData" style="width: 100%;font-size: 20px;">
          <el-table-column prop="time" label=""></el-table-column>
          <el-table-column prop="monday" label="星期一"></el-table-column>
          <el-table-column prop="tuesday" label="星期二"></el-table-column>
          <el-table-column prop="wednesday" label="星期三"></el-table-column>
          <el-table-column prop="thursday" label="星期四"></el-table-column>
          <el-table-column prop="friday" label="星期五"></el-table-column>
        </el-table>
      </div>



    </div>
  </el-card>
</template>

<style scoped>

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
        },{
          time: '9:00-10:00',
          monday: '数学',
          tuesday: '英语',
          wednesday: '物理',
          thursday: '化学',
          friday: '生物'
        },{
          time: '9:00-10:00',
          monday: '数学',
          tuesday: '英语',
          wednesday: '物理',
          thursday: '化学',
          friday: '生物'
        },{
          time: '9:00-10:00',
          monday: '数学',
          tuesday: '英语',
          wednesday: '物理',
          thursday: '化学',
          friday: '生物'
        },{
          time: '9:00-10:00',
          monday: '数学',
          tuesday: '英语',
          wednesday: '物理',
          thursday: '化学',
          friday: '生物'
        },{
          time: '9:00-10:00',
          monday: '数学',
          tuesday: '英语',
          wednesday: '物理',
          thursday: '化学',
          friday: '生物'
        },{
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