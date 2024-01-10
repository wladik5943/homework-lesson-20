package Task3;

import java.util.Optional;
import java.util.Random;

public class Shop implements Runnable{

    private int product = 0;

    public Shop(Optional<Manufacturer> manufacture) {
        this.manufacture = manufacture;
    }

    public Shop(Byyer byyer) {
        this.byyer = byyer;
    }

    private Byyer byyer;
    private Optional<Manufacturer> manufacture = null;


    public int getProduct() {
        return product;
    }

    public void operation(int product) {
        String name = Thread.currentThread().getName();
        if (!manufacture.isEmpty()) {
            product += product;
        } else {
            product -= product;
        }
    }


    @Override
    public void run() {
        if(manufacture.isEmpty()) {
            while(byyer.getProduct() < 5){
                doOperation();
            }
        }
        else{
            while (manufacture.get().getProduct() > 0){
                doOperation();
            }
        }


    }


    private synchronized void doOperation() {
        if (getCount() >= product) {


            if (!manufacture.isEmpty()) {
                System.out.println("производитель произвел товар");
            } else {
                System.out.println("покупатель купил товар");
            }


            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            operation(product);
            System.out.println(" выполнил операцию. Теперь в порту кг груза: " + getCount());
        } else {
            System.out.println("Груз для разгрузки отсутствует. " + " пытается разгрузить: " + getCount());
        }
    }
}
