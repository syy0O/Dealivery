<template>
  <div id="top">
    <div class="css-n48rgu">
      <div class="css-16c0d8l">
        <main id="product-atf" class="css-1eoy87d">
          <BoardDetailThumnailComponent />
          <BoardDetailProductInfoComponent />
        </main>
        <nav class="css-1le17tz en4zazl1">
          <ul class="css-tse2s2 en4zazl0">
            <li
              :class="[
                'css-1tzhzcg',
                'efe6b6j1',
                'tab',
                { active: activeTab === 'description' },
              ]"
              @click.prevent="activeTab = 'description'"
            >
              <a class="css-1t0ft7s efe6b6j0"
                ><span class="name">상품설명</span></a
              >
            </li>
            <li
              :class="[
                'css-1tzhzcg',
                'efe6b6j1',
                'tab',
                { active: activeTab === 'inquiries' },
              ]"
              @click.prevent="activeTab = 'inquiries'"
            >
              <a class="css-1t0ft7s efe6b6j0"><span class="name">문의</span></a>
            </li>
          </ul>
        </nav>
        <div class="css-0 el27cq1">
          <div
            id="description"
            class="css-18eozqj el27cq0"
            v-show="activeTab === 'description'"
          >
            <div class="css-1d3w5wq e1d86arr0">
              <div class="css-1lyi66c">
                <div class="goods_wrap">
                  <div class="goods_note">
                    <div class="context">
                      <div class="pic">
                        <img
                          src="https://img-cf.kurly.com/hdims/resize/%3E1010x/quality/90/src/shop/data/goodsview/20240829/gv10001551896_1.jpg"
                        />
                      </div>
                      <p class="words"></p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="css-8k5a6c ezy1ugy1"></div>
          </div>
        </div>

        <!--문의 하기 리스트-->
        <div class="css-30tvht eewa3w91" v-show="activeTab === 'inquiries'">
          <div class="css-17juoyc eewa3w90">
            <button
              class="css-mhrz8m e4nu7ef3"
              type="button"
              width="120"
              height="40"
            >
              <span class="css-nytqmg e4nu7ef1">문의하기</span>
            </button>
          </div>
          <div class="css-pncj1z eu9pqlw4">
            <strong class="css-83ihkd eu9pqlw3">상품 문의</strong>
            <ul class="css-8sw7yu eu9pqlw2">
              <li class="css-owypta eu9pqlw1">
                상품에 대한 문의를 남기는 공간입니다. 해당 게시판의 성격과 다른
                글은 사전동의 없이 담당 게시판으로 이동될 수 있습니다.
              </li>
            </ul>
          </div>
          <div class="css-0 e1wj4bbj2">
            <table class="css-1d3w5wq e1wj4bbj1">
              <thead class="css-1xukm34 e1wj4bbj0">
                <tr>
                  <th class="title">제목</th>
                  <th class="author">작성자</th>
                  <th class="created-date">작성일</th>
                  <th class="status">답변상태</th>
                </tr>
              </thead>
              <tbody>
                <tr class="css-atz965 e1l5ky7y9">
                  <td class="css-1brd6ns e1l5ky7y8">아이도</td>
                  <td class="css-1pkqelu e1l5ky7y7">엄*희</td>
                  <td class="css-1pkqelu e1l5ky7y6">2022.04.20</td>
                  <td class="css-bhr3cq e1l5ky7y5">답변완료</td>
                </tr>
                <tr class="css-atz965 e1l5ky7y9">
                  <td class="css-1brd6ns e1l5ky7y8">아이도</td>
                  <td class="css-1pkqelu e1l5ky7y7">엄*희</td>
                  <td class="css-1pkqelu e1l5ky7y6">2022.04.20</td>
                  <td class="css-bhr3cq e1l5ky7y5">답변완료</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="css-18ad0gx e9e6ap50">
            <div class="css-sxxs1g eytury60">
              <button disabled="" type="button" class="css-rzcdhr e1hbwyso0">
                <div class="css-7qb0sc e1ilyb3p0">이전</div></button
              ><button disabled="" type="button" class="css-1jwilit e1pk9060">
                <div class="css-7qb0sc e1ilyb3p0">다음</div>
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import BoardDetailThumnailComponent from "@/components/board/BoardDetailThumnailComponent.vue";
import BoardDetailProductInfoComponent from "@/components/board/BoardDetailProductInfoComponent.vue";

