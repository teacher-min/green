package pkg02_Functional_Interface;

import java.util.function.Function;

/*
 * package java.util.function;
 * 
 * @FunctionalInterface
 * public interface Function<T, R> {
 *   R apply(T t);
 * }
 */
public class Class03_Function {

  public static void main(String[] args) {
    
    // Lambda Expression
    
    Function<String, Integer> function = str -> Integer.parseInt(str);
    System.out.println(function.apply("10"));
    
    // Function 타입의 매개변수에 Lambda Expression 전달
    a(name -> name + "님");
    
  }
  
  public static void a(Function<String, String> function) {
    System.out.println(function.apply("홍길동"));
  }

}