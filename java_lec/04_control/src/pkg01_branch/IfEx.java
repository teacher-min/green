package pkg01_branch;

public class IfEx {

  public static void main(String[] args) {
    
    // 짝수/홀수
    int a = 5;
    if(a % 2 == 0) {
      System.out.println(a + "는 짝수");
    } else {
      System.out.println(a + "는 홀수");
    }
    
    // 짝수/홀수/3의배수(3으로 나눈 나머지가 0인 수)
    int b = 6;
    if(b % 3 == 0) {
      System.out.println(b + "는 3의 배수");
    } else if(b % 2 == 0) {
      System.out.println(b + "는 짝수");
    } else {
      System.out.println(b + "는 홀수");
    }

  }

}
