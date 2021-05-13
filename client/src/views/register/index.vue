<template>
  <div class="from_wrapper">
    <div class="main_wrapper">
       <el-divider content-position="left">注册</el-divider>
      <el-form
        class="el_from_wrapper"
        ref="form"
        :rules="rules"
        :model="registerData"
        label-width="80px"
      >
        <el-form-item label="用户名" prop="username">
          <el-input v-model="registerData.username" size="small"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            v-model="registerData.password"
            size="small"
            type="password"
          ></el-input>
        </el-form-item>
        <el-form-item label="Email" prop="email">
          <el-input v-model="registerData.email" size="small"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="registerData.name" size="small"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="telephone">
          <el-input v-model="registerData.telephone" size="small"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-radio-group v-model="registerData.sex">
            <el-radio label="1">男</el-radio>
            <el-radio label="2">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="出生日期" prop="birthday">
          <el-date-picker
            v-model="registerData.birthday"
            type="date"
            placeholder="选择日期"
            size="small"
          ></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">创建用户</el-button>
        </el-form-item>
      </el-form>

      <comp-page-footer to="/login" subText="已经有账号了？" btnText="返回登录"/>

    </div>
  </div>
</template>

<script>
import { defineComponent, ref, reactive } from "vue";
import { ElMessage } from "element-plus";
import { postRegister } from "@/api/user";

import { rules } from '@/utils/validator';
import compPageFooter from '@/components/comp-page-footer';

import "./style.less";

export default defineComponent({
  name: "register",
  components: {compPageFooter},
  setup() {
    const form = ref(null);

    const registerData = reactive({
      username: new Date().getTime().toString(),
      password: "",
      name: "",
      birthday: "",
      sex: "1",
      telephone: "",
      email: "",
      code: "",
    });

    const methods = {
      onSubmit: () => {
        form.value.validate((valid) => {
          if (valid) {
            postRegister(registerData).then(({ flag, data }) => {
              if (flag) ElMessage.success({ message: data });
            });
          }
        });
      },
    };
    return { form, registerData, ...methods, rules };
  },
});
</script>

