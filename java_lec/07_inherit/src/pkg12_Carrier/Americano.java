package pkg12_Carrier;

/*
  ┌-------------------┐
  │ Coffee            │ 슈퍼 클래스
  │-------------------│
  │ String name       │
  │ Coffee(String)    │
  │ getName()         │
  │ setName(String)   │
  └-------------------┘
            ▲
  ┌-------------------┐
  │ Espresso          │ 서브 클래스
  │-------------------│
  │ Espresso(String)  │
  └-------------------┘
            ▲
  ┌-------------------┐
  │ Americano         │ 서브 클래스
  │-------------------│
  │ Americano(String) │
  └-------------------┘
*/

public class Americano extends Espresso {

  public Americano(String name) {
    super(name);
  }
  
}