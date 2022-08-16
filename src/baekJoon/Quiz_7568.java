package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Quiz_7568 {
    static int[] arr;
    static PriorityQueue<Dungchi> q = new PriorityQueue<Dungchi>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            q.offer(new Dungchi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));

        }

        while (!q.isEmpty()) {
            Dungchi d = q.poll();
            System.out.println(d.height + " " + d.weight + " " + d.num);
        }
    }
}

class Dungchi implements Comparable<Dungchi>{
    int weight;
    int height;
    int num;

    Dungchi(int weight, int height, int num) {
        this.weight = weight;
        this.height = height;
        this.num = num;
    }

    @Override
    public int compareTo(Dungchi o) {
        if (this.weight != o.weight) {
            return this.height-o.height;
        }else{
            return o.height-this.height;
        }
    }
}