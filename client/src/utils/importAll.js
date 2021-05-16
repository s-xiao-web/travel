/*
* @method context
* @params directory 要查找的文件目录
* @params useSubDirectories 是否要查找子目录
* @params regExp 要匹配文件的正则

@ return 
  keys 返回匹配成功的模块数组
  resolve 接受一个参数 request，
*/

const modules = (modulesFiles, suffix) => {

  const reg = Object.is('vue', suffix) ? /^.\/(.*)\.vue/ : /^.\/(.*)\.js/;

  return  modulesFiles.keys().reduce((module, modulePath) => {
    const moduleName = modulePath.replace(reg,'$1')
    const value = modulesFiles(modulePath)
    module[moduleName] = value.default
    return module
  }, {})
}

export default modules;