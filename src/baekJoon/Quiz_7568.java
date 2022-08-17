package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz_7568 {

    static ArrayList<Dungchi> arr = new ArrayList<>();
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        rank = new int[n];
        // 초기값 1 => 1등이 시작임으로 1로 초기화
        Arrays.fill(rank, 1);

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            arr.add(new Dungchi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }

        for (int i = 0; i<n; i++){
            Dungchi d = arr.get(i);

            for(int j=i+1; j<n; j++){
                if (d.compareTo(arr.get(j)) == -1) {
                    // i 번째 사람과 j 번째 사람을 비교했을 때 j 번째 사람이 i 번째보다 큰 경우
                    rank[i]++;
                } else if (d.compareTo(arr.get(j)) == 1) {
                    // i 번째 사람과 j 번재 사람을 비교했을 때 i 번째 사람이 j 번째보다 큰 경우
                    rank[j]++;
                }
            }
        }

        for (int i : rank) {
            System.out.print(i + " ");
        }

    }
}

class Dungchi implements Comparable<Dungchi>{
    int weight;
    int height;

    Dungchi(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Dungchi o) {
        // 만약 몸무게와 키가 모두 크다면 1
        if (this.weight > o.weight && this.height > o.height) {
            return 1;

        // 만약 몸무게와 키 모두 작다면 -1
        } else if (this.weight < o.weight && this.height < o.height) {
            return -1;

        }else{ // 이 외의 경우 -> 즉 둘중 하나만 크고, 하나는 작을때
            return 0;
        }

    }
}