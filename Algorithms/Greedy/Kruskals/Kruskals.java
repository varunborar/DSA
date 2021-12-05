package Algorithms.Greedy.Kruskals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;


class Edge implements Comparable<Edge>{
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
    public int compareTo(Edge e){
        return this.weight - e.getWeight();
    }

    @Override
    public String toString(){
        return this.source + " ----> " + this.destination + " (" + this.weight + ")";
    }
}

class Subset{
    private int parent;
    private int rank;

    public Subset(){
        this.parent = -1;
        this.rank = -1;
    }

    public int getParent(){
        return this.parent;
    }

    public int getRank(){
        return this.rank;
    }

    public void setParent(int parent){
        this.parent = parent;
    }

    public void setRank(int rank){
        this.rank = rank;
    }
}

public class Kruskals{

    public int find(Subset[] subsets, int i){
        if (subsets[i].getParent() != i){
            subsets[i].setParent(find(subsets, subsets[i].getParent()));
        }
        return subsets[i].getParent();
    }    

    public void union(Subset[] subsets, int x, int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].getRank() < subsets[yroot].getRank()){
            subsets[xroot].setParent(yroot);
        }
        else if (subsets[xroot].getRank() > subsets[yroot].getRank()){
            subsets[yroot].setParent(xroot);
        }
        else{
            subsets[yroot].setParent(xroot);
            subsets[xroot].setRank(subsets[xroot].getRank() + 1);
        }
    }

    public void printMST(Vector<Edge> Edges){
        System.out.println("Following Edges were included in MST:");

        for (int i = 0; i < Edges.size(); i++){
            System.out.println(Edges.get(i));
        }
    }

    public void findMST(Vector<Edge> edges, int numberOfVertices){
        Vector<Edge> result = new Vector<Edge>();

        int edgesIncluded = 0;
        Collections.sort(edges);

        Subset subsets[] = new Subset[numberOfVertices];
        for (int i = 0; i < numberOfVertices; ++i){
            subsets[i] = new Subset();
        }

        for (int v = 0; v < numberOfVertices; ++v){
            subsets[v].setParent(v);
            subsets[v].setRank(0);;
        }

        int selectedEdge = 0;
        while (edgesIncluded < numberOfVertices - 1){

            Edge nextEdge = edges.get(selectedEdge++);

            int x = find(subsets, nextEdge.getSource());
            int y = find(subsets, nextEdge.getDestination());

            if (x != y){
                result.add(nextEdge);
                edgesIncluded++;
                union(subsets, x, y);
            }
        }
        printMST(result);
    }

    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("KruskalsInput.txt");
        Scanner sc = new Scanner(file);

        int numberOfVertices = sc.nextInt();
        int numberOfEdges = sc.nextInt();

        int u, v, w;
        Vector<Edge> edges = new Vector<Edge>();

        for (int i = 0; i < numberOfEdges; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            Edge e = new Edge(u, v, w);
            edges.add(e);
        }

        Kruskals km = new Kruskals();
        km.findMST(edges, numberOfVertices);

        sc.close();
    }
}

