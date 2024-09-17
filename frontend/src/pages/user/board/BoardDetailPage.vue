<template>
  <HeaderComponent />
  <div id="top">
    <div class="css-n48rgu">
      <div class="css-16c0d8l">
        <main id="product-atf" class="css-1eoy87d">
          <BoardDetailThumnailComponent :thumbnails="thumbnails" />
          <BoardDetailProductInfoComponent @submitOrder="submitOrder" />
        </main>
        <BoardDetailNavComponent :tableData="qnaStore.inquiries" />
      </div>
    </div>
  </div>
  <FooterComponent />
</template>

<script>
import HeaderComponent from "@/components/common/HeaderComponent.vue";
import FooterComponent from "@/components/common/FooterComponent.vue";
import BoardDetailThumnailComponent from "@/components/board/BoardDetailThumnailComponent.vue";
import BoardDetailProductInfoComponent from "@/components/board/BoardDetailProductInfoComponent.vue";
import BoardDetailNavComponent from "@/components/board/BoardDetailNavComponent.vue";

import { useOrderStore } from "@/stores/useOrderStore";
import { useQnaStore } from "@/stores/useQnaStore";
import { mapStores } from "pinia";

export default {
  name: "BoardDetailPage",
  components: {
    HeaderComponent,
    FooterComponent,
    BoardDetailThumnailComponent,
    BoardDetailProductInfoComponent,
    BoardDetailNavComponent,
  },
  computed: {
    ...mapStores(useOrderStore, useQnaStore),
  },
  async mounted() {
    // 페이지가 로드될 때 fetchInquiries를 호출
    await this.qnaStore.fetchInquiries();
  },
  data() {
    return {
      activeTab: "description",
      thumbnails: [
        {
          src: "https://product-image.kurly.com/hdims/resize/%5E%3E720x%3E936/cropcenter/720x936/quality/85/src/product/image/c0599d4f-d892-4d43-a22d-277459e929bd.jpg",
        },
        {
          src: "https://pbs.twimg.com/media/EE0R8XcU0AAlbth.jpg",
        },
      ],
<<<<<<< HEAD
      tableData: [
        {
          title: "배송문의드립니다",
          content: "지금 주문하면 배송 며칠 정도 걸리나요?",
          author: "송나경",
          created_at: "2024.09.03",
          answer_status: "답변완료",
        },
        {
          title: "상품보관 문의드려요.",
          content: "냉장보관해야되나요?",
          author: "심키즈",
          created_at: "2024.09.04",
          answer_status: "답변완료",
        },
      ],
=======

>>>>>>> 91d9b35893d19ca95ff1f6a5b529803c7cc8e9b0
    };
  },
  methods: {
    async submitOrder(cartItems) {
      console.log(cartItems);
      let result = await this.orderStore.submitOrder(cartItems);
      if (result) {
        console.log("[SUCCESS] 주문 생성 성공");
        this.$router.push("/orders");
      } else {
        console.log("[ERROR] 주문 생성 실패");
      }
    },

  },
};
</script>

<<<<<<< HEAD
=======

>>>>>>> 91d9b35893d19ca95ff1f6a5b529803c7cc8e9b0
<style scoped>
/*공통 부분*/
* {
  margin: 0;
}

img {
  border-style: none;
}

section {
  display: block;
}

ol,
ul {
  list-style-type: none;
  padding: 0;
}

.css-n48rgu {
  width: 100%;
  position: relative;
}

.css-16c0d8l {
  position: relative;
  width: 1050px;
  margin: 0px auto;
  padding-top: 30px;
}

.css-1eoy87d {
  display: flex;
  -webkit-box-pack: justify;
  justify-content: space-between;
}
</style>
