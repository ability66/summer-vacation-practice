<template>
  <div>
    <el-container style="height: 97vh; border: 1px solid #eee;">
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
                <span>首页</span>
              </template>
              <el-menu-item-group>
                <template slot="title">教师信息</template>
                <el-menu-item index="1-1">
                  <router-link tag="span" id="text" to="/admin/searchTeacher">查询</router-link>
                </el-menu-item>
                <el-menu-item index="1-2">
                  <router-link tag="span" id="text" to="/admin/setTeacher">设置</router-link>
                </el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="学生信息">
                <el-menu-item index="1-3">
                  <router-link tag="span" id="text" to="/admin/searchStudent">查询</router-link>
                </el-menu-item>
                <el-menu-item index="1-4">
                  <router-link tag="span" id="text" to="/admin/setStudent">设置</router-link>
                </el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="课表信息">
                <el-menu-item index="1-5">
                  <router-link tag="span" id="text" to="/admin/searchSchedule">查询</router-link>
                </el-menu-item>
                <el-menu-item index="1-6">
                  <router-link tag="span" id="text" to="/admin/setSchedule">设置</router-link>
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-col>
      </el-aside>
      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown @command="handleLogout">
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="logout">登出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>admin</span>
        </el-header>

        <el-main>
          <router-view/>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Cookies from 'js-cookie';
export default {
  name: "tes",
  data() {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    return {
      tableData: Array(20).fill(item)
    }
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    handleLogout(command) {
      if (command === 'logout') {
        // 删除cookie
        Cookies.remove('userId');
        localStorage.removeItem('power');
        // 跳转到登录页面
        this.$router.push('/');
      }
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