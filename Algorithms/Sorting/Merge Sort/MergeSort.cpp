# include <iostream>
# include <fstream>

using namespace std;

void MergeSort(int *, int, int);
void Merge(int *, int, int, int);

int main(){

    fstream input;
    input.open("MergeSortInput.txt");

    int n; 
    input >> n;

    int *array = new int[n];

    for (int i = 0; i < n; i++){
        input >> array[i];
    }

    MergeSort(array, 0, n - 1);

    for (int i = 0; i < n; i++){
        cout << array[i] << " ";
    }

    input.close();
    delete[] array;
    return 0;
}

void MergeSort(int *array, int start, int end){
    if (start < end){
        int mid = start + (end - start)/2;

        MergeSort(array, start, mid);
        MergeSort(array, mid + 1, end);
        Merge(array, start, mid, end);
    }
}

void Merge(int *array, int start, int mid, int end){

    const int n1 = mid - start + 1;
    const int n2 = end - mid;

    int *leftSubArray = new int[n1 + 1];
    int *rightSubArray = new int[n2 + 1];

    for (int i = 0; i < n1; i++){
        leftSubArray[i] = array[start + i];
    }

    for (int j = 0; j < n2; j++){
        rightSubArray[j] = array[mid + j + 1];
    }

    leftSubArray[n1] = INT_MAX;
    rightSubArray[n2] = INT_MAX;

    int leftIndex = 0, rightIndex = 0;

    for (int k = start; k < end + 1; k++){

        if (leftSubArray[leftIndex] < rightSubArray[rightIndex]){
            array[k] = leftSubArray[leftIndex++];
        }
        else{
            array[k] = rightSubArray[rightIndex++];
        }
    }

    delete[] leftSubArray;
    delete[] rightSubArray;
}