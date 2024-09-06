import MainPage from "@/pages/MainPage.vue";
import OrdersPage from "@/pages/user/orders/OrdersPage.vue";
import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/", component: MainPage,
      children: [
        { path: "orders", component: OrdersPage }
      ]
    },

  ]
});

export default router;