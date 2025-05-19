package pkg03_branch_ex;

public class Ex01 {

  public static void main(String[] args) {
    
    // 점수와 학년에 따른 합격 여부
    // 1~3학년 : 60점 이상이면 합격, 아니면 불합격
    // 4~6학년 : 70점 이상이면 합격, 아니면 불합격
    
    int score = 70;  // 점수
    int grade = 4;   // 학년
    
    // 합격 점수
    int cutLine = 0;
    if(grade >= 1 && grade <= 3) {
      cutLine = 60;
    } else if(grade >= 4 && grade <= 6) {
      cutLine = 70;
    }
    
    // 합격/불합격
    boolean isPassed = (score >= cutLine);
    
    System.out.println(isPassed ? "합격" : "불합격");

  }

}
