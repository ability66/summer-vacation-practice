import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './plugins/element.js'

Vue.config.productionTip = false

Vue.use(ElementUI);

new Vue({
  router,
  created() {
		// 路由拦截器
    console.log('main.js created()');
    router.beforeEach((to, from, next) => {
      console.log('main.js router.beforeEach()');
      if (to.matched.some(record => record.meta.requireAuth)) {
        // this route requires auth, check if logged in
        // if not, redirect to login page.
        if (!localStorage.getItem('power')) {
          next({
            path: '/',
            query: { redirect: to.fullPath }
          })
        } else {
          // check if the user has the required role to access the route
          const userRole = localStorage.getItem('power');
          if (to.path.startsWith(`/${userRole}`)) {
            next();
          } else {
            window.alert('You do not have permission to access this page');
            next();
          }
        }
      } else {
        next(); // make sure to always call next()!
      }
    });
	},
  render: function (h) { return h(App) }
}).$mount('#app')
