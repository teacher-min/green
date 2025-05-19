package pkg09_Member;

public class Contact {

  private String tel;
  private String mobile;
  
  public Contact() {
    
  }
  
  public Contact(String mobile) {
    // this.mobile = mobile;
    this(null, mobile);
  }
  
  public Contact(String tel, String mobile) {
    this.tel = tel;
    this.mobile = mobile;
  }
  
  public void info() {
    System.out.println("Tel: " + (tel == null ? "없음" : tel));
    System.out.println("Mobile: " + (mobile == null ? "없음" : mobile));
  }
  
}
