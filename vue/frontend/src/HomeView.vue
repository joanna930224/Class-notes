<template>
  <v-container>
    <div class="home">
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/test">Test</router-link> |
        <router-link to="/components-test">Component Test</router-link> |
        <router-link to="/concave-board-game">오목 게임</router-link> |
        <router-link to="/vue2spring">Vue 2 Spring 통신 테스트</router-link> |
        <router-link to="/rpg-game">RPG Game</router-link> |
        <router-link to="/vue2spring-data-send-test">Vue 2 데이터 전송 테스트</router-link> |
        <router-link to="/board-list">게시판</router-link> |
        <router-link to="/product-board-list">상품 게시판</router-link> <br>
        <router-link to="/vuetify-taste">뷰티파이</router-link> |
        <router-link to="/swiper-test">Swiper 테스트</router-link> |
        <router-link to="/calendar-test">달력 테스트</router-link> |
        <router-link to="/image-gallery-test">이미지 갤러리 테스트</router-link> |
        <router-link to="/file-upload-test">파일 업로드 테스트</router-link> |
        <router-link to="/sign-up">회원 가입</router-link> |
      </nav>
    <router-view/>
  </div>
  </v-container>
</template>

<script>
// @ is an alias to /src

// src/plugins/vuetify.js

import Vue from'vue'
import Vuetify from 'vuetify/lib'

Vue.use(Vuetify)

export default new Vuetify({
  theme: {dark:true},
  name: 'HomeView',
  components: {}
})
</script>
