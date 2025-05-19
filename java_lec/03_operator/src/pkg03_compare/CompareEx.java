package pkg03_compare;

public class CompareEx {

  public static void main(String[] args) {
    
    // 비교 연산
    int a = 10;
    int b = 20;
    
    System.out.println(a > b);  // false
    System.out.println(a >= b); // false
    System.out.println(a < b);  // true
    System.out.println(a <= b); // true
    System.out.println(a == b); // false
    System.out.println(a != b); // true
    
    System.out.println("-----------");
    
    // 문자열을 비교 연산하기 -> 결론. == 또는 != 연산자로 문자열을 비교하면 안 된다.
    String x = "hello";
    String y = "hello";
    System.out.println(x == y); // true, hello 를 비교하는 것이 아니다. hello 가 저장된 참조를 비교한다.
    
    /*   
      String x = "hello";
      String y = "hello";
      
      ┌-------------┐
      |  0x12345678 | x
      |-------------|
      |  0x12345678 | y
      |-------------|
      |             |
      |-------------|
      |    hello    | 0x12345678
      |-------------|
      |             |
      └-------------┘
     */

  }

}
