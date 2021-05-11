<template>
  <div class="register_wrapper">
    <el-form ref="form" :model="registerData" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="registerData.name"></el-input>
      </el-form-item>
    </el-form>

    <input type="text" name="" id="" v-model="inp">
    <button @click="showTest">按钮</button>
  </div>
</template>

<script>
import { defineComponent, reactive, ref } from "vue";

import "./style.less";

export default defineComponent({
  name: "register",
  setup() {
    const registerData = reactive({
      name: '',
    });

    const inp = ref("123")

    const showTest = (r) => {
      console.log(r);
      console.log(inp.value);
    }


    return { registerData, inp, showTest };
  },
});
</script>

