package baekJoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Quiz_10825 {
    static PriorityQueue<Score> q = new PriorityQueue<Score>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            q.offer(new Score(name, kor, eng, math));
        }

        while (!q.isEmpty()) {
//            sb.append(q.poll().name+"\n");
            bw.write(q.poll().name + "\n");
        }
        bw.flush();
    }
}

class Score implements Comparable<Score> {
    String name;
    int kor;
    int eng;
    int math;

    Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }


    @Override
    public int compareTo(Score o) {
        // 국어 점수가 다르다면 감소하는 순 -> 내림차순
        if (this.kor != o.kor) {
            return o.kor - this.kor;
        }else{
            // 국어 점수는 같고, 영어점수가 다르다면 -> 영어점수는 증가하는순 -> 오름차순
            if (this.eng != o.eng) {
                return this.eng - o.eng;
            }else{
                // 국어점수, 영어점수가 같고, 수학점수가 다르다면 -> 수학점수는 감소하는 순 -> 내림차순
                if (this.math != o.math) {
                    return o.math - this.math;
                }else{
                    // 모든 점수가 같다면 이름을 증가하는 순 -> 오름차순
                    return this.name.compareTo(o.name);
                }
            }
        }
    }
}