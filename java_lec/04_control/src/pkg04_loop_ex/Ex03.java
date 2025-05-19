package pkg04_loop_ex;

public class Ex03 {

  public static void main(String[] args) {
    
    // 구구단 가로 방향으로 출력하기
    // 2x1=2  3x1=3  ...  9x1=9
    // 2x2=4  3x2=6  ...  9x2=18
    // ...
    // 2x9=18 3x9=27 ...  9x9=81 
    
    for(int n = 1; n <= 9; n++) {
      for(int dan = 2; dan <= 9; dan++) {
        System.out.print(dan + "x" + n + "=" + (dan * n) + "\t");  // println() 아님 주의. \t는 탭 이동을 의미함.
      }
      System.out.println();  // 줄 바꿈
    }

  }

}
