<template>
  <div>
    <div class="header">
      <ul class="header_commin_seccion" v-if="!userInfo.username">
        <li class="item">
          <router-link to="/login">
            <el-button type="text">登录</el-button>
          </router-link>
        </li>
        <li class="item">
          <router-link to="/register">
            <el-button type="text">请注册</el-button>
          </router-link>
        </li>
      </ul>
      <div class="header_commin_seccion" v-else>
        <el-avatar icon="el-icon-user-solid"></el-avatar>
        <el-button type="text" class="user_name">【{{userInfo.username}}】</el-button>
        <span class="sign_out" @click="signOut">退出</span>
      </div>
    </div>
  </div>
</template>

<script>
import { defineComponent, reactive, toRefs } from "vue";
import { useStore } from 'vuex';

import { postSignOut } from "@/api/user"

export default defineComponent({
  name: "home",
  setup() {

    const store = useStore();

    const state = reactive(store.state.user);
    const signOut = () => {
      postSignOut().then(({ flag }) => {
        if ( flag ) {
          store.dispatch('user/signOut')
        }
      })
    }

    console.log( state );

    return {...toRefs(state), signOut};
  }
})
</script>

<style lang="less" scope>
  .header {
    height: 60px;
    padding: 0 30px;
    line-height: 60px;
    background: rgba(246, 246, 246);

    .header_commin_seccion {
      display: flex;
      align-items:center;
      justify-content: flex-end;
      height: 100%;

      .item {
        padding: 0 10px;
      }

      .user_name {
        padding: 0 10px;
      }

      .sign_out {
        cursor: pointer;
      }
    }
  }
</style>