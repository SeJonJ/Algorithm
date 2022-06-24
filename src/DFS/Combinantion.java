package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Combinantion {

    // 1부터 N까지 적힌 구슬이 있다. 이 중 M 개를 뽑는 방법의 수를 출력하라.
    // 조합 코드는 차라리 외우는게 편하다?
    static int[] com;
    static int n, m;

    static void combine(int L, int s){
        if(L==m){
            for(int i : com){
                System.out.print(i+" ");
            }
            System.out.println("");
        }else{
            for(int i=s; i<=n; i++){
                com[L] = i;
                combine(L+1, s+1);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        com = new int[m];

        combine(0,1);
    }
}
