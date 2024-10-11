import { defineStore } from "pinia";
import axios from "axios";
const backend = "/queue";

export const useQueueStore = defineStore("queue", {
    state: () => ({
        rank: 0,
        updatedTime: '',
        progress: 0,
        exitQueue: false,
    }),
    actions: {
        async isAllowed(boardIdx, userIdx) {
            try {

                let response = await axios.get(backend + "/waiting-room", {
                    params: {
                        boardIdx: boardIdx,
                        userIdx: userIdx,
                    },
                    withCredentials: true,  // 쿠키를 함께 전송
                });

                if (response.data.code === 1000 || response.data.result.rank <= 1) {
                    console.log(response.data)
                    return true;
                }

                return false;

            } catch {
                return false;
            }

        },

        // 서버에서 대기 순번을 받아오는 함수
        async updateWaitingQueue(boardIdx, userIdx) {


            console.log("boardIdx ====> " + boardIdx)
            console.log("userIdx ====> " + userIdx)


            try {

                let response = await axios.get(backend + "/rank", {
                    params: {
                        boardIdx: boardIdx,
                        userIdx: userIdx,
                    }
                });

                if (response.data.code === 1000) {
                    this.rank = 0;
                    this.updatedTime = new Date().toLocaleTimeString("ko-KR", {
                        hour: "2-digit",
                        minute: "2-digit",
                    });
                    this.exitQueue = true;

                    this.monitorCookieExpiration(boardIdx, userIdx);

                    console.log("빠져나가야햄!!")
                    return;

                }

                this.rank = response.data.result.rank;

                const maxCapacity = 300;
                this.progress = Math.min((this.rank / maxCapacity) * 100, 100);

                this.updatedTime = new Date().toLocaleTimeString("ko-KR", {
                    hour: "2-digit",
                    minute: "2-digit",
                });

            } catch (error) {
                console.error("Error fetching rank:", error);
            }
        },

        monitorCookieExpiration(boardIdx, userIdx) {
            const maxAgeSeconds = 300; // 쿠키 만료 시간 (초 단위)
            setTimeout(async () => {
                try {
                    await axios.post(backend + "/delete", {
                        boardIdx: boardIdx,
                        userIdx: userIdx
                    }, {
                        withCredentials: true
                    });
                    console.log("쿠키 만료됨, 백엔드에 키값 삭제 요청");
                } catch (error) {
                    console.error("쿠키 삭제 요청 실패:", error);
                }
            }, maxAgeSeconds * 1000); // 300초 후 실행 (쿠키 만료 시간)
        },

    },
});
