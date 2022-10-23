import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import 'components/blog_type_list_item.dart';
import 'components/blog_type_menu.dart';
import 'components/blog_type_title.dart';

// #main함수
// - 컴파일러에게 앱의 시작점을 알려준다.
// - void ; 텅 빈. return 값이 비어있음.
// - main 함수가 실행완료되어도 반환되는 값이 없다.

// #runApp
// - 주어진 인자값으로 들어오는 위젯을 루트 위젯으로 만들어 준다.
// - 위젯 트리를 생성해 준다.
// - 플러터, 다트는 문장의 끝은 항상 세미콜론으로 마쳐야 한다.

// #main #runApp -> 함수
void main() {
  runApp(const MyApp());
}

// #MyApp -> StatelessWidget상속받은 클래스
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

// #build
// - 플러터에서 제공하는 모든 위젯은 또 다른 위젯을 리턴하는 build함수를 가지고 있다.
// build는 자기 위젯 말고 하위 위젯 리턴해주는 메서드

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    //플러터에서 제공하는 material디자인을 사용하는 위젯을 상위 위젯으로 만들어 준다.
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: BlogTypePage(), // 앱이 처음 시작되었을 때 보여주는 화면
    );
  }
}

class BlogTypePage extends StatelessWidget {
  const BlogTypePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    //Scaffold : 발판을 만들어 준다.
    // 앱을 빨리 만들 수 있도록 가장 많이 사용하는 시각적 레이아웃을 구성해주는 발판이다.
    return Scaffold(
      backgroundColor: Colors.white, // 배경 설정
      appBar: _buildBlogTypeAppBar(), // 앱 바 메서드
      body: Padding( // boby를 Padding으로 설정
        // EdgeInsets.symmetric : 위/아래 또는 좌/우 위치 적용 (수평,수직)
        padding: const EdgeInsets.symmetric(horizontal: 20.0),
        child: ListView( // ListView : 스크롤
          children: const [
            BlogTypeTitle(), // 타이틀 메서드 불러오기
            BlogTypeMenu(), // 메뉴 메서드 불러오기
            // 리스트 아이템 메서드 불러오기 (인수 2개 넣어주기)
            BlogTypeListItem(imageName: 'kun1', title: 'test1-1'),
            BlogTypeListItem(imageName: "kun2", title: "test2-1"),
            BlogTypeListItem(imageName: "kun3", title: "test3-1"),
          ],
        ),
      ),
    );
  }

  /** 검색 기능 앱바 */
  AppBar _buildBlogTypeAppBar () {
    return AppBar(
        backgroundColor: Colors.white,
        elevation: 1.0,
        actions: const [
          Icon(
            CupertinoIcons.search, // 돋보기 모양
            color: Colors.black,
          ),
          SizedBox(width: 15,),
          Icon(
            CupertinoIcons.antenna_radiowaves_left_right, // 안테나 모양
            color: Colors.green,
          ),
          SizedBox(width: 15,),
        ]
    );
  }
}
