import 'package:flutter/material.dart';

class AnimateProgressIndicatorWidget extends StatefulWidget {
  const AnimateProgressIndicatorWidget({super.key});
  @override
  State<StatefulWidget> createState() => _AnimateProgressIndicatorState();
}

class _AnimateProgressIndicatorState extends State<AnimateProgressIndicatorWidget>
                                      with SingleTickerProviderStateMixin {  // 애니메이션을 위한 TickerProviderMixin : 매 프레임마다 콜백을 호출하여 애니메이션을 만드는 Ticker 활용)

  // 애니메이션 컨트롤러
  late AnimationController _controller;

  // 색상 변화를 위한 애니메이션
  late Animation<Color?> _animation;

  // 초기화
  @override
  void initState() {

    super.initState();

    // [1] 애니메이션 컨트롤러 생성
    _controller = AnimationController(
      vsync: this,  // 현재 State 객체를 TickerProvider 로 사용합니다.
      duration: const Duration(seconds: 10),  // 애니메이션은 10초간 지속합니다.
    );

    // [2] 애니메이션 리스너 등록
    _controller.addListener(() { setState(() {}); });

    // 객체 생성 및 메소드 호출([1] + [2])을 한 번에 수행하는 Cascade Notation (캐스캐이드 표기법)
    // _controller = AnimationController(
    //   vsync: this,  // 현재 State 객체를 TickerProvider 로 사용합니다.
    //   duration: const Duration(seconds: 10),  // 애니메이션은 10초간 지속합니다.
    // )..addListener(() { setState(() {}); });  // 마침표 2개를 사용하는 Cascade Notation

    // [3] 애니메이션 색상 변화 등록
    _animation = _controller.drive(ColorTween(begin: Colors.black12, end: Colors.blue));

    // [4] 애니메이션 시작
    _controller.forward();

  }

  // 위젯 종료
  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  // UI 빌드
  @override
  Widget build(BuildContext context) {
    return Center(
      child: CircularProgressIndicator(
        value: _controller.value,  // AnimationController 의 값(0.0 ~ 1.0)
        valueColor: _animation,    // 색상 애니메이션으로 색상 변화 확인
        strokeWidth: 10,
      )
    );
  }

}