import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository products = new ProductRepository();
    ProductManager manager = new ProductManager(products);

    public Product product1 = new Book(3,"Война", 200, "Петя");
    public Product product2 = new Book(4,"Мир", 200, "Ваня");
    public Product product3 = new Smartphone(4,"Яблоко", 200, "Ольга");
    public Product product4 = new Smartphone(4,"Апельсин", 200, "Вова");


    @BeforeEach
    public void setUp(){
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }
    @Test
    public void searchNameBook() {
        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Война");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAuthorSmartphone() {
        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Апельсин");

        Assertions.assertArrayEquals(expected, actual);
    }
    
}
