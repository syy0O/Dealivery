<template>
    <div class="page_aticle">
  <div class="page_section page_error">
    <div class="inner_section">
      <h3>찾으시는 페이지가 없습니다.</h3>
      <p>
        요청하신 페이지를 찾을 수 없습니다.
        <br>
        입력하신 경로가 정확한지 다시 한번 확인해 주시기 바랍니다.
      </p>
      <RouterLink to="/" class="btn_type1">
        <span class="txt_type">홈으로</span>
      </RouterLink>
    </div>
  </div>
</div>
    
</template>

<script>
export default {
name: 'InvalidUrlComponent',

}
</script>


<style scoped>
.page_aticle {
    width: 1050px;
    margin: 0 auto;
}

div, th, td, li, dt, dd, p {
    word-break: break-all;
}

*, *:after, *:before {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}

div {
    display: block;
    unicode-bidi: isolate;
}

body, input, select, textarea, button {
    font-family: 'Noto Sans', 'Malgun Gothic', AppleGothic, dotum;
    line-height: 1;
    letter-spacing: -0.05em;
    color: #4c4c4c;
    font-size: 12px;
    max-width: 100%;
}

.page_error {
    padding: 100px 0 100px;
    text-align: center;
    color: #333;
}

.page_aticle button, .page_aticle input, .page_aticle select, .page_aticle * {
    font-family: 'Noto Sans';
    font-weight: 400;
    letter-spacing: 0;
}

.page_error h3 {
    padding-bottom: 20px;
    font-weight: bold;
    font-size: 28px;
    color: #666;
}

h3 {
    display: block;
    font-size: 1.17em;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
    unicode-bidi: isolate;
}

.page_error h3:before {
    display: block;
    margin: 0 auto 22px;
    width: 100px;
    height: 100px;
    background: url(https://res.kurly.com/kurly/ico/2021/error_100_100_gray.svg) 0 0 no-repeat;
    content: "";
}

*, *:after, *:before {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}

.page_error p {
    padding-bottom: 30px;
    font-size: 16px;
    line-height: 23px;
    color: #b5b5b5;
}

.page_error .btn_type1 {
    margin: 0 auto;
    width: 150px;
    height: 44px;
}

.btn_type1 {
    border: 1px solid #5f0081;
    background-color: #5f0080;
}

.btn_type1, .btn_type2 {
    display: block;
    overflow: hidden;
    width: 100%;
    height: 54px;
    border-radius: 3px;
    font-size: 0;
    text-align: center;
}

a {
    background-color: transparent;
    text-decoration: none;
    color: inherit;
}

.page_error .btn_type1 .txt_type {
    line-height: 43px;
    font-size: 14px;
}

.btn_type1 .txt_type {
    color: #fff;
}

.btn_type1 .txt_type, .btn_type2 .txt_type {
    display: inline-block;
    height: 100%;
    font-weight: 500;
    font-size: 16px;
    color: #fff;
    line-height: 51px;
    text-align: center;
}
</style>
  