import request from '@/common/request';

export const postRegister = data => request.post('/travel/loginServlet', {data})