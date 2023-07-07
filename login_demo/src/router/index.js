import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '../views/general/Login.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: Login,
  },
  // Teacher路由
  {
    //母路由就是""首页",每个角色的首页因为侧边栏不同，所以单独写
    path:'/Teacher',
    name:'teacher',
    component:()=>import('../views/teacher/Teacher.vue'),
    children:[
      //Teacher
      {
        path:'TeacherSearchStudent',//子路由不要加"/"
        name:'teachersearchstudent',
        component:()=>import('../views/teacher/TeacherSearchStudent.vue')
      },
      {
        path:'SearchTeacher',
        name:'searchTeacher',
        component:()=>import('../views/teacher/SearchTeacher.vue')
      },
      {
        path:'TeacherSearchReport',
        name:'teachersearchreport',
        component:()=>import('../views/teacher/TeacherSearchReport.vue')
      },
      {
        path:'TeacherSetScore',
        name:'teachersetscore',
        component:()=>import('../views/teacher/TeacherSetScore.vue')
      }
    ]
  }



]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
