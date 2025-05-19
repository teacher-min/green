package pkg09_Member;

public class MemberEx {

  public static void main(String[] args) {
    
    // Member 타입의 인스턴스 m 생성
    
    Address address = new Address("12345", "서울시 강남구 테헤란로", "장연빌딩 5층");
    Contact contact = new Contact("010-1234-5678");
    Member m = new Member("tom", address, contact);
    
    m.info();
    
  }

}
