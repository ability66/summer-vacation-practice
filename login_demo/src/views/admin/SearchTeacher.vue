<template>
    <div>
        <div id="background">
            <div>
                <h1>查询教师信息</h1>
            </div>
            <div class="demo-input-wrapper">
                <span>请输入教师工号：</span>
                <el-input tag="input" placeholder="请输入内容" prefix-icon="el-icon-search" v-model="input2"></el-input>
                <el-button type="primary" @click="search">查询</el-button>
            </div>
            <el-table :data="tableData">
                <el-table-column label="日期" width="180">
                    <template slot-scope="scope">
                        <i class="el-icon-time"></i>
                        <span style="margin-left: 10px">{{ scope.row.date }}</span>
                    </template>
                </el-table-column>
                <el-table-column label="姓名" width="180">
                    <template slot-scope="scope">
                        <el-popover trigger="hover" placement="top">
                            <p>姓名: {{ scope.row.name }}</p>
                            <p>住址: {{ scope.row.address }}</p>
                            <div slot="reference" class="name-wrapper">
                                <el-tag size="medium">{{ scope.row.name }}</el-tag>
                            </div>
                        </el-popover>
                    </template>
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="block">
                <span class="demonstration">页码</span>
                <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                    :current-page="currentPage4" :page-sizes="[10, 20, 30, 40]" :page-size="10"
                    layout="total, sizes, prev, pager, next, jumper" :total="400">
                </el-pagination>
            </div>
        </div>

    </div>
</template>

<style scoped>
#background{
    border:1px solid rgba(255, 2, 2, 0.979);
    margin-left: 3%;
    margin-right: 0px;
    height: 1000px;
    width: 94%;
}
.el-table{
    border:1px solid rgba(253, 228, 3, 0.979);
    width: 100%;
    margin-left: 0;
    margin-right: 1000px;
}
.demo-input-wrapper {
  display: flex;
  width: 40%;
}
.demo-input-wrapper span {
    border:1px solid rgba(253, 228, 3, 0.979);
    font-size: 17px;

    width:38%;
    height: 20px;
}

</style>
<script>
export default {
    data() {
      return {
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }],
        currentPage1: 5,
        currentPage2: 5,
        currentPage3: 5,
        currentPage4: 4
      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      }
    }
  }
</script>