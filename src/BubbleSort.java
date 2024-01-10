public class BubbleSort implements Runnable{
    private int[] array;

    public BubbleSort(int[] arr) {
        this.array = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            this.array[i] = arr[i];
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        for(int temp: array)
            System.out.print(temp + "  ");
        System.out.println();
    }
}
