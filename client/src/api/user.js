import request from '@/common/request';

// 注册
export const postRegister = data => request.post('/travel/user/register', { data });

// 激活用户
export const postActiveUser = params => request.get('/travel/user/active', { params });

// 登录
export const postLogin = data => request.post('/travel/user/login', { data });

// 退出
export const postSignOut = () => request.post('/travel/user/exit');