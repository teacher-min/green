package pkg04_overloading;

public class OverloadingEx {

  public static void main(String[] args) {
    
    // Sample 타입의 인스턴스 s 생성
    Sample s = new Sample();
    
    s.printArray(new String[] {"아침", "점심", "저녁"});
    s.printArray(new int[] {10, 20, 30});

  }

}
