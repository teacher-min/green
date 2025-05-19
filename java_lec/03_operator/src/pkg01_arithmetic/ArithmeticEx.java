package pkg01_arithmetic;

public class ArithmeticEx {

  public static void main(String[] args) {
    
    // 정수 연산
    int a = 5;
    int b = 2;
    System.out.println(a + b);
    System.out.println(a - b);
    System.out.println(a * b);
    System.out.println(a / b);  // 나눈 결과 중 몫
    System.out.println(a % b);  // 나눈 결과 중 나머지
    
    // 실수 연산
    double c = 5;
    double d = 2;
    System.out.println(c + d);
    System.out.println(c - d);
    System.out.println(c * d);
    System.out.println(c / d);  // 나누기
    System.out.println(c % d);
    
    // 증감 연산
    int x = 10;
    System.out.println(x++);  // 10 (x 출력 후 증가)
    System.out.println(++x);  // 12 (x 증가 후 출력)
    
    int y = 10;
    System.out.println(y--);  // 10 (y 출력 후 감소)
    System.out.println(--y);  // 8  (y 감소 후 출력
    
  }

}
