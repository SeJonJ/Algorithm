package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2609
// https://ko.wikipedia.org/wiki/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C_%ED%98%B8%EC%A0%9C%EB%B2%95
// 유클리드 호제법 사용하기
public class Quiz_2609 {
    static int n,m;
    static int gcd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        GCD(m, n % m);

        System.out.println(gcd);
        System.out.println(LCM(gcd));

    }

    // 최대공약수
    static void GCD(int b, int remain){
        // a%b = remain
        // b%remain = remain2
        // remain%remain2 = remain3

        if (gcd != 0) {
            return;
        }
        else if(remain == 0) {
            gcd = b;
            return;
        }
        else if(b%remain == 0) {
            gcd = remain;
            return;
        }
        GCD(remain, b%remain);

    }

    // 최소공배수
    static int LCM(int gcd){
        return (m*n)/gcd;
    }
}
