package baekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Quiz_16953 {
    static long a, b;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if( findNumber(a, 0) == Integer.MAX_VALUE){
            bw.append("-1");
        }else{
            bw.write((result+1)+"\n");
        }
        bw.flush();
        bw.close();
    }

    static int findNumber(long sum, int cnt){
        if (sum > b) {
            return result;
        }
        if (sum == b) {
            result = Math.min(result, cnt);
//            System.out.println("result : " + result);

        } else{
            findNumber(sum * 2, cnt+1);
            findNumber(sum * 10 + 1, cnt + 1);
        }

        return result;
    }
}
