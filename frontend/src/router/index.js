import LoginComponent from "@/components/user/LoginComponent.vue";
import AuthPage from "@/pages/common/AuthPage.vue";
import MainPage from "@/pages/common/MainPage.vue";
import MyPage from "@/pages/user/MyPage.vue";
import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/", component: MainPage,
    },

    {
      path: "/auth", component: AuthPage,
      children: [
        { path: "login", component: LoginComponent, meta: { requiresAuth: false } },
        { path: "", redirect: "/auth/login", meta: { requiresAuth: false } },
      ]
    },

    {
      path: "/mypage", component: MyPage,
    },

  ]
});

export default router;