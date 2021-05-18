<template>
  <div class="goods_info_wrapper">
    <ul class="goods_info_title">
      <li>商品信息</li>
      <li>价格</li>
    </ul>
    <div class="goods_info_list" v-if="data && data?.list?.length">
      <div class="goods_info_item" v-for="item in data.list" :key="item.rid">
        <div class="goods_img">
          <img
            src="http://localhost:8888/travel/img/product/small/m312cf97538027a813a4fb0bd6980a7fea.jpg"
            alt=""
          />
        </div>
        <ul class="goods_msg">
          <li>
            {{ item.rname }}
          </li>
          <li>{{ item.routeIntroduce }}</li>
        </ul>
        <div class="goods_price">
          <ul>
            <li>
              ￥<span>{{ item.price }}</span>
            </li>
            <li>查看详情</li>
          </ul>
        </div>
      </div>
    </div>
    <el-empty description="没有查询到任何的结果 (T_T) " v-else></el-empty>
  </div>
</template>

<script>
import { defineComponent } from "vue";
export default defineComponent({
  name: "layoutGoodsItem",
  props: {
    data: {
      type: Object,
      required: true,
    }
  },
  setup() {},
});
</script>

<style lang="less" scope>
.goods_info_wrapper {
  width: 950px;

  .goods_info_title {
    display: flex;
    height: 40px;
    line-height: 40px;
    text-align: center;
    background: #eee;
    li:nth-child(1) {
      width: 700px;
    }

    & li:nth-child(2) {
      width: 250px;
    }
  }

  .goods_info_list {
    .goods_info_item {
      display: flex;
      height: 200px;
      margin-top: 20px;
      border: 1px solid #ccc;
      .goods_img {
        width: 300px;

        img {
          width: 100%;
          height: 100%;
        }
      }

      .goods_msg {
        width: 400px;
        padding: 30px;

        li {
          display: -webkit-box;
          -webkit-box-orient: vertical;
          -webkit-line-clamp: 2;
          overflow: hidden;
        }

        li:nth-child(1) {
          color: #000;
          font-size: 18px;
        }

        li:nth-child(2) {
          padding-top: 30px;
          color: #a3a3a3;
        }
      }

      .goods_price {
        display: flex;
        align-items: center;
        justify-content: center;
        width: 250px;
        text-align: center;

        li:nth-child(1) {
          font-size: 26px;
          line-height: 60px;
          color: red;
        }
        li:nth-child(2) {
          font-size: 14px;
          cursor: pointer;
        }
      }
    }
  }
}
</style>