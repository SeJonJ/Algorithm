package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1193
public class Quiz_1193 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] lvl = new int[n+1];
        lvl[1] = 1;

        /*
        * 1층  1/1
        * 2층  1/2 2/1 => 3개
        * n번째  2   3
        * 3층  3/1 2/2 1/3 => 6개
        * n번째  4   5   6
        * 4층   1/4 2/3 3/2 4/1 => 10개
        * n번째  7    8   9   10
        * 5층    5/1 4/2 3/3 2/4 1/5 => 15개
        * n번째   11   12   13  14  15
        *
        * i 층 의 마지막 번호 => 이전층 갯수 + 현재층수(i)
        * i가 홀수라면 : i/1 i-1/1+1 i-2/1+2 i-3/1+3  ------ 1/m => 현재 층수만큼 반복
        * i가 짝수라면 : 1/i 1+1/i-1 1+2/i-2 1+3/i-3 ------ m/1 => 현재 층수만큼 반복
         * */
        if(n==1) System.out.println("1/1");

        for(int i=2; i<=n; i++){
            // i 층의 마지막 번호 확인
            // n 이 lvl[i] 보다 작다면 n 은 i 번째 층에 포함된다는 것을 알 수 있다.
            lvl[i] = lvl[i-1]+i;

            // n 이 몇번째 층에 속하는지 확인
            if (n <= lvl[i]) {
                // i 가 짝수면 1/i 에서 시작
                // i 가 홀수면 i/1 에서 시작
                int a = i;
                int b = 1;
//                System.out.println("i : "+i);

                // n번째 값은 현재 층 처음 시작값에서 몇번째 위치에 있는지
                int m = n-(lvl[i-1]+1);


                if ((i) % 2 == 0) {
                    System.out.println((b + m) + "/" + (a - m));
                    break;
                }else{
                    System.out.println((a - m) + "/" + (b + m));
                    break;
                }


            }
        }



    }
}
