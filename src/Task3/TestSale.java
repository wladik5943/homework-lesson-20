package Task3;

import java.util.Optional;

public class TestSale {
    public static void main(String[] args) {

        Shop shop = new Shop();
        Manufacture manufacture = new Manufacture();
        Optional<Manufacture> man = Optional.ofNullable(manufacture);
        Byyer byyer = new Byyer();
        Sale sale = new Sale(byyer, manufacture, shop);

        Thread thread = new Thread(sale);
        Thread thread1 = new Thread(sale);

        thread.start();
        thread1.start();






    }
}
