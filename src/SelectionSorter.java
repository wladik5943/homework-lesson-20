public class SelectionSorter implements Runnable{

    private int[] array;

    public SelectionSorter(int[] arr) {
        this.array = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            this.array[i] = arr[i];
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
        for(int temp: array)
            System.out.print(temp + "  ");
        System.out.println();
    }
}
