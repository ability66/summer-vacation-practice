<template>
  <el-card class="box-card" style="height: 79vh">
    <div>
      <div id="stu_change" >
        <div class="empty"></div>
        <el-form ref="form" :model="form" label-width="200px">
          <el-form-item label="班号">
            <el-input v-model="form.cla" style="width: 70%;" placeholder="请输入内容" clearable></el-input>
          </el-form-item>
          <el-form-item label="时间">
          <el-select v-model="form.weekday" placeholder="请选择时间" style="width: 70%">
            <el-option label="星期一" value="monday"></el-option>
            <el-option label="星期二" value="tuesday"></el-option>
            <el-option label="星期三" value="wednesday"></el-option>
            <el-option label="星期四" value="thursday"></el-option>
            <el-option label="星期五" value="friday"></el-option>
          </el-select>
          </el-form-item>
          <el-form-item label="节次">
            <el-select v-model="form.time" placeholder="请选择时间" style="width: 70%">
              <el-option label="第一节" value="1"></el-option>
              <el-option label="第二节" value="2"></el-option>
              <el-option label="第三节" value="3"></el-option>
              <el-option label="第四节" value="4"></el-option>
              <el-option label="第五节" value="5"></el-option>
              <el-option label="第六节" value="6"></el-option>
              <el-option label="第七节" value="7"></el-option>
              <el-option label="第八节" value="8"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="课程">
            <el-select
                v-model="value9"
                filterable
                remote
                reserve-keyword
                clearable
                placeholder="请选择课程"
                :remote-method="remoteMethod"
                :loading="loading"
                style="width:70%"
            >
              <el-option
                  v-for="item in options4"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                  style="width: 70%">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">确定编辑</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </el-card>
</template>

<script>
export default {
  name: "student_info_change",
  data() {
    return {
      form: {
        name: '',
        no: '',
        date: '',
        cla: '',
        college:'',
        major:'',
      },





      // -----------------------选择课程
      options4: [],
      value9: [],//最终向后端提交的教师名
      list: [],
      loading: false,
      states: ["Alabama", "Alaska", "Arizona",
        "Arkansas", "California", "Colorado",
        "Connecticut", "Delaware", "Florida",
        "Georgia", "Hawaii", "Idaho", "Illinois",
        "Indiana", "Iowa", "Kansas", "Kentucky",
        "Louisiana", "Maine", "Maryland",
        "Massachusetts", "Michigan", "Minnesota",
        "Mississippi", "Missouri", "Montana",
        "Nebraska", "Nevada", "New Hampshire",
        "New Jersey", "New Mexico", "New York",
        "North Carolina", "North Dakota", "Ohio",
        "Oklahoma", "Oregon", "Pennsylvania",
        "Rhode Island", "South Carolina",
        "South Dakota", "Tennessee", "Texas",
        "Utah", "Vermont", "Virginia",
        "Washington", "West Virginia", "Wisconsin",
        "Wyoming"]//模拟从后端获取数据
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    },




    // -------------------------------------选择课程
    remoteMethod(query) {
      if (query !== '') {
        this.loading = true;
        setTimeout(() => {
          this.loading = false;
          this.options4 = this.list.filter(item => {
            return item.label.toLowerCase()
                .indexOf(query.toLowerCase()) > -1;
          });
        }, 200);
      } else {
        this.options4 = [];
      }
    }
  },
  mounted() {
    this.list = this.states.map(item => {
      return {value: item, label: item};
    });
  }
  // ---------------------------------------
}
</script>

<style scoped>
.container{
  width: 100%;
  height: 100%;
  /*background-color: #42b983;*/
  /*flex弹性布局*/
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-repeat: no-repeat;
  background-size: cover;
  background-color: blanchedalmond;
  user-scalable:yes;

}
.output{
  line-height: 40px;
  align-items: center;
  width: 70%;
  height: 70%;
  border-radius: 30px;
  overflow: hidden;/*圆角*/
  /*  background-color: #eeeeee;*/
  user-scalable:yes;
}
.empty{
  margin-top: 60px;
}
</style>