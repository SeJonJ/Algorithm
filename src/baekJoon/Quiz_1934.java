package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1934
// 유클리드 호제법 사용하기
public class Quiz_1934 {
    static int gcd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int max = Math.max(n, m);
            int min = Math.min(n, m);

            GCD(max, min);

            System.out.println(lcm(n, m, gcd));
        }
    }

    static void GCD(int n, int m){

        if (n % m == 0) {
            gcd = m;
            return;
        }
        GCD(m, n % m);
    }

    static int lcm(int n, int m, int g){
        return (n*m)/g;
    }
}
