<template>
  <div>
    <layoutHeader />
    <layoutSearch />
    <layoutCategory />

    <router-view />

  </div>
</template>

<script>
import { defineComponent } from "vue";
import basicComp from "./components"

export default defineComponent({
  name: "home",
  components: {...basicComp},
  setup() {
    
  }
})
</script>

<style lang="less" scope>
</style>