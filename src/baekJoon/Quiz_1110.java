package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1110
public class Quiz_1110 {
    static int n, k;
    static int m = 987654321;
    // 배열을 활용해서 풀이 => 십의자리 index = 0, 일의 자리 index=1
    static int[] num = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = n;

        int cnt = 0;

        // m 이 n 과 일치하면 while 문 종료
        // 일치하지 않으면 계속 반복
        while (m != n) {

            // 10보다 작은 경우 앞에 0 을 붙여서 2자리 숫자로 만든다
            if (k < 10) {
                num[0] = 0;
                num[1] = k;
            }else{
                num[0] = String.valueOf(k).charAt(0)-48;
                num[1] = String.valueOf(k).charAt(1)-48;
            }

            // 일의자리와 십의 자리를 더해서 만들어진 수 c
            int c = num[0]+num[1];

            int r; // 덧셈해서 만들어진 수의 일의 자리
            if (c < 10) { // c가 10보다 작으면 r 에는 c 를 그대로 대입
                r = c;
            }else{ // 아니면 1의 자리 숫자르 가져옴
                r = String.valueOf(c).charAt(1)-48;
            }

            // 만들어진 새로운 수 m
            m = num[1]*10+r;
            k = m;

//            System.out.println("a : " + a);
//            System.out.println("b : " + b);
//            System.out.println("c : " + c);
//            System.out.println("m : " + m);

            // 몇번째 사이클인지 cnt
            cnt++;
        }
        System.out.println(cnt);
    }
}
