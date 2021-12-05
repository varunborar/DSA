import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InsertionSort {

    public void sort(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Input.txt");
        Scanner sc = new Scanner(file);

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; ++i) {
            array[i] = sc.nextInt();
        }

        InsertionSort bs = new InsertionSort();
        bs.sort(array);

        for (int e : array) {
            System.out.print(e + " ");
        }

        sc.close();
    }

}
