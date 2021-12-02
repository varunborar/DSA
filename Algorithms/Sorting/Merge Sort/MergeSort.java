
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MergeSort {
    
    private void sort(int[] array, int start, int end){
        if(start < end){
            int mid = (start + end)/2;
            sort(array, start, mid);
            sort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private void merge(int[] array, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] leftSubArray = new int[n1 + 1];
        int[] rightSubArray = new int[n2 + 1];

        for (int i = 0; i < n1; i++){
            leftSubArray[i] = array[start + i];
        }

        for (int i = 0; i < n2; i++){
            rightSubArray[i] = array[mid + i + 1];
        }

        leftSubArray[n1] = Integer.MAX_VALUE;
        rightSubArray[n2] = Integer.MAX_VALUE;

        int indexLeft = 0, indexRight = 0;

        for (int k = start; k <= end; k++){
            if (leftSubArray[indexLeft] <= rightSubArray[indexRight]){
                array[k] = leftSubArray[indexLeft];
                indexLeft += 1;
            }
            else {
                array[k] = rightSubArray[indexRight];
                indexRight += 1;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("MergeSortInput.txt");
        Scanner sc = new Scanner(file);

        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        MergeSort ms = new MergeSort();
        ms.sort(array, 0, n - 1);

        for (int i: array){
            System.out.print(i + " ");
        }
        sc.close();
    }
}
