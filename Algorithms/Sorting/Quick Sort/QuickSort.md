# Quick Sort

## Table of Contents

1. [Program Description](#program-description)
    1. [Stablity](#stablity)
    2. [Inplace](#inplace)
2. [Algorithm](#algorithm)
    1. [Pseudo Code](#pseudo-code)
3. [Time and Space Complexity](#time-and-space-complexity)


## Program Description

Quick Sort is a divide and conquer sorting algorithm. Based on the selection of piviot there can be various ways to implement quick sort, 
1. Picking first element as the pivot
2. Picking last element as the pivot
3. Pick random element as the piviot

The seletion of piviot can be changed by using the `partition()`.


### Stablity

Quick sort is not a stable sorting algorithm.

### Inplace

Quick Sort is an inplace sorting algorithm.

## Algorithm 

Quick Sort uses divide and conquer algorithmic paradigm. It works as follows,

1. Select an element as piviot from the array o0f elements.
2. Reaarange the elements in the array in such a way that all the elements that are less than the piviot element comes after it. 
3. Place the piviot at its right position. 
4. Recursively sort the two sub-arrays thus obtained.

### Pseudo Code

```java
QUICKSORT(A, start, end):
    If start < end:
    mid = PARTITION(A, start, end)
    QUICKSORT(A, start, mid - 1)
    QUICKSORT(A, mid + 1, end)

PARTITION(A, start, end):
    X = A[end]
    i = start – 1
    For j = start to end - 1:
        If A[j] <= X:
            i = i + 1
            SWAP(A[i], A[j])
    SWAP(A[i+1], A[end])
    Return i + 1
```

Implementation [`Java`](QuickSort.java), [`C++`](QuickSort.cpp).


## Time and Space Complexity

<table>
    <thead>
        <tr>
            <th colspan=3 style="text-align:center;"> Time Complexity</th>
            <th> Space Complexity</th>
        </tr>
        <tr>
            <th>Best Case</th>
            <th>Average Case</th>
            <th>Worst Case</th>
            <th>Worst Case</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>&Omega; (n log(n)) </td>
            <td>&Theta; (n log(n)) </td>
            <td>O (n <sup>2</sup>) </td>
            <td>O (n) </td>
        </tr>
    </tbody>
</table>