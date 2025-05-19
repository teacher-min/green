package pkg02_Functional_Interface;

import java.util.function.Consumer;

/*
 * package java.util.function;
 * 
 * @FunctionalInterface
 * public interface Consumer<T> {
 *   void accept(T t);
 * }
 */

public class Class02_Consumer {

  public static void main(String[] args) {
    
    // Lambda Expression
    
    Consumer<String> consumer = t -> System.out.println(t);
    consumer.accept("hello world");
    
    // Consumer 타입의 매개변수로 Lambda Expression 전달하기
    a(number -> System.out.println(number));

  }
  
  public static void a(Consumer<Integer> consumer) {
    consumer.accept(10);
  }

}
