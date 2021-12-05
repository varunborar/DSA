import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SelectionSort {

    public void sort(int[] array){
        int size = array.length;
        int min, minPos;
        for(int i = 0; i < size - 1; i++)
        {
            min = array[i];
            minPos = i;
            for (int j = i + 1; j < size; j++)
            {
                if(array[j] < min) {
                    min = array[j];
                    minPos = j;
                }
            }
            if (min != array[i])
            {
                int temp = array[i];
                array[i] = array[minPos];
                array[minPos] = temp;
            }
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

        SelectionSort bs = new SelectionSort();
        bs.sort(array);

        for (int e : array) {
            System.out.print(e + " ");
        }

        sc.close();
    }

}
