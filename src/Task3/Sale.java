package Task3;

import java.util.Optional;

public class Sale implements Runnable{

    private Byyer byyer;
    private Manufacture manufacture;
    private Shop shop;

    public Sale(Byyer byyer, Manufacture manufacture, Shop shop) {
        this.byyer = byyer;
        this.manufacture = manufacture;
        this.shop = shop;
    }

    @Override
    public void run() {
        while (manufacture.getProduct() > 0 && byyer.getProduct() < 5){
            doOperation();
        }

    }

    public void manuf() {
        if (manufacture.getProduct() > 3 && shop.getProduct() == 0) {
            shop.setProduct(3);
            manufacture.setProduct(manufacture.getProduct() - 3);
        } else {
            shop.setProduct(shop.getProduct() + manufacture.getProduct());
            manufacture.setProduct(0);
        }
    }


    public void buy() {
        byyer.setProduct(byyer.getProduct() + shop.getProduct());
        shop.setProduct(0);
    }

    private synchronized void doOperation() {


            if (shop.getProduct() < 3 && manufacture.getProduct() != 0) {
                manuf();
                System.out.println("производитель доставил товар");
                System.out.println("Теперь в магазине " + shop.getProduct() + " единиц(-ы) товара");
                System.out.println("Теперь у производителя " + manufacture.getProduct() + " единиц(-ы) товара");
            } else {
                buy();
                System.out.println("покупатель купил весь товар в магазине");
                System.out.println("у покупателя теперь " + byyer.getProduct() + " единиц(-ы) товара");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
    }
}