export default {
  name: "OrdersPage",
  props: {
    msg: String,
  },
  components: {
    BoardDetailThumnailComponent,
    BoardDetailProductInfoComponent,
  },
  data() {
    return {
      activeTab: "description", // 초기에는 '상품설명' 탭이 활성화됨
    };
  },
};
</script>
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

/*상품 설명 (오른쪽 section)*/
.css-1ua1wyk {
  width: 560px;
}

.deal {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  overflow: hidden;
  position: relative;
  height: 50px;
  margin-bottom: 16px;
  background-color: rgba(189, 118, 255, 0.08);
  padding: 0 10px;
}

.deal p {
  margin: 0;
}

p.buy {
  font-size: 16px;
  color: #5f0080;
  font-weight: bold;
}

.deal p.buy:after {
  display: inline-block;
  width: 1px;
  height: 15px;
  margin-left: 9px;
  background: #5f0080;
  vertical-align: middle;
  content: "";
}

.deal p.time {
  margin-left: 20px;
}

.deal p.time:before {
  display: inline-block;
  width: 13px;
  height: 13px;
  margin-right: 12px;
  background: url(//static.wconcept.co.kr/web/images/common/spr-product.png) -330px -30px
    no-repeat;
  vertical-align: middle;
  content: "";
}

.tab.active {
  background: #fff; /* 활성화된 탭 배경색 */
}

.tab.active a span {
  color: #5f0080; /* 활성화된 탭 텍스트 색상 */
}

.css-1qy9c46 {
  position: relative;
  display: flex;
  flex-direction: column;
  overflow-wrap: break-word;
}

.css-13lg2xu {
  width: 500px;
  font-weight: 500;
  font-size: 24px;
  color: rgb(51, 51, 51);
  line-height: 34px;
  letter-spacing: -0.5px;
  margin: 0px 20px 0px 0px;
}

.css-1q0tnnd {
  width: 500px;
  font-size: 14px;
  font-weight: 400;
  color: rgb(181, 181, 181);
  line-height: 19px;
  letter-spacing: -0.5px;
  margin-top: 4px;
}

.css-abwjr2 {
  display: flex;
  flex-direction: row;
  align-items: flex-end;
  padding-top: 20px;
  font-weight: bold;
  line-height: 30px;
  letter-spacing: -0.5px;
}

.css-5nirzt {
  padding-right: 9px;
  font-size: 28px;
  color: rgb(250, 98, 47);
}

.css-9pf1ze {
  padding-right: 4px;
  font-size: 28px;
  color: rgb(51, 51, 51);
}

.css-1x9cx9j {
  display: inline-block;
  position: relative;
  top: 3px;
  font-size: 18px;
  color: rgb(51, 51, 51);
  vertical-align: top;
}

.css-1e1rd4p {
  display: flex;
  flex-direction: row;
  margin-top: 8px;
}

.css-1e1rd4p > span {
  font-size: 16px;
  color: rgb(181, 181, 181);
  letter-spacing: -0.5px;
  text-decoration: line-through;
  margin-right: 1px;
}

.css-iqoq9n {
  margin-top: 20px;
}

.css-e6zlnr {
  display: flex;
  flex: 1 1 0%;
  flex-direction: row;
  align-items: flex-start;
  overflow: hidden;
  width: 100%;
  padding: 17px 0px 18px;
  border-top: 1px solid rgb(244, 244, 244);
  font-size: 14px;
  letter-spacing: -0.5px;
}

.css-1k8t52o {
  display: flex;
  flex: 1 1 0%;
  flex-direction: column;
}

.css-c02hqi {
  color: rgb(51, 51, 51);
  font-weight: 400;
  line-height: 19px;
  white-space: pre-line;
  word-break: break-all;
  overflow: hidden;
}

.css-lytdfk {
  width: 128px;
  height: 100%;
  color: rgb(102, 102, 102);
  font-weight: 400;
  line-height: 19px;
}

/*상품 선택 옵션*/

.css-2lvxh7 {
  border-bottom: 1px solid rgb(244, 244, 244);
}

.css-159o541 {
  width: 128px;
  height: 100%;
  color: rgb(102, 102, 102);
  font-weight: 400;
  line-height: 40px;
}

.css-tzsjye {
  display: inline-flex;
  flex-direction: column;
  position: relative;
  min-width: 0px;
  padding: 0px;
  margin: 0px;
  border: 0px;
  vertical-align: top;
  width: 100%;
}

.css-183fdlo .MuiOutlinedInput-root {
  height: 40px;
}

.jss1 {
  font-family: Noto Sans KR;
}

.css-xald09 {
  font-family: Roboto, Helvetica, Arial, sans-serif;
  font-weight: 400;
  line-height: 1.4375em;
  letter-spacing: 0.00938em;
  color: rgba(0, 0, 0, 0.87);
  box-sizing: border-box;
  cursor: text;
  display: inline-flex;
  -webkit-box-align: center;
  align-items: center;
  position: relative;
  font-size: 12px;
  height: 44px;
  border-color: rgb(221, 221, 221);
  border-radius: 0px;
}

.css-qiwgdb.css-qiwgdb.css-qiwgdb {
  padding-right: 32px;
}

.css-qiwgdb.MuiSelect-select {
  height: auto;
  min-height: 1.4375em;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}

.css-qiwgdb {
  appearance: none;
  user-select: none;
  border-radius: 4px;
  cursor: pointer;
  font: inherit;
  letter-spacing: inherit;
  color: currentcolor;
  border: 0px;
  box-sizing: content-box;
  background: none;
  height: 1.4375em;
  margin: 0px;
  -webkit-tap-highlight-color: transparent;
  display: block;
  min-width: 0px;
  width: 100%;
  animation-name: mui-auto-fill-cancel;
  animation-duration: 10ms;
  padding: 16.5px 14px;
}

.css-1k3x8v3 {
  bottom: 0px;
  left: 0px;
  position: absolute;
  opacity: 0;
  pointer-events: none;
  width: 100%;
  box-sizing: border-box;
}

svg:not(:root) {
  overflow: hidden;
}

.css-1636szt {
  user-select: none;
  width: 1em;
  height: 1em;
  display: inline-block;
  fill: currentcolor;
  flex-shrink: 0;
  font-size: 1.5rem;
  position: absolute;
  right: 7px;
  top: calc(50% - 0.5em);
  pointer-events: none;
  color: rgba(0, 0, 0, 0.54);
  transition: fill 200ms cubic-bezier(0.4, 0, 0.2, 1);
}

.jss1 .MuiOutlinedInput-notchedOutline {
  border-color: #ddd !important;
}

.css-igs3ac {
  text-align: left;
  position: absolute;
  inset: -5px 0px 0px;
  margin: 0px;
  padding: 0px 8px;
  pointer-events: none;
  border-radius: inherit;
  border-style: solid;
  border-width: 1px;
  overflow: hidden;
  min-width: 0%;
  border-color: rgba(0, 0, 0, 0.23);
}

fieldset {
  margin: 0;
  padding: 0;
}

.css-nnbavb {
  float: unset;
  line-height: 11px;
  padding: 0px;
  transition: width 150ms cubic-bezier(0, 0, 0.2, 1);
}

legend {
  box-sizing: border-box;
  color: inherit;
  display: table;
  max-width: 100%;
  padding: 0;
  white-space: normal;
}

legend {
  border: 0;
  vertical-align: top;
}

/*상품 가격 정보*/

.css-9y0nwt {
  padding-top: 30px;
}

.css-ixlb9s {
  letter-spacing: -0.5px;
}

.css-yhijln {
  display: flex;
  -webkit-box-pack: end;
  justify-content: flex-end;
  align-items: flex-end;
}

.css-w1is7v {
  padding-right: 12px;
  font-size: 13px;
  font-weight: 500;
  color: rgb(51, 51, 51);
  line-height: 20px;
}

.css-x4cdgl {
  font-weight: bold;
  font-size: 32px;
  color: rgb(51, 51, 51);
  line-height: 36px;
}

.css-1jb8hmu {
  padding-left: 5px;
  font-size: 20px;
  font-weight: 600;
  color: rgb(51, 51, 51);
  line-height: 30px;
}

.css-gnxbjx {
  display: flex;
  gap: 8px;
  margin-top: 40px;
  justify-content: flex-end;
  align-items: flex-end;
}

.css-3z91zj {
  display: block;
  padding: 0px 10px;
  text-align: center;
  overflow: hidden;
  width: 56px;
  height: 56px;
  border-radius: 3px;
  color: rgb(51, 51, 51);
  background-color: rgb(255, 255, 255);
  border: 1px solid rgb(221, 221, 221);
}

.css-nytqmg {
  display: inline-block;
  font-size: 16px;
  font-weight: 500;
}

.cart-button {
  font-weight: 500;
}

@media (min-width: 1050px) {
  .css-1qirdbn {
    height: 56px;
  }
}

.css-1qirdbn {
  display: block;
  padding: 0 10px;
  text-align: center;
  overflow: hidden;
  width: 60%;
  height: 52px;
  border-radius: 3px;
  color: #fff;
  background-color: #5f0080;
  border: 0 none;
}

.css-nytqmg {
  display: inline-block;
  font-size: 16px;
  font-weight: 500;
}

/*상품 세부 리스트*/
.css-185tsxr {
  /*리스트 박스*/
  background-color: rgb(255, 255, 255);
  color: rgba(0, 0, 0, 0.87);
  box-shadow: rgba(0, 0, 0, 0.2) 0px 5px 5px -3px,
    rgba(0, 0, 0, 0.14) 0px 8px 10px 1px, rgba(0, 0, 0, 0.12) 0px 3px 14px 2px;
  overflow-y: auto;
  overflow-x: hidden;
  min-width: 16px;
  min-height: 16px;
  max-width: calc(100% - 32px);
  max-height: calc(100% - 32px);
  transition: box-shadow 300ms cubic-bezier(0.4, 0, 0.2, 1);
  border-radius: 4px;
  outline: 0px;
}

.css-185tsxr ul {
  padding: 0px;
}

.css-r8u8y9 {
  list-style: none;
  margin: 0px;
  padding: 8px 0px;
  position: relative;
  outline: 0px;
}

.css-185tsxr ul li.MuiMenuItem-root:not(:last-of-type) {
  border-bottom: 1px solid rgb(244, 244, 244);
}

.css-185tsxr ul > li {
  font-family: "Noto Sans KR";
}

@media (min-width: 600px) {
  .css-1p79lf5 {
    min-height: auto;
  }
}

.css-1p79lf5 {
  -webkit-tap-highlight-color: transparent;
  background-color: transparent;
  outline: 0px;
  border: 0px;
  margin: 0px;
  border-radius: 0px;
  user-select: none;
  vertical-align: middle;
  appearance: none;
  font-family: Roboto, Helvetica, Arial, sans-serif;
  font-weight: 400;
  line-height: 1.5;
  letter-spacing: 0.00938em;
  display: flex;
  -webkit-box-pack: start;
  justify-content: flex-start;
  -webkit-box-align: center;
  align-items: center;
  position: relative;
  text-decoration: none;
  min-height: 48px;
  box-sizing: border-box;
  font-size: 12px;
  padding: 0px;
  color: rgb(51, 51, 51);
  white-space: normal;
  cursor: pointer;
}

.css-15h3zi {
  width: 100%;
  padding: 14px 16px 12px 15px;
}

.css-185tsxr ul li.MuiMenuItem-root:not(:last-of-type) {
  border-bottom: 1px solid rgb(244, 244, 244);
}

.css-unrh3l {
  display: flex;
  -webkit-box-pack: justify;
  justify-content: space-between;
  width: 100%;
}

.css-19h9nlb {
  width: 240px;
  line-height: 16px;
  font-size: 12px;
  letter-spacing: -0.5px;
  overflow-wrap: break-word;
}

.css-t4macj {
  display: flex;
  flex-shrink: 0;
  gap: 4px;
}

.css-1fvrsoi {
  font-size: 12px;
  font-weight: bold;
  letter-spacing: -0.5px;
  color: rgb(51, 51, 51);
}

.css-w0pj6f {
  overflow: hidden;
  pointer-events: none;
  position: absolute;
  z-index: 0;
  inset: 0px;
  border-radius: inherit;
}

/*추가된 리스트 - 수량 조절할 수 있는 */

.css-j9a02z {
  margin-top: 6px;
}

.css-1cb5lnc:last-of-type {
  border-bottom: 1px solid rgb(244, 244, 244);
}

.css-1cb5lnc {
  display: flex;
  flex-direction: column;
  -webkit-box-pack: justify;
  justify-content: space-between;
  padding: 11px 10px 11px 15px;
  font-size: 12px;
  border-left: 1px solid rgb(244, 244, 244);
  border-top: 1px solid rgb(244, 244, 244);
  border-right: 1px solid rgb(244, 244, 244);
}

.css-1qdyvok {
  display: flex;
  -webkit-box-pack: justify;
  justify-content: space-between;
  align-items: flex-start;
}

.css-1yojl0t {
  line-height: 16px;
  width: 320px;
  min-height: 24px;
  color: rgb(51, 51, 51);
  overflow-wrap: break-word;
}

.css-rrel8y {
  width: 24px;
  height: 24px;
  background: transparent;
  border: none;
}

.css-tk6lxo {
  display: flex;
  -webkit-box-pack: justify;
  justify-content: space-between;
  -webkit-box-align: center;
  align-items: center;
  padding-top: 4px;
}

.css-nx0orh {
  display: inline-flex;
  flex-direction: row;
  -webkit-box-align: center;
  align-items: center;
  border: 1px solid rgb(221, 223, 225);
  width: 88px;
  border-radius: 3px;
}

.css-8azp8 {
  display: inline-flex;
  width: 28px;
  height: 28px;
  border: none;
  font-size: 1px;
  color: transparent;
  background-size: cover;
  background-color: transparent;
  background-image: url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iIzMzMyIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=);
  vertical-align: top;
}

