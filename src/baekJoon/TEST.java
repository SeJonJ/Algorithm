package baekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt(); // 가로
        int n = scan.nextInt(); // 세로
        int[][] test = new int[n][m];


//        for (int[] i : test) {
//            for (int j : i) {
//                System.out.print(j + " ");
//            }
//            System.out.println("");
//        }
        int cnt = 0;
        for(int i = 0; i < n; i++){ // 가로 row
//            System.out.println(n + " ");
            for (int j = 0; j < m; j++) { // 세로 col
//                System.out.print(m+" ");

                test[i][j] = cnt++;
                System.out.print(test[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println(test[1][2]);

    }
}
