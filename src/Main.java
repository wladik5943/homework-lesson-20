import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }

        //task1
        Max max = new Max(arr);
        Min min = new Min(arr);

        Thread t = new Thread(max);
        Thread t1 = new Thread(min);

        t.start();
        t1.start();



        //task2
        BubbleSort bubbleSort = new BubbleSort(arr);
        SelectionSorter selectionSorter = new SelectionSorter(arr);
        InsertionSort insertionSort = new InsertionSort(arr);

        Thread thread = new Thread(bubbleSort);
        Thread thread1 = new Thread(selectionSorter);
        Thread thread2 = new Thread(insertionSort);

        thread.start();
        thread.join();
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();

    }
}