import request from '@/common/request';

// 注册
export const postRegister = data => request.post('/travel/registerServlet', { data });

// 验证码
export const getActiveUser = params => request.get('/travel/activeUserServlet', { params });

// 登录
export const postLogin = data => request.post('/travel/loginServlet', { data });