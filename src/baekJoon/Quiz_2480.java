package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n == m && m == k){
            System.out.println(10000+(n*1000));
        }else if(n!=m && m!=k && n!=k){
            int result = Math.max(n, m);
            result = Math.max(result, k);
            System.out.println(result * 100);
        }else{
            if(m == k){
                System.out.println(1000 + (m * 100));
            }else{
                System.out.println(1000 + (n * 100));
            }
        }
    }
}
