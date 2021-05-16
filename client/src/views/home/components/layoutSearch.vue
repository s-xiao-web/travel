<template>
  <div class="serach_wrapper">
    <el-input placeholder="请输入内容">
      <template #append>
        <el-button icon="el-icon-search"></el-button>
      </template>
    </el-input>
  </div>
</template>

<style lang="less" scope>
  .serach_wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 30px 0;

    .el-input {
      width: 600px;
    }
  }
</style>
