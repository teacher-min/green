package pkg03_branch_ex;

public class Ex02 {

  public static void main(String[] args) {
    
    // 메뉴에 따른 가격
    // 아메리카노 : 1000
    // 카페라떼   : 2000
    // 밀크티     : 3000
    // 기타       : 5000
    
    String order = "녹차";
    int price = 0;
    
    switch(order) {
    case "아메리카노":
      price = 1000;
      break;
    case "카페라떼":
      price = 2000;
      break;
    case "밀크티":
      price = 3000;
      break;
    default:
      price = 5000;  
    }
    
    System.out.println(price);

  }

}
