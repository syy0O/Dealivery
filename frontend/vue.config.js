const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  devServer: {
    port: 3000,
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        changeOrigin: true,
        pathRewrite: { "^/api": "" },
      },
      "/queue": {
        target: "http://localhost:9090/queue",
        changeOrigin: true,
        pathRewrite: { "^/queue": "" }, // /queue를 제거
      }
    },
  },
  transpileDependencies: true,
})
