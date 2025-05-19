package pkg04_loop_ex;

public class Ex07 {

  public static void main(String[] args) {
    
    /*
     * 삼각별 출력하기-4
     * space/star=123456789
     * row=1      *********
     * row=2       *******
     * row=3        *****
     * row=4         ***
     * row=5          *
     * 
     * row=1, space=1~0, star=1~9
     * row=2, space=1~1, star=2~8
     * row=3, space=1~2, star=3~7
     * row=4, space=1~3, star=4~6
     * row=5, space=1~4, star=5~5
     * 
     * row=1~5, space=1~(row-1), star=row~(10-row)
     */
    
    for(int row = 1; row <= 5; row++) {
      for(int space = 1; space <= row - 1; space++) {
        System.out.print(" ");
      }
      for(int star = row; star <= 10 - row; star++) {
        System.out.print("*");
      }
      System.out.println();
    }

  }

}
