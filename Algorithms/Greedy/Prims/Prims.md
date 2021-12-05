# Prims

## Table of Contents

1. [Program Description](#program-description)
    1. [Minimum Spanning Tree](#minimum-spanning-tree)
2. [Algorithm](#algorithm)
    1. [Pseudo Code](#pseudo-code)
3. [Time and Space Complexity](#time-and-space-complexity)


## Program Description

Prims's Algorithm is used to find a minimum spanning tree for a given graph.

### Minimum Spanning Tree
For a given ngconnected and undirected graph, a tree with all nodes and no cycles is called a spanni tree for that graph. A spanning tree has |V-1| edges where V is the number of vertices. 

Given weights for each edge E = (u, v), E &isin; G, a minimum spanning tree is the tree with minimum cost. 

## Algorithm 

It follows a greedy approach. The idea is to maintain two sets of vertices, first set contains the vertices already included in the MST and the other set includes the vertices not yet included. 

### Pseudo Code

```java
PRIMS(G, W, R):
    for each u in G.V
        u.key = inf
        u.weight = null
    
    r.key = 0
    Q = G.V

    while Q != null
        u = EXTRACT_MIN(Q)

        for each v in G.Adj[u]
            if v in Q and w(u, v) < v.key
                v.parent = u
                u.key = w(u, v)
```

Implementation [`Java`](Prims.java).


## Time

Time complexity in case we use binary min-heap O(E log V)
Time complexity in case we use fibonnaci heap O(E + V log V)