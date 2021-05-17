import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  // hash模式：createWebHashHistory，history模式：createWebHistory
  history: createWebHistory(), 
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import(/* webpackChunkName: "home" */'@/views/home'),
      children: [
        {
          path: '/line',
          name: 'line',
          component: () => import(/* webpackChunkName: "line" */'@/views/line'),
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: () => import(/* webpackChunkName: "login" */'@/views/login'),
    },
    {
      path: '/register',
      name: 'register',
      component: () => import(/* webpackChunkName: "register" */'@/views/register'),
    },
    {
      path: '/active',
      name: 'active',
      component: () => import(/* webpackChunkName: "active" */'@/views/active'),
    },
  ]
})

export default router