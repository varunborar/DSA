import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 


public class BubbleSort {
    
    public void sort(int[] array){
        int size = array.length;
        int flag = 0;
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size - 1 - i; j++)
            {
                if(array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag++;
                }
            }
            if(flag == 0) {
                break;
            }
            flag = 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("Input.txt");
        Scanner sc = new Scanner(file);

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; ++i){
            array[i] = sc.nextInt();
        }

        BubbleSort bs = new BubbleSort();
        bs.sort(array);

        for (int e: array){
            System.out.print(e + " ");
        }

        sc.close();
    }

}
