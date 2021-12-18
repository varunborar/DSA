# Sorting

## Table of Contents

1. [Concept Description](#program-description)
    1. [Stablity](#stablity)
    2. [In Place Sorting](#in-place-sorting)
2. [Programs](#programs)


## Concept Description

A sorting algorithm is used to re-order the elements of an array in either increasing or decreasing order. A comparison operator is used to determine the order between the two given elements

Any comparison based sorting algorithm has a running time complexity of $\mathsf{\Omega(nlogn)}$ . 

### Stablity 

Stablity of a sorting algorithm determines, if the given algorithm-provided two (or more) objects with equal keys- is able to maintain the same relative sequence in the sorted output as they appear in the proided input. 

Formally, 
Given an array A, an algorithm is stable if and only if, 
$\mathsf{i < j \; and \; A[i] == A[j] \; implies \; \pi(i) < \pi(j)}$
where $\mathsf{\pi(i)}$ is the sorting permutation.

Stable sorting algorithms include Bubble Sort, Insertion Sort, Merge Sort etc. 

### In Place Sorting

An in-place sorting algorithm uses constant extra space for sorting procedure, i.e., all the changes are made in the input array itself. For example, Insertion Sort and Selection Sort. 

### Time and Space Complexity for various sorting algorithms

<table>
    <thead>
        <tr>
            <th rowspan=2> Algorithm</th>
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
            <td>Quick Sort </td>
            <td>&Omega; (n log(n)) </td>
            <td>&Theta; (n log(n)) </td>
            <td>O (n<sup>2</sup>) </td>
            <td>O (n log(n)) </td>
        </tr>
        <tr>
            <td>Merge Sort </td>
            <td>&Omega; (n log(n)) </td>
            <td>&Theta; (n log(n)) </td>
            <td>O (n log(n)) </td>
            <td>O (n) </td>
        </tr>
        <tr>
            <td>Timsort </td>
            <td>&Omega; (n) </td>
            <td>&Theta; (n log(n)) </td>
            <td>O (n log(n)) </td>
            <td>O (n) </td>
        </tr>
        <tr>
            <td>Heapsort </td>
            <td>&Omega; (n log(n)) </td>
            <td>&Theta; (n log(n)) </td>
            <td>O (n log(n)) </td>
            <td>O (1) </td>
        </tr>
        <tr>
            <td>Bubble Sort </td>
            <td>&Omega; (n) </td>
            <td>&Theta; (n<sup>2</sup>) </td>
            <td>O (n<sup>2</sup>) </td>
            <td>O (1) </td>
        </tr>
        <tr>
            <td>Insertion Sort </td>
            <td>&Omega; (n) </td>
            <td>&Theta; (n<sup>2</sup>) </td>
            <td>O (n<sup>2</sup>) </td>
            <td>O (1) </td>
        </tr>
        <tr>
            <td>Selection Sort </td>
            <td>&Omega; (n<sup>2</sup>) </td>
            <td>&Theta; (n<sup>2</sup>) </td>
            <td>O (n<sup>2</sup>) </td>
            <td>O (1) </td>
        </tr>
        <tr>
            <td>Tree Sort </td>
            <td>&Omega; (n log(n)) </td>
            <td>&Theta; (n log(n)) </td>
            <td>O (n<sup>2</sup>) </td>
            <td>O (n) </td>
        </tr>
        <tr>
            <td>Shell Sort </td>
            <td>&Omega; (n log(n)) </td>
            <td>&Theta; (n (log(n))<sup>2</sup>) </td>
            <td>O ((n (log(n))<sup>2</sup>) </td>
            <td>O (1) </td>
        </tr>
        <tr>
            <td>Bucket Sort </td>
            <td>&Omega; (n + k) </td>
            <td>&Theta; (n + k) </td>
            <td>O (n<sup>2</sup>) </td>
            <td>O (n) </td>
        </tr>
        <tr>
            <td>Radix Sort </td>
            <td>&Omega; (n*k) </td>
            <td>&Theta; (n*k) </td>
            <td>O (n*k) </td>
            <td>O (n + k) </td>
        </tr>
        <tr>
            <td>Counting Sort </td>
            <td>&Omega; (n + k) </td>
            <td>&Theta; (n + k) </td>
            <td>O (n + k) </td>
            <td>O (k) </td>
        </tr>
        <tr>
            <td>Cube Sort </td>
            <td>&Omega; (n) </td>
            <td>&Theta; (n log(n)) </td>
            <td>O (n log(n)) </td>
            <td>O (n) </td>
        </tr>
    </tbody>
</table>

## Programs

|S. No| Program Name |Implemented Languages |
|:---:| :------------|:-------------------- |
| 1.  | [Merge Sort](Merge%20Sort/MergeSort.md)| `Java`, `C++`|
| 2.  | [Quick Sort](Quick%20Sort/QuickSort.md)| `Java`, `C++` |
| 3.  | [Insertion Sort](Insertion%20Sort/InsertionSort.md)| `Java` |
| 4.  | [Bubble Sort](Bubble%20Sort/BubbleSort.md)| `Java` |
| 5.  | [Selection Sort](Selection%20Sort/SelectionSort.md)| `Java` | 
