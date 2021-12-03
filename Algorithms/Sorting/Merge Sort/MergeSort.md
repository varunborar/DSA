# Merge Sort 

## Table of Contents

1. [Program Description](#program-description)
    1. [Stablity](#stablity)
    2. [Inplace](#inplace)
2. [Algorithm](#algorithm)
    1. [Pseudo Code](#pseudo-code)
3. [Time and Space Complexity](#time-and-space-complexity)


## Program Description

Merge sort is a sorting algorithm that uses divide and conquer algorithmic paradigm.  

### Stablity

Merge Sort is a stable sorting algorithm.

### Inplace

Merge Sort is not an inplace sorting algorithm as it makes a copy of the entire array.

## Algorithm 

Divide means to partition the n-element array into two sub-arrays of n/2 length. Conquer means to sort each of the sub array recursively using merge sort. Combine means to merge the two sorted arrays to produce the original array.

### Pseudo Code

```java
MERGE (A, start, mid, end):
	N1 = mid – start + 1
	N2 = end – mid
	LeftSubArray = new sub array of size N1
	RightSubArray = new sub array of size N2
	
	For i = 1 to N1:
		LeftSubArray[i] = A[start + i + 1]
	For j = 1 to N2:
		RightSubArray[j] = A[mid + j]
	LeftSubArray[N1 + 1] = RightSubArray[N2 + 1] = Infinity
	leftIndex = 1
	rightIndex = 1
	for index = start to end:
		if LeftSubArray[i] <= RightSUbArray[j]:
			A[index++] = LeftSubArray[i++] 
		else:
			A[index++] = RightSubArray[j++]

MERGESORT(A, start, end):
	If start < end:
		mid = [(start + end)/2]
		MERGESORT(A, start, mid)
		MERGESORT(A, mid + 1, end)
		MERGE(A, start, mid, end)
```

Implementation [`Java`](MergeSort.java), [`C++`](MergeSort.cpp).


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
            <td>O (n log(n)) </td>
            <td>O (n) </td>
        </tr>
    </tbody>
</table>