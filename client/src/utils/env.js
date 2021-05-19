// let baseUrl=""
// if(process.env.NODE_ENV === "production"){ //生产环境
//   if (process.env.VUE_APP_NAME === 'release') {
//     baseUrl = "正式地址1";
//   }else if(process.env.VUE_APP_NAME === 'build'){
//     baseUrl = "正式地址2";
//   }
// }else{ //开发环境
//   baseUrl="开发地址"
// }
export default{ path: process.env.VUE_APP_IMG_PATH }