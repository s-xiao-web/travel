import request from '@/common/request';

// 分类数据
export const getRoutePage = params => request.get('/travel/route/queryRoutePage', { params });

// 查看详情
export const getRouteDetail = params => request.get('/travel/route/queryRouteDetail', { params });

// 添加详情 
export const postAddFavorite = data => request.post('/travel/route/addFavorite', { data });
