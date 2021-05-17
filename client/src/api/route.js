import request from '@/common/request';

// 分类数据
export const getRoutePage = params => request.get('/travel/route/queryRoutePage', { params });
               