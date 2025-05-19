package pkg02_has_a.B_include;

public class Person {

  private Pen pen;
  
  public Pen getPen() {
    return pen;
  }

  public void setPen(Pen pen) {
    this.pen = pen;
  }

  public void drawing() {
    pen.drawing();
  }
  
  public void eat() {
    System.out.println("먹는다.");
  }
  
  public void sleep() {
    System.out.println("잔다.");
  }
  
}