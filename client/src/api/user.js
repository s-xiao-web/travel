import request from '@/common/request';

// 注册
export const postRegister = data => request.post('/travel/registerServlet', { data });

// 激活用户
export const postActiveUser = params => request.get('/travel/activeUserServlet', { params });

// 登录
export const postLogin = data => request.post('/travel/loginServlet', { data });

// 退出
export const postSignOut = () => request.post('/travel/exitServlet');