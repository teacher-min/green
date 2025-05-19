package pkg03_constructor;

public class Person {

  private String name;

  // 다른 생성자가 존재하는 경우 디폴트 생성자는 자동으로 생성되지 않으므로 직접 만들어야 한다.
  public Person() {
    
  }
  
  public Person(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}
