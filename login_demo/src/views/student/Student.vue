<template>
  <div>
    <el-container style="height: 95vh; border: 1px solid #eee;">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <div id="logo">
          LOGO
        </div>
        <el-col :span="12">
          <el-menu
              default-active="1"
              default-openeds="[1]"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>学生系统</span>
              </template>
              <el-menu-item index="/student_info">
                <router-link tag="span" id="text" to="/student/student_info">个人信息</router-link>
              </el-menu-item>
              <el-menu-item index="/student_score">
                <router-link tag="span" id="text" to="/student/student_score">成绩查询</router-link>
              </el-menu-item>
              <el-menu-item index="/student_course">
                <router-link tag="span" id="text" to="/student/student_course">课表查询</router-link>
              </el-menu-item>
              <el-menu-item index="/student_upload">
                <router-link tag="span" id="text" to="/student/student_upload">报告上传</router-link>
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-col>
      </el-aside>
      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>王小虎</span>
        </el-header>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "tes",
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}

</script>

<style scoped>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-col-12 {
  width: 100%;
}

#logo {
  height: 60px;
  line-height: 60px;
  font-size: 20px;
  text-align: center;
  color: #5de051;
}
</style>