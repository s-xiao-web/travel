<template>
  <!-- 详情 start -->
  <div class="wrap">
    <div class="bread_box">
      <router-link :to="{ path: '/', query: { cid: state.cid } }"
        >首页</router-link
      >
      <span> &gt;</span>
      旅游线路详情
    </div>
    <div class="prosum_box">
      <div class="prosum_left" style="height: 370px">
        <el-carousel indicator-position="outside">
          <el-carousel-item v-for="item in 4" :key="item">
            <img
              src="http://localhost:8888/travel/img/product/small/m312cf97538027a813a4fb0bd6980a7fea.jpg"
              alt=""
            />
          </el-carousel-item>
        </el-carousel>
      </div>
      <div class="prosum_right">
        <p class="pros_title" id="rname">
          {{state.rname}}
        </p>
        <p class="hot" id="routeIntroduce">
          {{state.routeIntroduce}}
        </p>
        <div class="pros_other">
          <p>经营商家 ：<span id="sname">{{state?.seller?.sname}}</span></p>
          <p>咨询电话 : <span id="consphone">{{state?.seller?.consphone}}</span></p>
          <p>地址 ： <span id="address">{{state?.seller?.address}}</span></p>
        </div>
        <div class="pros_price">
          <p class="price">
            <strong id="price">¥{{state.price}}</strong><span>起</span>
          </p>
          <p class="collect">
            <a class="btn" id="favorite" @click="addFavorite(state.rid)"><i class="glyphicon glyphicon-heart-empty"></i>点击收藏</a
            >
            <span id="favoriteCount">已收藏{{state.count}}次</span>
          </p>
        </div>
      </div>
    </div>
    <div class="you_need_konw">
      <span>旅游须知</span>
      <div class="notice">
        <el-empty description="暂无 相关配置"></el-empty>
      </div>
    </div>
  </div>
</template>

<script>
import { defineComponent, onMounted, ref } from "vue";
import { useRoute, useRouter } from "vue-router";

import { getRouteDetail, postAddFavorite } from "@/api/route";

export default defineComponent({
  name: "detail",
  setup() {
    const [route] = [useRoute(), useRouter()];

    const rid = route.query.rid;
    const state = ref({});

    const addFavorite = async rid => {
      const userInfo = localStorage.getItem("userInfo");
      const params = { rid: rid };
      if (userInfo) {
        const { uid } = JSON.parse(userInfo);
        params.uid = uid;
      }
      Object.keys(params).forEach(key => params[key] = params[key].toString())
      const result = await postAddFavorite({ ...params });
      console.log(result);
    }

    const getTravelData = async () => {
      const { data } = await getRouteDetail({ rid });
      state.value = data;
    };

    onMounted(getTravelData);

    return { state, addFavorite };
  },
});
</script>

<style lang="less" scope>
/*商品详情页*/
.search_input {
  height: 40px;
}

.bread_box {
  width: 1188px;
  padding: 10px;
  margin: 0 auto;
}
.bread_box a {
  color: #000;
}
.prosum_box {
  width: 1188px;
  border: solid 1px #ddd;
  background: #fff;
  overflow: hidden;
  margin: 0 auto 20px;
}

.prosum_box .prosum_left {
  margin: 20px;
  overflow: hidden;
  width: 684px;
  float: left;
  img {
    width: 100%;
  }
}

.prosum_box .prosum_left .big_img {
  width: 570px;
  height: 340px;
}

.prosum_box .prosum_left .little_img img {
  width: 110px;
  height: 70px;
  opacity: 0.6;
}

.prosum_box .prosum_left .little_img img:hover {
  opacity: 1;
}

.prosum_box .prosum_left .cur_img img {
  opacity: 1;
}

.prosum_box .prosum_left .up_img,
.prosum_box .prosum_left .down_img {
  width: 110px;
  height: 20px;
  background: #333;
}

.prosum_box .prosum_left .up_img {
  background: url("/assets/arrows.jpg") no-repeat;
  background-position: 0px -20px;
}

.prosum_box .prosum_left .up_img_disable {
  background-position: 0px 0px;
}

.prosum_box .prosum_left .down_img {
  background: url("/assets/arrows.jpg") no-repeat;
  background-position: 0px -60px;
}

.prosum_box .prosum_left .down_img_disable {
  background-position: 0px -40px;
}

.prosum_box .prosum_left dt {
  float: left;
  margin-right: 4px;
}

.prosum_box .prosum_left dd {
  float: left;
}

.prosum_box .prosum_left dd a {
  display: block;
  margin-bottom: 4px;
}

.prosum_box .prosum_right {
  float: left;
  width: 462px;
  margin: 20px 0px 20px 0px;
}

.prosum_box .prosum_right .pros_title {
  font-size: 18px;
  line-height: 28px;
  font-weight: bold;
  margin-bottom: 5px;
}

.hot {
  font-size: 14px;
  color: #ff4848;
}

.pros_other {
  background: #eee;
  font-size: 14px;
  padding: 10px 0 10px 10px;
  margin-top: 10px;
}
.pros_other p {
  line-height: 24px;
}
.pros_price {
  background: #eee;
  margin-top: 40px;
  padding: 10px 0 20px 10px;
}
.pros_price .price strong {
  color: #ff4848;
  font-size: 26px;
  font-weight: normal;
}
.collect {
  margin-top: 30px;
}
.collect a {
  font-size: 14px;
  background: #ff4848;
  color: #fff;
  padding: 8px;
  border-radius: 4px;
  cursor: pointer;
}
.collect .already {
  background: #ccc;
}
.collect a i {
  font-size: 16px;
  vertical-align: top;
  margin-right: 3px;
}
.you_need_konw {
  width: 1188px;
  margin: 60px auto;
}
.you_need_konw span {
  font-size: 16px;
  border-bottom: 3px solid #ffc900;
}
.notice {
  border: solid 1px #ddd;
  padding: 35px 48px;
}
.notice p {
  line-height: 24px;
  font-size: 16px;
  margin-bottom: 20px;
}
</style>