package pkg01_is_a;

/*
 * 상속
 * 1. 부모 클래스가 가진 기능(메소드)을 자식 클래스가 자신의 것처럼 사용할 수 있다.
 * 2. 다중 상속은 불가능하다.
 * 3. 상속 문법
 *   class 자식 extends 부모 { }
 */

public class IsaEx {

  public static void main(String[] args) {
    
    Developer developer = new Developer();
    developer.eat();
    developer.sleep();
    developer.develop();

    System.out.println("---------------");
    
    WebDeveloper webDeveloper = new WebDeveloper();
    webDeveloper.eat();
    webDeveloper.sleep();
    webDeveloper.develop();
    webDeveloper.deploy();
    
  }

}
