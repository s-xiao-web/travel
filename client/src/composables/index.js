import importAll from '@/utils/importAll';

export default importAll(require.context('./', false, /.js$/), 'js');