.css-6m57y0 {
  display: inline-flex;
  overflow: hidden;
  white-space: nowrap;
  -webkit-box-pack: center;
  justify-content: center;
  font-size: 14px;
  font-weight: 600;
  color: rgb(51, 51, 51);
  text-align: center;
  width: 31px;
  height: 28px;
  line-height: 28px;
}

.css-18y6jr4 {
  display: inline-flex;
  width: 28px;
  height: 28px;
  border: none;
  font-size: 1px;
  color: transparent;
  background-size: cover;
  background-color: transparent;
  background-image: url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0xNiAxMHY0aDR2MmgtNHY0aC0ydi00aC00di0yaDR2LTRoMnoiIGZpbGw9IiMzMzMiIGZpbGwtcnVsZT0ibm9uemVybyIvPgo8L3N2Zz4K);
  vertical-align: top;
}

.css-1jzvrpg {
  padding-top: 4px;
}

.css-gqkxk8 {
  font-weight: bold;
  font-size: 12px;
  color: rgb(51, 51, 51);
  padding-right: 4px;
}

/*문의 nav*/
.css-1le17tz {
  z-index: 20;
  top: 56px;
  width: 1010px;
  box-shadow: inset 0 -0.5px 0 0 #ddd;
  background-color: #fff;
  margin-top: 50px;
  margin-bottom: 50px;
}

