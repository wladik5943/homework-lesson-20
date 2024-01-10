public class Min implements Runnable{
    private int[] arr;

    public Min(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        int min = arr[0];
        for(int temp: arr)
            if(temp < min)
                min = temp;
        System.out.println("минимальный элемент = " + min);
    }
}
