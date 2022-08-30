package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz_1193 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] lvl = new int[n+1];
        lvl[1] = 1;

        /*
        * 1층 1 1/1
        * 2층 3 1/2 2/1
        *        2  3
        * 3층 6 3/1 2/2 1/3
        *        4   5   6
        * 4층 10 1/4 2/3 3/2 4/1
        *        7    8   9   10
        * 5층 15 5/1 4/2 3/3 2/4 1/5
        *        11   12   13  14   15
        *
        * n = 이전층 갯수 + 현재층 : m/1 m-1/1+1 m-2/m+2 m-3/m+3  ------ 1/m => 현재 층수만큼 반복
        * */
        if(n==1) System.out.println("1/1");

        for(int i=2; i<=n; i++){
            lvl[i] = lvl[i-1]+i;

            if (n <= lvl[i]) {
                // i 가 짝수면 1/i 에서 시작
                // i 가 홀수면 i/1 에서 시작
                int a = i;
                int b = 1;
//                System.out.println("i : "+i);

                int m = n-(lvl[i-1]+1);
//                System.out.println("m : " + m);
//                System.out.println(lvl[i - 1] + 1);

                if ((i) % 2 == 0) {
//                    System.out.println("짝수 : "+(lvl[i-1]+1));
                    System.out.println((b + m) + "/" + (a - m));

                }else{
//                    System.out.println("홀수 : "+(lvl[i-1]+1));
                    System.out.println((a - m) + "/" + (b + m));

                }

                break;
            }
        }



    }
}
