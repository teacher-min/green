package pkg01_Functional_Interface;

public class FuncEx {

  public static void main(String[] args) {
    
    // Anonymous Inner Type
    // 인터페이스를 구현하는 클래스를 만들지 않고, 인터페이스 구현체가 반드시 해야 할 추상 메소드 오버라이드를 인스턴스 생성 시 작성하는 방법
    /*
    MyInterfaceA a = new MyInterfaceA() {
      @Override
      public void method() {
        System.out.println("hello world");
      }
    };
    */
    
    /*
     * Lambda Expression
     * 1. Anonymous Inner Type 인스턴스 생성 시 사용할 수 있는 새로운 표현식이다.
     * 2. 함수형 인터페이스 인스턴스 생성 시 사용할 수 있다.
     * 3. 문법
     *   
     *   public interface AA {
     *     void method(String s);
     *   }
     *   
     *   1) Anonymous Inner Type
     *     AA a = new AA() {
     *       @Override
     *       public void method(String s) {
     *       
     *       }
     *     };
     *    
     *   2) Lambda Expression
     *     AA a = (s) -> {
     *     
     *     }
     */
    
    // Lambda Expression : 본문이 1개 내용인 경우 중괄호 생략 가능
    MyInterfaceA a = () -> System.out.println("hello world");
    a.method();
    
    // Lambda Expression : 매개변수의 타입은 생략 가능
    //                     매개변수가 1개이면 소괄호 생략 가능
    MyInterfaceB b = param -> System.out.println(param);
    b.method("hello world");
    
    // Lambda Expression : 코드가 return 만 있으면 중괄호와 return 키워드 생략 가능 
    MyInterfaceC c = () -> "hello world";
    System.out.println(c.method());

  }

}
