<template>
  <el-card class="box-card" style="height: 79vh">
    <div style="position: relative;height: 100%">

            <div>
                <h3 style="font-size: 40px">查询教师信息</h3>
            </div>
            <div class="demo-input-wrapper">
                <span>请输入教师工号：</span>
                <el-input tag="input" placeholder="请输入内容" prefix-icon="el-icon-search" v-model="input2"></el-input>
                <el-button type="primary" @click="search">查询</el-button>
            </div>
            <el-table :data="tableData" STYLE="font-size: 18px;">
                <el-table-column label="工号" width="300">
                    <template slot-scope="scope">
                        <span>{{ scope.row.no }}</span>
                    </template>
                </el-table-column>
                <el-table-column label="姓名" width="300">
                  <template slot-scope="scope">
                    <span>{{ scope.row.name }}</span>
                  </template>
                </el-table-column>
              <el-table-column label="学院号" width="300">
                <template slot-scope="scope">
                  <span>{{ scope.row.college }}</span>
                </template>
              </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="block" style="position: absolute;">
                <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-size="5"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
                </el-pagination>
            </div>


    </div>
  </el-card>
</template>

<style scoped>
/*#background{
    border:1px solid rgba(255, 2, 2, 0.979);
    margin-left: 3%;
    margin-right: 0px;
    height: 1000px;
    width: 94%;
}*/
/*.el-table{
    border:1px solid rgba(253, 228, 3, 0.979);
    width: 100%;
    margin-left: 0;
    margin-right: 1000px;
}*/
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
    data() {
      return {
        tableData: [],//表格数据
        empVo:{},
        total:0,//总页码
        currentPage: 1,//当前页码

      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },

// ---------------------------------------分页
      initTable(){
        axios.post("http://localhost:8181"+this.currentPage+"/"+this.pageSize,this.empVo).then(result=>{
          this.tableDate=result.data.data.records;
          this.total=result.data.data.total;
        })
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        this.currentPage=val;
        this.initTable();
      }
    }
  }
</script>