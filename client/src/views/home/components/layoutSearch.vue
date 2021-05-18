<template>
  <div class="serach_wrapper">
    <el-input placeholder="请输入内容" v-model="inpVal">
      <template #append>
        <el-button icon="el-icon-search" @click="handlerQuery"></el-button>
      </template>
    </el-input>
  </div>
</template>

<script>
import { defineComponent, ref } from "vue";
export default defineComponent({
  name: "layoutSearch",
  setup(props, { emit }) {
    const inpVal = ref("");

    const handlerQuery = () => {
      emit("search", inpVal.value);
    }

    return { inpVal, handlerQuery };
  }
})
</script>

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
