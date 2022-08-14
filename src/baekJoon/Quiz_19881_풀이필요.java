package baekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Quiz_19881_풀이필요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int king = Integer.parseInt(st.nextToken());
        int queen = Integer.parseInt(st.nextToken());
        int lock = Integer.parseInt(st.nextToken());
        int bishop = Integer.parseInt(st.nextToken());
        int knight = Integer.parseInt(st.nextToken());
        int pon = Integer.parseInt(st.nextToken());

        bw.write(1 - king+" ");
        bw.write(1 - queen+" ");
        bw.write(2 - lock+" ");
        bw.write(2 - knight+" ");
        bw.write(2 - bishop+" ");
        bw.write(8 - pon+"");
        bw.flush();
    }
}
