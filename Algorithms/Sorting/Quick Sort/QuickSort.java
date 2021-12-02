// package Sorting;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class QuickSort{

    private void sort(int[] array, int start, int end){

        if (start < end){
            int mid = partition(array, start, end);
            sort(array, start, mid - 1);
            sort(array, mid + 1, end);
        }
    }

    private int partition(int[] array, int start, int end){

        int pivot = array[end];
        int i = start - 1;

        for (int k = start; k < end; k++){
            if(array[k] <= pivot){
                i += 1;
                int temp = array[k];
                array[k] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[end];
        array[end] = array[i + 1];
        array[i + 1] = temp;

        return i + 1;
    }


    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("QuickSortInput.txt");
        Scanner sc = new Scanner(file);

        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        QuickSort qs = new QuickSort();
        qs.sort(array, 0, n - 1);

        for (int i: array){
            System.out.print(i + " ");
        }
        sc.close();
    }
}
