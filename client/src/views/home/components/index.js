import importAll from '@/utils/importAll';

export default importAll(require.context('./', false, /.vue$/), 'vue');