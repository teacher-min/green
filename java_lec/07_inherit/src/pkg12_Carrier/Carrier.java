package pkg12_Carrier;

public class Carrier {

  private Cup[] cups;
  private int idx;
  
  public Carrier(int cupCount) {
    cups = new Cup[cupCount];
  }
  
  public void addCup(Cup cup) {
    if(idx == cups.length) {
      System.out.println("캐리어가 가득 찼습니다.");
      return;
    }
    cups[idx++] = cup;
  }
  
  public void info() {
    if(idx == 0) {
      System.out.println("캐리어가 비어 있습니다.");
      return;
    }
    for(int i = 0; i < idx; i++) {
      System.out.println(cups[i].getCoffee().getName());
    }
  }
  
}
