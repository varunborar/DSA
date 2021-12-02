package Dijsktra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Dijsktra{

    int selectMinUnivistedVertex(int[] distance, boolean[] visited){

        int minIndex = -1;
        for(int i = 0; i < distance.length; i++){
            if (minIndex == -1 && visited[i] == false){
                minIndex = i;
                continue;
            }
            else if (minIndex == -1){
                continue;
            }

            if (distance[i] < distance[minIndex] && visited[i] == false){
                minIndex = i;
            }
        }
        return minIndex;
    }

    int[] SSSP(int[][] cost, int source){
        int v = cost[0].length;
        int[] distance = new int[v];
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++){
            distance[i] = cost[source][i];
            visited[i] = false;
        }
        
        visited[source] = true;

        for (int i = 0; i < v - 1; i++){
            int j = selectMinUnivistedVertex(distance, visited);
            visited[j] = true;

            for (int k = 0; k < v; k++){
                if (distance[j] + cost[j][k] < distance[k]){
                    distance[k] = distance[j] + cost[j][k];
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("DijsktraInput.txt");
        Scanner sc = new Scanner(file);

        int source = sc.nextInt();
        int v = sc.nextInt();
        int cost[][] = new int[v][v];

        for (int i = 0; i < v; i++){
            for (int j = 0; j < v; j++){
                cost[i][j] = sc.nextInt();

                // When there is no edge;
                if(cost[i][j] == -1){
                    cost[i][j] = 99999;
                }
            }
        }

        Dijsktra solver = new Dijsktra();
        int[] result = solver.SSSP(cost, source);
        System.out.print("[");
        for (int d: result){
            System.out.print(d + " ");
        }
        System.out.print("]");

        sc.close();
    }
}