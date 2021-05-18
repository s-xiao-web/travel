<template>
  <div class="goods_hot_list">
    <div class="title">热门推荐</div>
    <ul class="goods_info">
      <li><img src="" alt="" /></li>
      <li>
        <p>清远新银盏温泉度假村酒店/自由行套...</p>
        <p>网付价: <span>￥1234</span></p>
      </li>
    </ul>
  </div>
</template>

<style lang="less" scope>
.goods_hot_list {
  width: 230px;
  padding-left: 10px;;

  .title {
    height: 40px;
    line-height: 40px;
    background: #eee;
  }

  .goods_info {
    height: 80px;
    display: flex;
    li:nth-child(1) {
      width: 80px;
      img {
        width: 100%;
        height: 100%;
      }
    }
    li:nth-child(2) {
      width: 150px;
      padding: 10px;
      display: -webkit-box;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 2;
      overflow: hidden;
      
      span {
        font-size: 14px;
        color: red;
      }
    }
  }
}
</style>