<template>
  <div class="from_wrapper">
    <div class="main_wrapper">
      <el-divider content-position="left">登陆</el-divider>
      <el-form
        class="el_from_wrapper"
        ref="form"
        :rules="rules"
        :model="loginData"
        label-width="80px"
      >
        <el-form-item label="用户名" prop="username">
          <el-input v-model="loginData.username" size="small"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            v-model="loginData.password"
            size="small"
            type="password"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">登录</el-button>
        </el-form-item>
      </el-form>
      <comp-page-footer
        to="/register"
        subText="还没有注册？"
        btnText="赶紧注册"
      />
    </div>
  </div>
</template>

<script>
import { defineComponent, reactive, ref } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { ElMessage } from "element-plus";

import { rules } from "@/utils/validator";
import compPageFooter from "@/components/comp-page-footer";
import { postLogin } from "@/api/user";

import "@/style/page/form_common_style.less";

export default defineComponent({
  name: "login",
  components: { compPageFooter },
  setup() {
    const form = ref();
    const router = useRouter();
    const store = useStore();
    const loginData = reactive({ username: "", password: "" });

    const methods = {
      onSubmit: () => {
        form.value.validate((valid) => {
          if (valid) {
            methods.fetchLogin();
          }
        });
      },

      fetchLogin() {
        postLogin(loginData).then(({ flag, data }) => {
          if (flag) {
            const { username } = data;
            store.dispatch("user/signIn", { payload: data });
            ElMessage.success({
              message: `登录成功~~ 欢迎 ${username} 回来！！！`,
              type: "success",
              onClose() {
                router.push("/");
              },
            });
          }
        });
      }
    };

    return { form, loginData, rules, ...methods };

  },
});
</script>