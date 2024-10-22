<template>
  <router-view></router-view>
</template>

<script>
/* global IMP */
let isImpInitialized = false;

export default {
  name: "App",
  components: {},
  created() {
    if (!isImpInitialized) {
      IMP.init(process.env.VUE_APP_PORTONE_STORE_ID);
      isImpInitialized = true;
    }
  },
};
</script>

<style>
#app {
  display: flex;
  flex-direction: column;
}
</style>
