<template>
  <el-result :icon="icon" :title="title" :subTitle="subTitle">
    <template #extra>
      <router-link to="/login" v-if="isShowBtn">
        <el-button type="primary" size="medium">确定</el-button>
      </router-link>
    </template>
  </el-result>
</template>

<script>
import { defineComponent, reactive, toRefs } from "vue";
import { useRoute } from "vue-router";

import { postActiveUser } from "@/api/user";

export default defineComponent({
  name: "active",
  setup() {
    const route = useRoute();

    let activeMsg = reactive({
      icon: "success",
      title: "激活成功",
      subTitle: "可前往主页进行登录",
      isShowBtn: true,
    });

    postActiveUser(route.query).then((res) => {
      if (!res.flag) {
        Object.assign(activeMsg, {
          icon: "error",
          title: "激活失败",
          subTitle: "邮件激活码不正确，请联相关系管理员",
          isShowBtn: false,
        });
      }
    });
    return { ...toRefs(activeMsg) };
  },
});
</script>

<style lang="less" scope>
.active_wrapper {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100vw;
  height: 100vh;
  overflow: hidden;
}
</style>