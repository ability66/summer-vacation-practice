<template>
  <div style="height: 100%;">
    <el-container style="height: 100%; border: 1px solid #eee;">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <div id="logo">LOGO</div>
        <!-- <el-menu :default-openeds="[]">
            <el-submenu index="1">
              <template slot="title" ><i class="el-icon-message"></i>
              <span id="text">
                首页
              </span>
              </template>
              <el-menu-item-group>
                <template slot="title">教师信息</template>
                <el-menu-item index="1-1">
                    <router-link tag="span" id="text" to="/searchTeacher">查询</router-link>
                </el-menu-item>
                <el-menu-item index="1-2">
                    <router-link tag="span" id="text" to="/setTeacher">设置</router-link>
                </el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="学生信息">
                <el-menu-item index="1-3">
                    <router-link tag="span" id="text" to="/searchStudent">查询</router-link>
                </el-menu-item>
                <el-menu-item index="1-4">
                    <router-link tag="span" id="text" to="/setStudent">设置</router-link>
                </el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="课程信息">
                <el-menu-item index="1-5">查询</el-menu-item>
                <el-menu-item index="1-6">设置</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

          </el-menu> -->

        <el-col :span="12">
          <el-menu
            default-active="1"
            default-openeds="[1]"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
          >
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>首页</span>
              </template>
              <el-menu-item-group>
                <template slot="title">教师信息</template>
                <el-menu-item index="1-1">
                  <router-link tag="span" id="text" to="/teacher/searchTeacher"
                    >个人信息</router-link
                  >
                </el-menu-item>
                <el-menu-item index="1-2">
                  <router-link tag="span" id="text" to="/teacher/TeacherSearchStudent"
                    >学生查询</router-link
                  >
                </el-menu-item>
                <el-menu-item index="1-3">
                  <router-link tag="span" id="text" to="/teacher/TeacherSearchReport"
                    >查询报告</router-link
                  >
                </el-menu-item>
                <el-menu-item index="1-4">
                  <router-link tag="span" id="text" to="/teacher/TeacherSetScore"
                    >成绩设置</router-link
                  >
                </el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="学生信息">
                <el-menu-item index="2-1">
                  <router-link tag="span" id="text" to="/admin/searchStudent"
                    >查询</router-link
                  >
                </el-menu-item>
                <el-menu-item index="2-2">
                  <router-link tag="span" id="text" to="/admin/setStudent"
                    >设置</router-link
                  >
                </el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="课表信息">
                <el-menu-item index="3-1">
                  <router-link tag="span" id="text" to="/admin/searchSchedule"
                    >查询</router-link
                  >
                </el-menu-item>
                <el-menu-item index="3-2">
                  <router-link tag="span" id="text" to="/admin/setSchedule"
                    >设置</router-link
                  >
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-col>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <!-- <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>王小虎</span> -->
        </el-header>

        <el-main>
          <router-view />
          <!-- <el-table :data="tableData">
              <el-table-column prop="date" label="日期" width="140">
              </el-table-column>
              <el-table-column prop="name" label="姓名" width="120">
              </el-table-column>
              <el-table-column prop="address" label="地址">
              </el-table-column>
            </el-table> -->
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

    <script>
export default {
  name: "tes",
  data() {
    const item = {
      date: "2016-05-02",
      name: "王小虎",
      address: "上海市普陀区金沙江路 1518 弄",
    };
    return {
      tableData: Array(20).fill(item),
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>

    <style scoped>
.el-header {
  background-color: #b3c0d1;
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
