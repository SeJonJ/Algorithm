package algorithm;

import java.util.Scanner;

public class Test_for {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(); //
        int m = scan.nextInt(); //
        int[][] test = new int[n][m]; // y, x


//        for (int[] i : test) {
//            for (int j : i) {
//                System.out.print(j + " ");3
//            }
//            System.out.println("");
//        }
        int cnt = 0;
        for(int i = 0; i < n; i++){ // 가로 row
//            System.out.print(n + " ");
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
