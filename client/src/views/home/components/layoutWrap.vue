<template>
  <div class="content">
    <div class="crumbs">
      <img src="@/assets/search.png" alt="" />
      <p>黑马旅行 > <span>搜索结果</span></p>
    </div>
    <div class="section">
      <div class="left_section">
        <slot name="left"></slot>
      </div>
      <div class="right_section">
        <slot name="right"></slot>
      </div>
    </div>
  </div>
</template>

<style lang="less" scope>
.content {
  width: 1200px;
  margin: 0 auto;
  .crumbs {
    display: flex;
    align-items: center;
    height: 50px;
    line-height: 50px;
    font-size: 14px;

    p {
      padding: 0 10px;
    }
  }

  .section {
    display: flex;
    justify-content: space-between;
  }
}
</style>