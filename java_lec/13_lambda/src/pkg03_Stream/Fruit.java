package pkg03_Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Fruit {

  private String name;
  private int price;
  
  /* @NoArgsConstructor
  public Fruit() {
    
  }
  */
  /* @AllArgsConstructor
  public Fruit(String name, int price) {
    super();
    this.name = name;
    this.price = price;
  }
  */

  /* @Getter / @Setter
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
  */
  
  /* @ToString
  @Override
  public String toString() {
    return "Fruit [name=" + name + ", price=" + price + "]";
  }
  */
  
}
