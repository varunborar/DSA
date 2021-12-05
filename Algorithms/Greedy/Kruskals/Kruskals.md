# Kruskals

## Table of Contents

1. [Program Description](#program-description)
    1. [Minimum Spanning Tree](#minimum-spanning-tree)
2. [Algorithm](#algorithm)
    1. [Pseudo Code](#pseudo-code)
3. [Time and Space Complexity](#time-and-space-complexity)


## Program Description

Kruskal's Algorithm is used to find a minimum spanning tree for a given graph.

### Minimum Spanning Tree
For a given ngconnected and undirected graph, a tree with all nodes and no cycles is called a spanni tree for that graph. A spanning tree has |V-1| edges where V is the number of vertices. 

Given weights for each edge E = (u, v), E &isin; G, a minimum spanning tree is the tree with minimum cost. 

## Algorithm 

It follows a greedy approach. 
1. Sort all the edges in non decresing order of their weight.
2. Pick the edge with lowest weight. Check if it forms a cycle, if yes then discard it. If no then include the edge in the solution. 
3. Repeat until there are |V-1| edges included. 

### Pseudo Code

```java
KRUSKALS(G, W):
    A = null;
    for each vertex V in G.V:
        MAKESET(V)
    Sort edges in no-decreasing order by w

    for each edge (u, v) in G.E:
        if FINDSET(u) != FINDSET(v):
            A = A U {(u, v)}
            UNION(u, v)
    
    return A;

```

Implementation [`Java`](Kruskals.java).


## Time

Time complexity = O(E log V)