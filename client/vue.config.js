module.exports = {
  lintOnSave: false,
  publicPath: "/travel/",
  assetsDir: 'static',
  pluginOptions: {
    'style-resources-loader': {
      preProcessor: 'less',
      patterns: []
    }
  },
  devServer: {
    proxy: {
      '/travel': {
        target: 'http://localhost:8888',
        changeOrigin: true,
        // pathRewrite: {
        //   '^/api': ''
        // }
      }
    }
  }
}
