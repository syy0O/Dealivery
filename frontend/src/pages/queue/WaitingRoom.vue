<template>
  <div v-if="isModalVisible" class="modal-overlay">
    <div class="modal-container" @click.stop tabindex="0" ref="modal">
      <div class="logo">
        <img :src="logo" alt="Logo" />
      </div>
      <h1>현재 대기 순번</h1>

      <div id="rank">{{ queueStore.rank.toLocaleString() }}</div>
      <p class="queue-info">접속 인원이 많습니다. 잠시만 기다려주세요.</p>

      <div class="waiting-bar-container">
        <div
          class="waiting-bar"
          :style="{ width: queueStore.progress + '%' }"
        ></div>
      </div>

      <p class="status-message">서버와 통신 중입니다. 곧 접속됩니다...</p>
      <p class="updated-time">
        업데이트: <span>{{ queueStore.updatedTime }}</span>
      </p>

      <div class="note">
        * 새로고침 시 대기 순번이 초기화됩니다.<br />
        * 접속이 완료될 때까지 페이지를 닫지 마세요.
      </div>

      <button @click="clickCloseBtn">닫기</button>
    </div>
  </div>
</template>

<script>
import { useQueueStore } from "@/stores/useQueueStore.js";
import { useUserStore } from "@/stores/useUserStore.js";
import { mapStores } from "pinia";

export default {
  props: {
    isModalVisible: {
      type: Boolean,
      default: false,
    },
    boardIdx: {
      type: Number,
      required: true,
    },
  },
  data() {
    return {
      logo: require("@/assets/logo-resize.png"),
      intervalId: null,
    };
  },
  computed: {
    ...mapStores(useQueueStore, useUserStore),
  },
  watch: {
    "queueStore.exitQueue"(newVal) {
      if (newVal) {
        this.closeModal(); // 모달 닫기
        clearInterval(this.intervalId); // 인터벌 해제
        this.$emit("emitOrder");
      }
    },
    isModalVisible(newVal) {
      if (newVal) {
        document.body.classList.add("modal-open");
        document.body.style.overflow = "hidden";

        const boardIdx = this.boardIdx;
        const userId = this.userStore.userDetail.userIdx;

        this.queueStore.updateWaitingQueue(boardIdx, userId);

        this.intervalId = setInterval(() => {
          this.queueStore.updateWaitingQueue(boardIdx, userId);
        }, 3000);
      } else {
        document.body.classList.remove("modal-open");
        document.body.style.overflow = "";

        clearInterval(this.intervalId); // 컴포넌트가 파괴될 때 인터벌 해제
      }
    },
  },
  methods: {
    clickCloseBtn() {
      const boardIdx = this.boardIdx;
      const userId = this.userStore.userDetail.userIdx;

      this.queueStore.exitQueue(boardIdx, userId);
      this.closeModal();
    },

    closeModal() {
      this.$emit("close");
      clearInterval(this.intervalId); // 인터벌 제거
      document.body.classList.remove("modal-open");
      document.body.style.overflow = "";
    },
  },
  beforeUnmount() {
    //clearInterval(this.intervalId); // 컴포넌트가 파괴될 때 인터벌 해제
  },
};
</script>

<style scoped>
/* Reset */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: "Noto Sans KR", sans-serif;
  background-color: #f9f9f9;
  overflow: hidden;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.5); /* 반투명 배경 */
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 9999;
}

.modal-container {
  background-color: #ffffff;
  border-radius: 20px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  padding: 40px;
  width: 350px;
  text-align: center;
  animation: slide-in 0.5s ease-out forwards;
  z-index: 10000;
}

@keyframes slide-in {
  from {
    transform: translateY(50px);
    opacity: 0;
  }
  to {
    transform: translateY(0);
    opacity: 1;
  }
}

h1 {
  font-size: 24px;
  margin-bottom: 20px;
  font-weight: bold;
  color: #5f0080; /* 컬리 보라색 */
}

.queue-info {
  font-size: 12px;
  color: #777;
  margin-bottom: 15px;
}

#rank {
  font-size: 48px;
  font-weight: 700;
  color: #5f0080; /* 컬리 보라색 */
  margin: 10px 0;
}

.waiting-bar-container {
  position: relative;
  background-color: #f1f1f1;
  border-radius: 30px;
  height: 12px;
  width: 100%;
  margin-bottom: 20px;
}

.waiting-bar {
  height: 100%;
  width: 0%;
  background: linear-gradient(
    90deg,
    #a64e9b,
    #5f0080
  ); /* 컬리 보라색 그라데이션 */
  border-radius: 30px;
  transition: width 0.4s ease-in-out;
}

.status-message {
  margin: 15px 0;
  font-size: 14px;
  color: #555;
}

.updated-time {
  font-size: 12px;
  color: #888;
  margin-top: 5px;
}

.note {
  margin-top: 20px;
  font-size: 12px;
  color: #999;
}

.logo {
  margin-bottom: 20px;
}

.logo img {
  width: 150px; /* 로고 크기 조정 */
}

button {
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #5f0080;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #a64e9b;
}
</style>
