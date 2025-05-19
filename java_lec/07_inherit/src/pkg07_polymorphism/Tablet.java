package pkg07_polymorphism;

/*
  ┌---------------┐
  │ Computer      │ 슈퍼 클래스
  │---------------│
  │ internet()    │
  │ screenTouch() │
  └---------------┘
          ▲
          │
  ┌---------------┐
  │ Tablet        │ 서브 클래스
  │---------------│
  │ @Override     │
  │ screenTouch() │
  └---------------┘
*/

public class Tablet extends Computer {

  @Override
  public void screenTouch() {
    System.out.println("오버라이드 된 화면 터치");
  }
  
}