.css-tse2s2 {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-flex-wrap: wrap;
  -webkit-flex-wrap: wrap;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  height: 60px;
}

.css-1tzhzcg {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-flex: 1;
  -ms-flex: 1;
  flex: 1;
  border-width: 1px 0 1px 1px;
  border-color: #eee;
  border-style: solid;
  background-color: #fafafa;
}

.css-1tzhzcg:last-of-type {
  border-right-width: 1px;
}

.css-1t0ft7s {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-flex: 1;
  -ms-flex: 1;
  flex: 1;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
  -webkit-align-items: center;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  height: 100%;
}

.css-1tzhzcg .name {
  font-size: 16px;
  font-weight: 500;
  color: #666;
}

/*문의 하기*/

.css-30tvht {
  margin-bottom: 60px;
  margin-top: 60px;
}

.css-17juoyc {
  position: absolute;
  right: 0;
}

.css-17juoyc button {
  /*문의 하기 버튼*/
  border-radius: 3px;
}

.css-mhrz8m {
  display: block;
  padding: 0 10px;
  text-align: center;
  overflow: hidden;
  width: 120px;
  height: 40px;
  border-radius: 3px;
  color: #fff;
  background-color: #5f0080;
  border: 0 none;
}

.css-17juoyc span {
  font-size: 14px;
}

