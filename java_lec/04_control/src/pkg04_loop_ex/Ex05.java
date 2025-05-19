package pkg04_loop_ex;

public class Ex05 {

  public static void main(String[] args) {
    
    /*
     * 삼각별 출력하기-2
     *        star=12345
     * row=1       *****
     * row=2       ****
     * row=3       ***
     * row=4       **
     * row=5       *
     * 
     * row=1, star=1~5
     * row=2, star=1~4
     * row=3, star=1~3
     * row=4, star=1~2
     * row=5, star=1~1
     * 
     * row=1~5, star=1~(6-row)
     */
    
    for(int row = 1; row <= 5; row++) {
      for(int star = 1; star <= 6 - row; star++) {
        System.out.print("*");
      }
      System.out.println();
    }

  }

}
