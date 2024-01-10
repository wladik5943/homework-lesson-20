public class Max implements Runnable{

    private int[] arr;

    public Max(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        int max = arr[0];
        for(int temp: arr)
            if(temp > max)
                max = temp;
        System.out.println("максимальный элемент = " + max);
    }
}
