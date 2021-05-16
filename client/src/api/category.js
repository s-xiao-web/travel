import request from '@/common/request';

// 获取导航
export const getCategory = () => request.get('/travel/category/findAll');
