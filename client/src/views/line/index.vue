<template>
  <div class="page_one">
    <div class="contant">
      <div class="crumbs">
        <img src="@/assets/search.png" alt="" />
        <p>黑马旅行><span>搜索结果</span></p>
      </div>
      <div class="xinxi clearfix">
        <div class="left">
          <div class="header">
            <span>商品信息</span>
            <span class="jg">价格</span>
          </div>
          <ul id="route">
            <li v-for="item in lineData" :key="item.cid">
              <div class="img">
                <img
                  src="http://localhost:8888/travel/img/product/small/m312cf97538027a813a4fb0bd6980a7fea.jpg"
                  alt=""
                />
              </div>
              <div class="text1">
                <p>
                  {{ item.rname }}
                </p>
                <br />
                <p>{{ item.routeIntroduce }}</p>
              </div>
              <div class="price">
                <p class="price_num">
                  <span>&yen;</span>
                  <span>{{ item.price }}</span>
                  <span>起</span>
                </p>
                <p><a href="route_detail.html">查看详情</a></p>
              </div>
            </li>
          </ul>
          <el-pagination
            background
            layout="pager"
            :page-size="pageInfo.pageSize"
            :total="pageInfo.total"
            :current-page="pageInfo.currentPage"
            @current-change="handlerCurrentPage"
          ></el-pagination>
        </div>
        <div class="right">
          <div class="top">
            <div class="hot">HOT</div>
            <span>热门推荐</span>
          </div>
          <ul>
            <li>
              <div class="left">
                <img src="images/04-search_09.jpg" alt="" />
              </div>
              <div class="right">
                <p>清远新银盏温泉度假村酒店/自由行套...</p>
                <p>网付价<span>&yen;<span>899</span>起</span></p>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { defineComponent, reactive, toRefs, watch, onMounted } from "vue";
import { useRoute } from "vue-router";

import { getRoutePage } from "@/api/route";

export default defineComponent({
  name: "line",
  setup() {
    const {
      query: { cid },
    } = useRoute();
    console.log(cid);
    const state = reactive({
      lineData: [],
      pageInfo: {
        pageSize: 5,
        currentPage: 1,
        total: 0,
      },
    });
    
    watch(
      () => state.pageInfo.currentPage,
      () => {
        fetchRoureData()
      },
    );

    const handlerCurrentPage = (i) => {
      state.pageInfo.currentPage = i;
    };

    const fetchRoureData = () => {
      getRoutePage({cid, ...state.pageInfo}).then((res) => {
        const { list = [], pageSize, currentPage, totalCount: total } = res;
        state.pageInfo = { pageSize, currentPage, total };
        state.lineData = list;
      });
    }

    onMounted(fetchRoureData);

    return { ...toRefs(state), handlerCurrentPage };
  },
});
</script>

<style lang="less">
a {
  color: #000;
}
.contant {
  width: 1180px;
  margin: 0 auto;
  padding-bottom: 50px;
}
.clearfix::after {
  display: block;
  clear: both;
  content: "";
  visibility: hidden;
  height: 0;
}
.page_one .crumbs {
  width: 100%;
  height: 55px;
  line-height: 55px;
  font-size: 18px;
  overflow: hidden;
}
.page_one .crumbs img {
  width: 20px;
  height: 20px;
  float: left;
  margin-top: 16px;
  margin-right: 5px;
}
.page_one .crumbs span {
  color: #ff4848;
}
.page_one .xinxi {
  font-size: 16px;
}
.page_one .xinxi .left {
  width: 890px;
  float: left;
}
.page_one .xinxi .left .header {
  background-color: #eee;
  font-weight: bold;
  height: 40px;
  line-height: 40px;
  padding-left: 300px;
  margin-bottom: 15px;
}
.page_one .xinxi .left .header .jg {
  margin-left: 390px;
}
.page_one .xinxi .left > ul li {
  width: 100%;
  height: 170px;
  border: 1px solid #eee;
  border-left: 0;
  margin-bottom: 15px;
  overflow: hidden;
}
.page_one .xinxi .left > ul li .img {
  width: 300px;
  height: 170px;
  float: left;

  img {
    width: 100%;
  }
}
.page_one .xinxi .left > ul li .text1 {
  width: 330px;
  float: left;
  padding: 20px;
  color: #a3a3a3;
  font-size: 14px;
  p {
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
  }
  // overflow: hidden;
  //   text-overflow: ellipsis;
  //   display: -webkit-box;
}
.page_one .xinxi .left > ul li .text1 p:nth-of-type(1) {
  color: #000;
  font-size: 18px;
  margin-bottom: 5px;
}
.page_one .xinxi .left > ul li .price {
  width: 215px;
  text-align: center;
  float: left;
  height: 95px;
  border-left: 1px solid #eee;
  margin-top: 35px;
  font-size: 16px;
}
.page_one .xinxi .left > ul li .price p {
  line-height: 1;
  margin-top: 15px;
}
.page_one .xinxi .left > ul li .price .price_num {
  line-height: 1;
  font-size: 30px;
  color: #ff4848;
}
.page_one .xinxi .left > ul li .price .price_num span:nth-of-type(3) {
  font-size: 16px;
}
.page_one .xinxi .left .page_num_inf {
  color: #878787;
  font-size: 19px;
  margin-bottom: 20px;
}
.page_one .xinxi .left .page_num_inf i {
  float: left;
  width: 4px;
  background-color: #878787;
  height: 20px;
  margin-top: 5px;
  margin-right: 10px;
}
.page_one .xinxi .left .page_num_inf span {
  color: #ff4848;
}
.page_one .xinxi > .right {
  width: 244px;
  height: 460px;
  float: right;
  background-color: #f7f7f7;
  padding: 8px;
  padding-top: 0;
  font-size: 14px;
}
.page_one .xinxi > .right .top {
  width: 100%;
  height: 40px;
  line-height: 40px;
  border-bottom: 2px solid #eee;
  margin-bottom: 8px;
}
.page_one .xinxi > .right .top .hot {
  float: left;
  color: #ff4848;
  margin-right: 7px;
  line-height: 38px;
  border-bottom: 4px solid #ff4848;
}
.page_one .xinxi > .right ul li {
  width: 100%;
  height: 72px;
  border: 1px solid #eee;
  margin-bottom: 10px;
  font-size: 12px;
  overflow: hidden;
  background-color: #fff;
}
.page_one .xinxi > .right ul li .left {
  float: left;
  width: 50%;
}
.page_one .xinxi > .right ul li .left img {
  width: 100%;
}
.page_one .xinxi > .right ul li .right {
  width: 50%;
  float: right;
  padding-left: 4px;
  box-sizing: border-box;
  padding-top: 7px;
}
.page_one .xinxi > .right ul li .right p:nth-of-type(1) {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  font-weight: bold;
  margin-bottom: 3px;
}
.page_one .xinxi > .right ul li .right p > span {
  font-size: 16px;
  color: #ff4848;
  font-weight: bold;
  margin-left: 2px;
}
</style>