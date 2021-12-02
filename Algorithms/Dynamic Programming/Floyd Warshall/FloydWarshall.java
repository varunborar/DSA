import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FloydWarshall {
    
    int min(int a, int b){
        return a > b ? b : a;
    }

    void APSP(int[][] distance){
        int n = distance[0].length;

        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    distance[i][j] = min(distance[i][j] , distance[i][k] + distance[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("Input.txt");
        Scanner sc = new Scanner(file);

        int n = sc.nextInt();
        int distance[][] = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                distance[i][j] = sc.nextInt();
                if (distance[i][j] == -1){
                    distance[i][j] = 99999;
                }
            }
        }
        
        FloydWarshall fw = new FloydWarshall();
        fw.APSP(distance);
        sc.close();
    }
}
