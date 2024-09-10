import { defineStore } from "pinia";
import axios from "axios";
import * as PortOne from "@portone/browser-sdk/v2";

// const backend = "http://localhost:8080/api/orders";

export const useOrderStore = defineStore('order', {
    state: () => ({
        orderedProducts: [], orderIdx: 0, paymentId: ""
    }),
    actions: {
        async submitOrder(orderRequest) { // 주문 생성 : 백엔드에 주문 가능하면 200Ok, 재고 부족 or 이미 끝난 이벤트 : 400 error
            try {
                let response = await axios.post("https://run.mocky.io/v3/bba611fe-6871-4be8-9e5d-c9251ba9090a", orderRequest, { withCredentials: true });
                console.log("Response : " + response);

                if (response.data.code !== 1000) {
                    return false;
                }

                this.orderedProducts = orderRequest
                this.orderIdx = response.data.data.orderIdx

                return true;

            } catch (error) {
                alert("주문에 실패했습니다\n\n반복적인 문제 발생시 고객센터로 문의바랍니다.");
            }
        },

        async makePayment(orderRequest, orderIdx) {

            let paymentId = "order_no_000" + new Date().getMilliseconds()

            const response = await PortOne.requestPayment({
                customData: orderRequest,
                storeId: "store-8c0a9638-17bb-412d-ab8b-1182c979e43d",
                paymentId: paymentId,
                orderName: "이거되나",
                totalAmount: 13000,
                currency: "KRW",
                channelKey: "channel-key-87c03e5a-addd-4af6-bfb4-fe6af1de2cd5",
                payMethod: "EASY_PAY"
            });

            console.log(orderIdx)

            if (response.code != null) { // 결제 오류 발생

                //TODO: backend에 refund하는 함수 호출
                return alert(response.message);
            }

            //TODO: backend에 결제 검증하는 함수 호출 -> paymentId 넘기고, Orderid 넘김
            console.log("결제가 되긴 합니다!!!!!!!!")
        },
    }

});