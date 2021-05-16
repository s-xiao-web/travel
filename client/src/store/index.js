import { createStore } from 'vuex';

import importAll from '@/utils/importAll';

const modules = importAll(require.context('./modules', false, /.js$/), 'js')

export default createStore({ modules })