<template>
  <div>
    <layoutHeader />
    <layoutSearch @search="queryTravelData" />
    <layoutCategory />
    <layoutWrap>
      <template #left>
        <layoutGoodsItem :data="travelRoute"></layoutGoodsItem>
        <el-pagination
          background
          layout="pager"
          :page-size="pageInfo.pageSize"
          :current-page="pageInfo.currentPage"
          :total="travelRoute.totalCount || 0"
          :hide-on-single-page="travelRoute.totalPage <= 1"
          @current-change="handlerPageChange"
        ></el-pagination>
      </template>
      <template #right>
        <layoutGoodsHot></layoutGoodsHot>
      </template>
    </layoutWrap>
  </div>
</template>

<script>
import { defineComponent, watch, reactive,  toRefs, toRef } from "vue";
import { useRouter, useRoute } from "vue-router";

import basicComp from "./components";
import compposables from "@/composables";

const { getGoodsList } = compposables;

export default defineComponent({
  name: "home",
  components: { ...basicComp },
  setup() {
    
    const [ route ] = [useRoute(), useRouter()];

    const state = reactive({
      rname: "",
      cid: route.query.cid || 1,
      pageInfo: {
        pageSize: 5,
        currentPage: 1,
      },
    })

    const { travelRoute } = getGoodsList(state);

    const queryTravelData = rname => state.rname = rname;

    const handlerPageChange = (pageNum) => {
      state.pageInfo.currentPage = pageNum;
    }

    watch(() => route.query, ({ cid }) => {
      state.pageInfo.currentPage = 1 ;
      state.cid = cid;
    });

    return { ...toRefs(state), queryTravelData, handlerPageChange, travelRoute };

  },
});
</script>

<style lang="less" scope>
.el-pagination {
  display: flex;
    padding: 30px 0;
    justify-content: flex-end;
}
</style>