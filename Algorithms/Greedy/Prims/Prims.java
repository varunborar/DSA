package Algorithms.Greedy.Prims;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.PriorityQueue;


class Edge{
    private int source;
    private int destination;
    private int weight;

    public Edge(int src, int dest, int weight){
        this.source = src;
        this.destination = dest;
        this.weight = weight;
    }

    public int getSource(){
        return this.source;
    }

    public int getDestination(){
        return this.destination;
    }

    public int getWeight(){
        return this.weight;
    }

    @Override
    public String toString(){
        return this.source + " ----> " + this.destination + " (" + this.weight + ")";
    }
}

class Pair implements Comparable<Pair>{
    private int v;
    private int p;
    private int weight;

    Pair(int v, int p, int weight){
        this.v = v;
        this.p = p;
        this.weight = weight;
    }

    public int getV(){
        return this.v;
    }

    public int getP(){
        return this.p;
    }

    public int getWeight(){
        return this.weight;
    }

    @Override
    public String toString(){
        return this.v + " ----> " + this.p + " (" + this.weight + ")";
    }

    @Override
    public int compareTo(Pair p){
        return this.weight - p.getWeight();
    }
}

public class Prims{

    public void calculateMST(Vector<Edge>[] graph, int source, int numberOfVertices){
        int minCost = 0;
        Vector<Pair> result = new Vector<Pair>();
        Integer[] visited = new Integer[numberOfVertices];

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(source, -1, 0));

        while(!queue.isEmpty()){
            Pair rem = queue.remove();

            if (visited[rem.getV()] != null){
                continue;
            }

            visited[rem.getV()] = rem.getP();
            if(rem.getP() != -1){
                minCost += rem.getWeight();
                result.add(rem);
            } 

            for (Edge e: graph[rem.getV()]){
                if(visited[e.getDestination()] == null){
                    queue.add(new Pair(e.getDestination(), rem.getV(), e.getWeight()));
                }
            }

        }
        System.out.println("Minimum cost of the MST: " + minCost);
        System.out.println("Edges included in the MST: ");
        for (Pair p: result){
            System.out.println(p);
        }

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("PrimsInput.txt");
        Scanner sc = new Scanner(file);

        int numberOfVertices = sc.nextInt();
        int numberOfEdges = sc.nextInt();
        int source = sc.nextInt();

        Vector<Edge>[] graph = new Vector[numberOfVertices];
        for (int i = 0; i < numberOfVertices; ++i){
            graph[i] = new Vector<Edge>();
        }

        int u, v, w;
        for (int i = 0; i < numberOfEdges; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();

            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
        }

        Prims prim = new Prims();
        prim.calculateMST(graph, source, numberOfVertices);
        sc.close();
    }

}