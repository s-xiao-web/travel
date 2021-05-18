import { ref, watch, onMounted } from "vue";

import { getRoutePage } from "@/api/route";


export default function getGoodList(params) {
  
  const travelRoute = ref([]);

  const getTravelData = async (arg) => {
    const param = arg || params;
    const { rname, cid, pageInfo } = param;
    travelRoute.value = await getRoutePage({...pageInfo, rname, cid});
  };

  watch(params, (newParams) => {
    getTravelData(newParams)
  });

  onMounted(getTravelData);

  return { travelRoute };

}