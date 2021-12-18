#include <iostream>
#include <fstream>

using namespace std;

int partition(int* Array, int start, int end);
void QuickSort(int* Array, int start, int end);


int main(){

    fstream input;
    input.open("QuickSortInput.txt");

    int n; 
    input >> n;

    int *array = new int[n];

    for (int i = 0; i < n; i++){
        input >> array[i];
    }

    QuickSort(array, 0, n - 1);

    for (int i = 0; i < n; i++){
        cout << array[i] << " ";
    }

    input.close();
    delete[] array;
    return 0;
}

void QuickSort(int* Array, int start, int end){
    if (start < end){
        int mid = partition(Array, start, end);
        QuickSort(Array, start, mid - 1);
        QuickSort(Array, mid + 1, end);
    }
}

int partition(int *Array, int start, int end){

    int pivot = Array[end];
    int i = start - 1;

    for (int j = start; j < end; j++){

        if (Array[j] <= pivot){
            ++i;
            int temp = Array[j];
            Array[j] = Array[i];
            Array[i] = temp;
        }
    }
    int temp = Array[end];
    Array[end] = Array[i + 1];
    Array[i + 1] = temp;
    
    return i + 1;
}