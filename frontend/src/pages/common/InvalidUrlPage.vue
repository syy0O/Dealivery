<template>
  <HeaderComponent></HeaderComponent>
  <InvalidUrlComponent></InvalidUrlComponent>
  <FooterComponent></FooterComponent>
</template>

<script>
import HeaderComponent from "@/components/common/HeaderComponent.vue";
import FooterComponent from "@/components/common/FooterComponent.vue";
import InvalidUrlComponent from "@/components/common/InvalidUrlComponent.vue";

export default {
  name: "InvalidUrlPage",
  components: {
    HeaderComponent,
    InvalidUrlComponent,
    FooterComponent,
  },
};
</script>

<style scoped>

</style>
