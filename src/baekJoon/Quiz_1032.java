package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1032
public class Quiz_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        StringBuilder sb = new StringBuilder(str);

        for (int i = 1; i < n; i++) {

            String tmp = br.readLine();

            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) != tmp.charAt(j)){

                    sb.setCharAt(j, '?');
                }
            }
        }

        System.out.println(sb.toString());
    }
}
