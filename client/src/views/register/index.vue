<template>
  <div class="register_wrapper">
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
        <el-input v-model="registerData.password" size="small" type="password"></el-input>
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
  </div>
</template>

<script>
import { defineComponent, ref, reactive } from "vue";

import { postRegister } from '@/api/register';

import "./style.less";

const validatorEmial = (rule, value, callback) => {
	const reg_email = /^\w+@\w+\.\w+$/;
  !reg_email.test(value) ? callback(new Error('请输入正确的邮箱')) : callback();
}

const rules = {
  username: [
    { required: true, message: "请输入用户名", trigger: "blur" },
    { min: 3, max: 13, message: "最大长度3-6位置", trigger: "blur" }
  ],
  password: [
    { required: true, message: "请输入密码", trigger: "blur" },
    { min: 3, max: 6, message: "最大长度3-6位置", trigger: "blur" },
  ],
  email: [
    { required: true, message: "请输入邮箱", trigger: "blur" },
    { validator: validatorEmial, trigger: "blur"}
  ],
  name: [
    { required: true, message: "请输入姓名", trigger: "blur" },
  ],
  telephone: [
    { required: true, message: "请输入手机号", trigger: "blur" },
    { min: 11, max: 11, message: "请输入手机号", trigger: "blur" },
  ],
  birthday: [
    { required: true, type: "date",  message: "请输入手机号", trigger: "blur" }
  ]
};

export default defineComponent({
  name: "register",
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
        form.value.validate(valid => {
          if (valid) {
            postRegister(registerData);
          } else {
            console.log("中心");
          }
        })
      },
    };

    return { form, registerData, ...methods, rules };
  },
});
</script>

