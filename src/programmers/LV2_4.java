package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class LV2_4 {

    public static void main(String[] args) {
        int[] a = {1, 4, 2};
        int[] b = {5, 4, 4};

        System.out.println(sol2(a, b));
    }


    static int sol2(int[] a, int[] b){
        int answer=0;

        // 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        // 오름차순
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<a.length; i++){
            pq.add(a[i]);
            q.add(b[i]);
        }

        while (!pq.isEmpty()) {
            answer += pq.poll()*q.poll();
        }

        return answer;
    }
}
