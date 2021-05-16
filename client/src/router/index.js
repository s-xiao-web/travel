import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  // hash模式：createWebHashHistory，history模式：createWebHistory
  history: createWebHistory(), 
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('@/views/home'),
      children: [
        {
          path: '/line',
          name: 'line',
          component: () => import('@/views/line'),
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/login'),
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('@/views/register'),
    },
    {
      path: '/active',
      name: 'active',
      component: () => import('@/views/active'),
    },
  ]
})

export default router