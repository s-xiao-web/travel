<template>
  <div class="btn-wrapper">
    <span>{{subText}}</span>
    <router-link :to="to">
      <el-button type="text">{{btnText}}</el-button>
    </router-link>
  </div>
</template>

<script>
import { defineComponent } from "vue";

import './style.less';

export default defineComponent({
  name: "comp-page-footer",
  props: {
    subText: {
      type: String,
      required: true,
    },
    btnText: {
      type: String,
      required: true,
    },
    to: {
      type: String,
      required: true,
    },
  },
});
</script>