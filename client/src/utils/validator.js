
export const validatorEmial = (rule, value, callback) => {
  const reg_email = /^\w+@\w+\.\w+$/;
  !reg_email.test(value) ? callback(new Error("请输入正确的邮箱")) : callback();
};

export const rules = {
  username: [{
      required: true,
      message: "请输入用户名",
      trigger: "blur"
    },
    {
      min: 3,
      max: 13,
      message: "最大长度3-13位置",
      trigger: "blur"
    },
  ],
  password: [{
      required: true,
      message: "请输入密码",
      trigger: "blur"
    },
    {
      min: 3,
      max: 8,
      message: "最大长度3-8位置",
      trigger: "blur"
    },
  ],
  email: [{
      required: true,
      message: "请输入邮箱",
      trigger: "blur"
    },
    {
      validator: validatorEmial,
      trigger: "blur"
    },
  ],
  name: [{
    required: true,
    message: "请输入姓名",
    trigger: "blur"
  }],
  telephone: [{
      required: true,
      message: "请输入手机号",
      trigger: "blur"
    },
    {
      min: 11,
      max: 11,
      message: "请输入手机号",
      trigger: "blur"
    },
  ],
  birthday: [{
    required: true,
    type: "date",
    message: "请输入手机号",
    trigger: "blur"
  }, ],
};