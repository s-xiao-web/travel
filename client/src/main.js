import { createApp } from 'vue'

import store from './store'
import router from './router'
import App from './App.vue'

import ElementPlus from 'element-plus';
import 'element-plus/lib/theme-chalk/index.css';
import '@/style/index.less';

const app = createApp(App);

app.use(ElementPlus);
app.use(router);
app.use(store);

app.mount('#app');