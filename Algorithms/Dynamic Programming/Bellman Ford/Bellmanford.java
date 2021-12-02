import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

class Edge{
    private int u;
    private int v;
    private int w;

    public Edge(int u, int v, int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int getU(){
        return this.u;
    }

    public int getV(){
        return this.v;
    }

    public int getW(){
        return this.w;
    }
}

public class Bellmanford {
    
    public void SSSP(Vector<Edge> edges, int source, int v){

        int[] distance = new int[v];
        for (int i = 0; i < v; i++){
            distance[i] = 99999; // Setting max cost constraint;
        }
        distance[source] = 0;
        int E = edges.size();

        for (int i = 0; i < v - 1; i++){
            
            for (int j = 0; j < E; j++){
                Edge edge = edges.get(j);
                if (distance[edge.getU()] + edge.getW() < distance[edge.getV()]){
                    distance[edge.getV()] = distance[edge.getU()] + edge.getW();
                }
            }
        }

        boolean negativeCycle = false;
        for (int j = 0; j < E; j++){
            Edge edge = edges.get(j);
            if (distance[edge.getU()] + edge.getW() < distance[edge.getV()]){
                negativeCycle = true;
                break;
            }
        }

        if (negativeCycle){
            System.out.println("Graph contains negative weight cycle");
        }else{
            System.out.print("[");
            for (int x: distance){
                System.out.print(x + " ");
            }
            System.out.print("]");
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("InputNC.txt");
        Scanner sc = new Scanner(file);

        int source = sc.nextInt();
        int V = sc.nextInt();
        int E = sc.nextInt();

        Vector<Edge> edges = new Vector<Edge>();

        for (int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            Edge e = new Edge(u, v, w);
            edges.add(e);
        }

        Bellmanford bf = new Bellmanford();
        bf.SSSP(edges, source, V);

        sc.close();
    }
}