.css-nytqmg {
  display: inline-block;
  font-size: 16px;
  font-weight: 500;
}

.css-pncj1z {
  padding-bottom: 40px;
  letter-spacing: -0.5px;
}

.css-83ihkd {
  display: block;
  padding-bottom: 16px;
  font-size: 24px;
  font-weight: 500;
  line-height: 21px;
  color: #333;
}

.css-8sw7yu {
  line-height: 19px;
  font-weight: 400;
  color: #999;
}

.css-owypta {
  padding-left: 10px;
}

/*문의 테이블*/
.css-1d3w5wq {
  width: 100%;
}

table {
  border-collapse: collapse;
  border-spacing: 0;
}

.css-1xukm34 {
  height: 58px;
  border-top: 2px solid #333;
  border-bottom: 1px solid #333;
}

.css-atz965 {
  height: 64px;
  border-bottom: 1px solid rgb(244, 244, 244);
  line-height: 19px;
  letter-spacing: -0.5px;
}

.css-sno6ed {
  text-align: left;
  padding: 0px 20px;
  cursor: pointer;
  color: rgb(153, 153, 153);
}

.css-s5xdrg {
  display: flex;
  -webkit-box-align: center;
  align-items: center;
}

.css-lrsm5m {
  display: block;
  width: 14px;
  height: 14px;
  background: url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTIiIGhlaWdodD0iMTQiIHZpZXdCb3g9IjAgMCAxMiAxNCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxnIGZpbGw9IiNCNUI1QjUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTTExLjA0MyAxMi41NzVhLjI1OS4yNTkgMCAwIDEtLjI1OC4yNTdIMS4yMTRhLjI1OS4yNTkgMCAwIDEtLjI1OC0uMjU3VjUuNDJjMC0uMTQyLjExNy0uMjU4LjI1OC0uMjU4aDkuNTdjLjE0NCAwIC4yNi4xMTYuMjYuMjU4djcuMTU1ek0zLjY4NSAzLjIzN0EyLjI4MyAyLjI4MyAwIDAgMSA1Ljk2Ni45NTdhMi4yODIgMi4yODIgMCAwIDEgMi4yODEgMi4yOHYuOTY4SDMuNjg1di0uOTY4em03LjEuOTY4aC0xLjU4di0uOTY4QTMuMjQxIDMuMjQxIDAgMCAwIDUuOTY1IDAgMy4yNCAzLjI0IDAgMCAwIDIuNzMgMy4yMzd2Ljk2OEgxLjIxNEMuNTQ0IDQuMjA1IDAgNC43NSAwIDUuNDJ2Ny4xNTVjMCAuNjY5LjU0NSAxLjIxNCAxLjIxNCAxLjIxNGg5LjU3Yy42NzEgMCAxLjIxNi0uNTQ1IDEuMjE2LTEuMjE0VjUuNDJjMC0uNjctLjU0NS0xLjIxNS0xLjIxNS0xLjIxNXoiLz4KICAgICAgICA8cGF0aCBkPSJNNSA4LjJjMCAuMzQzLjE4NC42MzIuNDQ4LjgxMnYxLjMzaDEuMTAzdi0xLjMzQS45ODYuOTg2IDAgMCAwIDcgOC4yYTEgMSAwIDAgMC0yIDB6Ii8+CiAgICA8L2c+Cjwvc3ZnPgo=)
    no-repeat;
  margin-left: 6px;
}

