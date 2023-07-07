import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '../views/general/Login.vue'
import Index from '../views/general/Index.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: Login,
  },
  // 测试Index路由
  {
    path:'/Index',
    name:'index',
    component:Index,
    children:[
      {
        path:'/Index1',
        name:'index1',
        component:()=>import('../views/general/Index1.vue')
      }
    ]
  },
  // Admin路由
  {
    //母路由就是""首页",每个角色的首页因为侧边栏不同，所以单独写
    path:'/Admin',
    name:'admin',
    component:()=>import('../views/admin/Admin.vue'),
    children:[
      //Teacher
      {
        path:'TeacherSearchStudent',//子路由不要加"/"
        name:'teachersearchstudent',
        component:()=>import('../views/admin/TeacherSearchStudent.vue')
      },
      {
        path:'SearchTeacher',
        name:'searchTeacher',
        component:()=>import('../views/admin/SearchTeacher.vue')
      },
      //Student
      {
        path:'SearchStudent',
        name:'searchStudent',
        component:()=>import('../views/admin/SearchStudent.vue')
      },
      {
        path:'SetStudent',
        name:'setStudent',
        component:()=>import('../views/admin/SetStudent.vue')
      },
      //Schedule
      {
        path:'SearchSchedule',
        name:'searchSchedule',
        component:()=>import('../views/admin/SearchSchedule.vue')
      },
      {
        path:'SetSchedule',
        name:'setSchedule',
        component:()=>import('../views/admin/SetSchedule.vue')
      },
      {
        path:'TeacherSearchReport',
        name:'teachersearchreport',
        component:()=>import('../views/admin/TeacherSearchReport.vue')
      },
      {
        path:'TeacherSetScore',
        name:'teachersetscore',
        component:()=>import('../views/admin/TeacherSetScore.vue')
      }
    ]
  },
  // Teacher路由
  {
    path:'/Index',
    name:'index',
    component:()=>import('../views/teacher/Teacher.vue'),
    children:[
      {
        path:'/Index1',
        name:'index1',
        component:()=>import('../views/general/Index1.vue')
      }
    ]
  },
  // Student路由
  {
    path:'/Index',
    name:'index',
    component:()=>import('../views/general/Index.vue'),
    children:[
      {
        path:'/Index1',
        name:'index1',
        component:()=>import('../views/general/Index1.vue')
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
