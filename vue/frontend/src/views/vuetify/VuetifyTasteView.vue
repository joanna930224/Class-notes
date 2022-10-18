<template>
  <v-container>
    <div>
      <p class="blue lighten-4 red--text">Test</p>
      <p class="blue white--text">Test</p>
      <p class="blue darken-3">Test</p>
      <p class="teal lighten-1 text-center">
        뷰.티.파.이!
      </p>
      <p class="purple darken-5 white--text">Test</p>

      <v-btn class="teal" rounded @click="btnClick">Round Button</v-btn>
      <v-btn class="indigo white--text">Basic Button</v-btn>
      <v-btn class="teal" text>기본 버튼</v-btn>
      <v-btn class="teal" dark>
        <!-- https://materialdesignicons.com/ -->
        <v-icon>mdi-battery-alert-variant-outline</v-icon>
        <span>배터리 교체</span>
      </v-btn>
      <v-btn fab color="orange" dark>
        <v-icon>mdi-bluetooth</v-icon>
      </v-btn>
    </div>

    <v-layout wrap>
      <v-flex class="primary white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="red white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="green white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="blue white--text">
        <div>Test</div>
      </v-flex>
    </v-layout>
    <v-layout wrap>
      <v-flex class="teal white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="red white--text">
        <div>Test</div>
      </v-flex>
    </v-layout>

    <v-layout justify-center>
      <v-dialog v-model="dialog" persisten max-width="400">
        <template v-slot:activator="{on}">
          <v-btn color="primary" dark v-on="on">결제</v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">
            {{ name }}
          </v-card-title>
          <v-card-text>
            오늘만 날이다! 먹고 죽엇! 할인 30%!!!
          </v-card-text>
          <v-card-text>
            지금 당장 결제 하시겠습니꽈 ?
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="teal darken-1" text @click="btnClick">
              취소
            </v-btn>
            <v-btn color="teal darken-1" text @click.native="btn_click($event)">
              결제 승인
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog><br/>
    </v-layout>

    <v-layout justify-center>
      <v-dialog v-model="loginDialog" persistent max-width="500px">
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark v-on="on">로그인</v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">
            <span>
              로그인
            </span>
          </v-card-title>
          <v-card-text>
            <v-text-field label="Email" v-model="email" required></v-text-field>
          </v-card-text>
          <v-card-text>
            <v-text-field label="Password" v-model="password" required></v-text-field>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="teal darken-1" text @click="btnClick">
              취소
            </v-btn>
            <v-btn color="teal darken-1" text @click="btnClick">
              로그인
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-layout>

    <v-toolbar dense dark>
      <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
      </v-app-bar-nav-icon>
      <v-toolbar-title>
        <span class="font-weight-light">최고의 여행!</span>
        <span>꿀팁</span>
      </v-toolbar-title>
      <v-toolbar-items>
        <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
          {{link.text}}
        </v-btn>
      </v-toolbar-items>
    </v-toolbar>
          <!-- 툴 바 안에 들어가는 카테고리 -->
    <v-navigation-drawer app v-model="nav_drawer" temporary>
      <v-list nav dense>
        <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
          <v-list-item-action>
            <v-icon left>
              {{ link.icon }}
            </v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              {{ link.text }}
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <div>
      <v-menu offset-y>
        <template v-slot:activator="{ on }">
          <v-btn color="teal darken-1" class="white --text ma-5" v-on="on">
            Drop Down
          </v-btn>
        </template>

        <v-list>
          <v-list-item v-for="(dropItem, index) in dropItems" :key="index" link>
            <v-list-item-title>
              {{ dropItem.title }}
            </v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </div>

    <v-data-table :headers="headerTitle"
                  :items="contents"
                  :items-per-page="10"
                  class="elevation-1">
    </v-data-table>


    <div>
      <v-img class="v-responsive-img" src="@/assets/img/caitlyn.jpg">
      </v-img>
      <div class="video-container">
        <iframe width="1200" height="720" src="https://www.youtube.com/embed/dKE55oypAjc"
          frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen>
        </iframe>
      </div>
    </div><br/>

    <div class="row">
      <div class="col-sm-2 green text-center">2</div>
      <div class="col-sm-2 blue text-center">2</div>
      <div class="col-sm-1 red text-center">1</div>
      <div class="col-sm-3 purple text-center">3</div>
      <div class="col-sm-4 yellow text-center">4</div>

      <div class="col-sm-1 green text-center">1</div>
      <div class="col-sm-2 blue text-center">2</div>
      <div class="col-sm-6 red text-center">6</div>
      <div class="col-sm-2 purple text-center">2</div>
      <div class="col-sm-1 yellow text-center">1</div>
    </div>

    <!-- npm add vue-coverflow -->
    <div>
      <coverflow :coverList="coverList" :coverWidth="260" :index="2"/>
    </div>
  </v-container>
