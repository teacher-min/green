package pkg04_loop_ex;

public class Ex02 {

  public static void main(String[] args) {
    
    // 구구단 세로 방향으로 출력하기
    // 2x1=2
    // 2x2=4
    // ...
    // 9x9=81
    
    for(int dan = 2; dan <= 9; dan++) {
      for(int n = 1; n <= 9; n++) {
        System.out.println(dan + "x" + n + "=" + (dan * n));
      }
    }

  }

}
