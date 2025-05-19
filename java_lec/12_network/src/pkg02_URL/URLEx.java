package pkg02_URL;

import java.net.MalformedURLException;
import java.net.URL;

public class URLEx {

  public static void main(String[] args) {
    
    try {

      // URL 인스턴스 생성
      URL url = new URL("https://www.example.com:8080/blog/list?page=1&sort=DESC#memo");
      
      // URL 파싱(분석)하기
      System.out.println(url.getProtocol());  // https
      System.out.println(url.getHost());      // www.example.com
      System.out.println(url.getPort());      // 8080
      System.out.println(url.getPath());      // /blog/list
      System.out.println(url.getQuery());     // page=1&sort=DESC
      System.out.println(url.getFile());      // /blog/list?page=1&sort=DESC
      System.out.println(url.getRef());       // memo
      
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

  }

}
