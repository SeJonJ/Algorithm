package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Algo_PriorityQueue {
    // PriorityQueue : 우선순위 queue
    // queue 중에서도 특별한 queue!! queeu 에 offer 을 통해서 값을 넣었을 때 priorityqueue 는 가장 작은 값부터 꺼내온다
    // 즉 넣은 순서에는 상관없이 현재 queue 가 갖는 값들 중 작은 수부터 가져온다.
    // 이때 reverseOrder 를 사용하면 넣은 순서에 상관없이 현재 queue 값들 중 가장 큰 값을 가져온다.
    // 여기서 queue 안에서 비교는 어떻게 될까? 바로 comparableTo interface 를 구현한 구현 class 를 기준으로 비교된다

    // 문제 풀이 방법
    // 1. D 일 안에 아서 강의를 해주면 m 만큼의 수강료를 받는다. 즉 d 일라고 명시된 강의는 반드시 d 일차에 해야하는 것이 아닌
    // d 일보다 작은 때 아무때나 가도 상관없다!!
    // 2. comparableTo 를 잘 사용해야한다. 역시나 어려운 문제는 어려운 것들이 따라오기 마련인데, queue 와 관련해서
    // 특히 comparableTo 가 많이 사용되는 듯 하다.
    // 3. priorityQueue 는 기본적으로 가장 작은 값을 내보낸다. 다만 reverseOrder 을 사용하는 경우 가장 큰 값을 내보낸다



    // queue 에 관한 추가 설명
    // https://cocoon1787.tistory.com/774

    static ArrayList<DM> arr = new ArrayList<DM>();
    static int n;
    static int max = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        for(int i=0; i<n; i++){
            int m = scan.nextInt();
            int d = scan.nextInt();
            arr.add(new DM(m, d));
            max = Math.max(d, max);
        }

        System.out.println(findMaxMoney(arr));

    }

    static int findMaxMoney(ArrayList<DM> arr){
        int result = 0;
        // reverseOrder 을 사용하면 큰 값을 우선해서 뱉어냄
        PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>(Collections.reverseOrder());

        Collections.sort(arr);

        int j=0;

        for(int i=max; i>=1; i--){ //
            for(; j<n; j++){ //
                if(arr.get(j).day < i ){ // day 가 현재 max 값인 i 보다 작다면 break;
                    break;
                }
                pq.offer(arr.get(j).money); // 작지 않다면 moeny 를 pq 에 저장
            }
            if(!pq.isEmpty()){
                result+=pq.poll(); // pq 가 가장 큰 값을 뱉어내고 이것을 result 에 저장함
            }
        }
        return result;
    }
}

class DM implements Comparable<DM> {
    int money;
    int day;

    DM(int m, int d){
        this.money = m;
        this.day = d;
    }

    @Override
    public int compareTo(DM o) { // 내림차순으로 정렬
       return o.day - this.day;
    }
}
