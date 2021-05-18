<template>
  <div class="category_wrapper">
    <el-menu
      :default-active="activeIndex"
      @select="handleSelect"
      mode="horizontal"
      text-color="#fff"
      background-color="#545c64"
      active-text-color="#ffd04b"
      class="menu"
    >
      <el-menu-item
        v-for="item in menuData"
        :key="item.cname"
        :index="item.cid.toString()"
        >{{ item.cname }}</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import { defineComponent, ref, reactive, toRefs, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { getCategory } from "@/api/category";

export default defineComponent({
  name: "Category",
  setup() {
    
    const {query: { cid = "1" }} = useRoute();
    const router = useRouter();

    const activeIndex = ref(cid);
    const state = reactive({
      menuData: [],
    });

    const handleSelect = cid => {
      router.push({query:{cid}});
    };

    onMounted(() => {
      getCategory().then(({data}) => state.menuData = data);
    });

    return { activeIndex, handleSelect, ...toRefs(state) };
  },
});
</script>

<style lang="less" scope>
.category_wrapper {
  background-color: #545c64;
  .menu {
    display: flex;
    align-items: center;
    justify-content: space-around;
    width: 1200px;
    margin: 0 auto;
  }
  .el-menu.el-menu--horizontal {
    border: 0;
  }
}
</style>