import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  // hash模式：createWebHashHistory，history模式：createWebHistory
  history: createWebHistory(), 
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import(/* webpackChunkName: "login" */ '@/views/home'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import(/* webpackChunkName: "login" */ '@/views/login'),
    },
    {
      path: '/register',
      name: 'register',
      component: () => import(/* webpackChunkName: "login" */ '@/views/register'),
    },
    {
      path: '/active',
      name: 'active',
      component: () => import(/* webpackChunkName: "login" */ '@/views/active'),
    },
 
  ]
})

export default router