</template>


<script>

import coverflow from 'vue-coverflow'

export default {
  name: "VuetifyTasteView",
  components: {
    coverflow
  },
    data() {
      return {
        coverList: [
          {
            cover: require('@/assets/img/caitlyn.jpg'),
            title: 'mario'
          },
          {
            cover: require('@/assets/logo.png'),
            title: 'logo'
          },
          {
            cover: require('@/assets/img/caitlyn.jpg'),
            title: 'mario'
          },
          {
            cover: require('@/assets/logo.png'),
            title: 'logo'
          },
          {
            cover: require('@/assets/img/caitlyn.jpg'),
            title: 'mario'
          },
          {
            cover: require('@/assets/logo.png'),
            title: 'logo'
          },
          {
            cover: require('@/assets/img/caitlyn.jpg'),
            title: 'mario'
          },
        ],
        headerTitle: [
          { text: '번호', value: 'boardNo', width: "70px"},
          { text: '제목', value: 'title', width: "200px"},
          { text: '작성자', value: 'writer', width: "100px"},
          { text: '내용', value: 'content', width: "100px"},
        ],
        contents: [
          { boardNo: 1, title: '먹은 거', writer: '케이틀린', content: '엽떡'},
          { boardNo: 2, title: '상태', writer: '카이사', content: '배아파'},
          { boardNo: 3, title: '맛', writer: '아펠리오스', content: '매워'},
          { boardNo: 4, title: '생각난 거', writer: '루시안', content: '쿠키'},
          { boardNo: 5, title: '먹고싶은 거', writer: '드레이븐', content: '요거트'},
          { boardNo: 6, title: '좋아좋아', writer: '미스포춘', content: '아이스크림'},
          { boardNo: 7, title: '토핑 추가', writer: '시비르', content: '꿀'},
          { boardNo: 8, title: '시킬까', writer: '징크스', content: '먹고싶다'},
          { boardNo: 9, title: '쿠키오', writer: '칼리스타', content: '초코'},
          { boardNo: 10, title: '맨날 먹고파', writer: '이즈리얼', content: '바닐라라떼'},
          { boardNo: 11, title: '갑자기 겨울', writer: '사미라', content: '추어추워'},
          { boardNo: 12, title: '수족냉증', writer: '진', content: '수면양말'},
          { boardNo: 13, title: '따뜻한 양말', writer: '제리', content: '신자'},
        ],
        name: '7박 8일여행 코스!',
        email: '',
        password: '',
        loginDialog: false,
        dialog: false,
        nav_drawer: false,
        links: [
          { icon: 'mdi-home', text: 'Home', name: 'home', route: '/' },
          { icon: 'mdi-ev-station', text: '전기차 충전소', name: 'home', route: '/' },
        ],
        dropItems: [
          { title: '메뉴1' },
          { title: '메뉴2' },
          { title: '메뉴3' },
          { title: '메뉴4' },
        ]
      }
    },
    methods: {
      btnClick() {
        alert('Vuetify 테스트 버튼')
      }
    }
  }
</script>

<style scoped>
</style>
