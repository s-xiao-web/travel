import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  // hash模式：createWebHashHistory，history模式：createWebHistory
  history: createWebHistory(), 
  routes: [
    {
      path: '/register',
      name: 'register',
      component: () => import(/* webpackChunkName: "login" */ '@/views/register'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import(/* webpackChunkName: "login" */ '@/views/login'),
    },
    // {
    //   path: '/',
    //   redirect: '/home'
    // },
    // {
    //   path: '/test',
    //   name: 'test',
    //   component: () => import(/* webpackChunkName: "login" */ '@/views/testDemo.vue'),
    //   meta: {
    //     index: 1
    //   }
    // } 
  ]
})

export default router