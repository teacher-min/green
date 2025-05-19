package pkg01_is_a;

/*
  ┌--------------┐
  │    Person    │ 슈퍼 클래스
  │--------------│
  │     eat()    │
  │    sleep()   │
  └--------------┘
          ▲
          │
  ┌--------------┐
  │   Developer  │ 서브 클래스
  │--------------│
  │   develop()  │
  └--------------┘
          ▲
          │
  ┌--------------┐
  │ WebDeveloper │ 서브 클래스
  │--------------│
  │   deploy()   │
  └--------------┘
*/

public class WebDeveloper extends Developer {

  public void deploy() {
    System.out.println("서버에 배포한다.");
  }
  
}
