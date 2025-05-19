package pkg03_constructor;

public class Developer extends Person {

  private String[] skills;

  public Developer(String[] skills) {
    super();  // public Person() { } 생성자 호출!
    this.skills = skills;
  }
  
  public Developer(String name, String[] skills) {
    // 자식은 반드시 슈퍼 클래스의 생성자를 호출해야 한다.
    super(name);  // public Person(String name) { } 생성자 호출!
    this.skills = skills;
  }

  public String[] getSkills() {
    return skills;
  }

  public void setSkills(String[] skills) {
    this.skills = skills;
  }
  
}