.css-1pkqelu {
  text-align: center;
  color: rgb(153, 153, 153);
}

.css-bhr3cq {
  text-align: center;
  color: rgb(95, 0, 128);
}

.css-18ad0gx {
  position: relative;
  width: 100%;
  height: 44px;
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
  -webkit-align-items: center;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  margin-top: 20px;
}

.css-rzcdhr:disabled {
  background-image: url(https://res.kurly.com/kurly/ico/2021/paging-prev-disabled.svg);
  cursor: default;
}

.css-rzcdhr {
  width: 44px;
  height: 44px;
  padding: 0;
  margin: 0;
  border: 0;
  cursor: pointer;
  background-color: transparent;
  background-image: url(https://res.kurly.com/kurly/ico/2021/paging-prev-activated.svg);
  background-repeat: no-repeat;
  -webkit-background-size: cover;
  background-size: cover;
}

.css-1jwilit:disabled {
  background-image: url(https://res.kurly.com/kurly/ico/2021/paging-next-disabled.svg);
  cursor: default;
}

.css-sxxs1g button + button {
  margin-left: 12px;
}

.css-1jwilit {
  width: 44px;
  height: 44px;
  padding: 0;
  margin: 0;
  border: 0;
  cursor: pointer;
  background-color: transparent;
  background-image: url(https://res.kurly.com/kurly/ico/2021/paging-next-activated.svg);
  background-repeat: no-repeat;
  -webkit-background-size: cover;
  background-size: cover;
}

.css-7qb0sc {
  overflow: hidden;
  position: absolute;
  left: -9999px;
  width: 1px;
  height: 1px;
}
</style>
