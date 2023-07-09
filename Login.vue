<template>
    <div id="background">
        <div id="logo">
            LOGO
        </div>
        <div id="login">
            <el-card class="box-card">
                <el-form ref="loginForm" :model="loginData">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="loginData.username" placeholder="Username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input placeholder="Password" v-model="loginData.password" type="password"
                            show-password></el-input>
                    </el-form-item>
                    <el-form-item label="验证码" prop="code">
                        <el-input v-model="code" placeholder="验证码"></el-input>
                    </el-form-item>
                    <!-- Add the vue-recaptcha component here -->
                    <vue-recaptcha sitekey="<your-site-key>" @verify="onCaptchaVerified"
                        @expired="onCaptchaExpired"></vue-recaptcha>
                    <el-button type="primary" @click="login">LOGIN</el-button>
                    <el-button type="primary" @click="jumptoindex">Jump</el-button>
                </el-form>
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
    top: 0;
    left: 0;
    background-image: linear-gradient(90deg,
            cyan,
            purple);
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

#logo {
    color: aliceblue;
    font-size: 25px;
    font-weight: 800;
    text-transform: uppercase;
    position: absolute;
    top: 15%;
    left: 15%;
}

#login {
    position: absolute;
    top: 25%;
    left: 38%;
}

.el-card {
    width: 373px;
    height: 400px;
    background-color: rgba(255, 255, 255, 0.4);
    border-radius: 10px;
}

.el-form {
    line-height: 10px;
    padding-left: 15px;
    padding-right: 15px;
}

#clock {
    position: absolute;
    top: 80%;
    left: 15%;
    color: aliceblue;
    text-align: left;
}

#time {
    font-size: 100px;
    font-weight: 800;
}

#date {
    font-size: 35px;
    font-weight: 800;
}

#copyright {
    position: absolute;
    top: 90%;
    left: 38%;
    color: aliceblue;

}
</style>


<script>
import axios from 'axios';
import Cookies from 'js-cookie';
import VueRecaptcha from 'vue-recaptcha';

const backendURL = 'http://localhost:8181';

export default {
    components: {
        VueRecaptcha,
    },
    data() {
        return {
            loginData: {
                username: '',
                password: ''
            },
            code: '',
            time: '',
            captchaResponse: null,
            date: ''
        }
    },
    methods: {
        //实时更新时间
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
        onCaptchaVerified(response) {
            this.captchaResponse = response;
        },
        onCaptchaExpired() {
            this.captchaResponse = null;
        },
        //登录
        login() {
            // if (!this.captchaResponse) {
            //     // captcha not verified, show an error message
            //     return;
            // }
            console.log(this.loginData.username)
            const user = {
                username: this.loginData.username,
                password: this.loginData.password
            };

            axios.post('http://localhost:8181/user/loginIn', user)
                .then(response => {
                    const role = response.data;
                    if (role === 'admin') {
                        // 登录成功，跳转到管理员页面
                        Cookies.set('userId', this.loginData.username);
                        // 将role存储到localStorage中
                        localStorage.setItem('power', role);
                        this.$router.push('/admin');
                    } else if (role === 'student') {
                        // 登录成功，跳转到学生页面
                        Cookies.set('userId', this.loginData.username);
                        // 将role存储到localStorage中
                        localStorage.setItem('power', role);
                        this.$router.push('/student');
                    } else if (role === 'teacher') {
                        // 登录成功，跳转到教师页面
                        Cookies.set('userId', this.loginData.username);
                        // 将role存储到localStorage中
                        localStorage.setItem('power', role);
                        this.$router.push('/teacher');
                    } else {
                        // 登录失败，显示错误信息
                        alert('登录失败，请检查用户名和密码！');
                    }
                })
                .catch(error => {
                    console.error(error);
                    alert('登录失败，请稍后重试！');
                });
        }
    },
    mounted() {
        setInterval(this.update_clock, 1000);
    }
}
</script>
