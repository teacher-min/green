package pkg11_Square;

/*
  ┌---------------------┐
  │ Rectangle           │ 슈퍼 클래스
  │---------------------│
  │ width               │
  │ height              │
  │ Rectangle(int, int) │
  │ getArea()           │
  └---------------------┘
          ▲
          │
  ┌--------------┐
  │ Square       │ 서브 클래스
  │--------------│
  │ Square(int)  │
  └--------------┘
*/

public class Square extends Rectangle {

  public Square(int side) {
    super(side, side);
  }
  
}
