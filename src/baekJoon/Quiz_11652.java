package baekJoon;

import java.io.*;
import java.util.HashMap;

public class Quiz_11652 {
    static HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    static long result = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long d = Long.parseLong(br.readLine());
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        map.forEach((l, i) -> {

            if (max < i) {
               result = l;
               max = i;
            } else if (max == i) {
                result = Math.min(result, l);
            }
        });
        bw.write(result + "\n");
        bw.flush();

    }
}

