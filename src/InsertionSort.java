public class InsertionSort implements Runnable{
    private int[] array;

    public InsertionSort(int[] arr) {
        this.array = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            this.array[i] = arr[i];
    }
    @Override
    public void run() {
        for (int left = 0; left < array.length; left++) {
            // Вытаскиваем значение элемента
            int value = array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[i + 1] = value;
        }
        for(int temp: array)
            System.out.print(temp + "  ");
        System.out.println();
    }
}
