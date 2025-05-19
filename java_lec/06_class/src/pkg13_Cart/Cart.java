package pkg13_Cart;

public class Cart {

  private Product[] products;
  private int idx;  // 인덱스 == Product 의 갯수
  
  public Cart() {
    
  }
  public Cart(int length) {
    products = new Product[length];
  }
  
  public Product[] getProducts() {
    return products;
  }
  
  public void setProducts(Product[] products) {
    this.products = products;
  }
  
  public int getIdx() {
    return idx;
  }
  
  public void setIdx(int idx) {
    this.idx = idx;
  }
  
  public void addProduct(Product product) {
    
    if(product == null) {
      System.out.println("Cart 에 담을 Product 이 없습니다.");
      return;
    }
    
    if(idx == products.length) {
      System.out.println("Cart 가 가득 찼습니다.");
      return;
    }
    
    products[idx++] = product;
    
  }
  
  public Product removeProduct(int removeIdx) {
    
    if(idx == 0) {
      System.out.println("Cart 가 비어 있습니다.");
      return null;
    }
    
    if(removeIdx < 0 || removeIdx >= idx) {
      System.out.println("존재하지 않는 인덱스입니다.");
      return null;
    }
    
    Product removedProduct = products[removeIdx];
    
    /*
      Cart 에 담긴 물건의 갯수(idx)에 따라 복사해야 할 요소의 갯수가 달라진다.
      
      idx 가 5 라고 가정하면 removeIdx 에 따라 복사해야 할 요소의 갯수는 아래와 같다.
      
      removeIdx     복사해야 할 요소의 갯수
      0             4
      1             3
      2             2
      3             1
      4             0
      --------------------------------------
                    idx - 1 - removeIdx
    */
    
    System.arraycopy(products, removeIdx + 1, products, removeIdx, idx - 1 - removeIdx);
    products[--idx] = null;
    
    return removedProduct;
    
  }
  
}
