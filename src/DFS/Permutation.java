package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
    static int[]  arr, pm;
    static boolean[] check;
    static int n, m;

    static void DFS(int num){
        if(num == m){
            for(int i : pm) {
                System.out.print(i+" ");
            }
            System.out.println();
        }else{
            for(int i = 0; i < n; i++){
                if(!check[i]){
                    check[i] = true;
                    pm[num] = arr[i];
                    DFS(num+1);
                    check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println("n: " + n);
        System.out.println("m: " + m);

        arr = new int[n];
        check = new boolean[n];
        pm = new int[m];

        System.out.println("pm: " + Arrays.toString(pm));

        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        DFS(0);
    }
}
