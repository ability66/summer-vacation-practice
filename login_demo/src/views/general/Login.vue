<template>

    <div id="background">
        <div id="logo">
            LOGO
        </div>
        <div id="login">
            <el-card class="box-card">
                <div id="form">
                    <el-input v-model="username" placeholder="Username"></el-input>
                    <el-input placeholder="Password" v-model="password" show-password></el-input>
                    <el-input v-model="code" placeholder="验证码"></el-input>
                    <el-button type="primary" @click="login">LOGIN</el-button>
                    <el-button type="primary" @click="jumptoindex">Jump</el-button>
                
                </div>
            </el-card>
        </div>
        <div id="clock">
            <div id="time">
            {{ time }}
            </div>
            <div id="date">
            {{ date }}
            </div>
        </div>
        <div id="copyright">
            Copyright © 2023 司马吴空. All rights reserved.
        </div>
    </div>
  </template>
  
  <style scoped>
    #background {
        position: fixed;
        width: 100%;
        height: 100%;
        background-color: darkseagreen;
        top:0;
        left:0;
        background-image:linear-gradient(
            90deg,
            cyan,
            purple
         );
        background-size: 400%;
        animation: myanimation 10s infinite;
    }
    @keyframes myanimation {
            0% {
                background-position: 0% 50%;
            }
            50% {
                background-position: 100% 50%;
            }
            100% {
                background-position: 0% 50%;
            }
  
    }
    #logo{
        color:aliceblue;
        font-size: 25px;
        font-weight: 800;
        text-transform:uppercase;
        position: absolute;
        top: 15%;
        left: 15%;
    }
    #login{
        position: absolute;
        top: 30%;
        left: 38%;
    }
    .el-card {
        width: 373px;
        height: 271px;
        background-color: rgba(255, 255, 255, 0.4);
        border-radius:10px;
    }
    #form{
        line-height: 60px;
        padding-left: 15px;
        padding-right: 15px;
    }
    #clock{
        position: absolute;
        top: 80%;
        left: 15%;
        color:aliceblue;
        text-align: left;
    }
    #time{
        font-size: 100px;
        font-weight: 800;
    }
    #date{
        font-size: 35px;
        font-weight: 800;
    }
    #copyright{
        position: absolute;
        top: 90%;
        left: 38%;
        color:aliceblue;
  
    }
  </style>
  
<script>
export default {
    data() {
        return {
            username: '',
            password: '',
            code: '',
            time: '',
            date: '',
            test:'test'
        }
    },
    methods: {
        update_clock: function (e) {
            var today = new Date();
            var h = today.getHours();
            var m = today.getMinutes();
            var s = today.getSeconds();
            var d = today.getDate();
            var mo = today.getMonth() + 1;
            var y = today.getFullYear();
            if (y < 10) {
                y = "0" + y;
            }
            if (mo < 10) {
                mo = "0" + mo;
            }
            if (d < 10) {
                d = "0" + d;
            }
            if (h < 10) {
                h = "0" + h;
            }
            if (m < 10) {
                m = "0" + m;
            }

            this.time = h + ":" + m;
            this.date = y + "-" + mo + "-" + d;
        },
        login() {
            // 构建登录请求的数据
            const data = {
                username: this.username,
                password: this.password,
                code: this.code
            };

            // 发送登录请求
            axios.post('/api/login', data)
                .then(response => {
                    console.log("response");
                    // 登录成功
                    if (response.data.success) {
                        // 保存token到本地存储
                        localStorage.setItem('token', response.data.token);
                        // 跳转到Index.vue
                        this.$router.push('/index');
                    } else {
                        // 登录失败，提示重新输入
                        alert('登录失败，请重新输入');
                    }
                })
                .catch(error => {
                    console.error(error);
                    // 处理请求错误
                    alert('登录失败，请稍后重试');
                });
        },
        jumptoindex(){
            this.$router.push('/Admin');
        }
    },
    mounted() {
        setInterval(this.update_clock, 1000);
    }
}
</script>
