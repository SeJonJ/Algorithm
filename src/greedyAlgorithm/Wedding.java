package greedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.StringTokenizer;

/*

풀이 포인트!
* 이 문제의 포인트
* 1. Comparable 인터페이스를 사용할 수 있느냐의 여부가 중요하다. 물론 사용하지 않고 하는 방법도 있지만 사용하고 풀면 훨씬 쉽게
* 간단하게 풀 수 있다
*
* 2. A 라는 친구가 들어오는 시간과 B 라는 친구가 나가는 시간이 동일한 경우 현재 결혼식장에 있는 사람들의 수에서
* 나가는 친구의 수를 먼저 빼주고, 그 후 들어오는 친구를 더해주어야한다.
* 이는 문제에서 제시하였다싶이 들어오는 시각이 13시면 13시 정각에 '존재'한는 것이고, 나가는 시간이 '15'시라면 이미 그 시간에는 존재하지 않음으로
* 전체 인원에서 나가는 사람을 먼저 빼고 그 후 들어오는 사람을 더해야한다
*
* * */

public class Wedding {

    static int result = Integer.MIN_VALUE;

    static ArrayList<Friend> list = new ArrayList<Friend>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0; // 현재 전체 인원
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i<n; i++){
            // 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Friend(Integer.parseInt(st.nextToken()), 'S')); // 들어오는 시간, Start 의 S
            list.add(new Friend(Integer.parseInt(st.nextToken()), 'E')); // 나가는 시간, End 의 E
        }

        // ComparableTo 에 따라서 정렬
        Collections.sort(list);

        for(Friend f : list){
            //System.out.println(f.time + " " + f.status);

            // 만약에 status 가 E 라면 cnt 감소
            if(Objects.equals(f.status, 'E')){
                cnt--;
            }else{ // S 라면 전체 인원 cnt 증가
                cnt++;
            }
            //System.out.println("cnt : " + cnt);
            result = Math.max(result, cnt); // 현재 인원과 result 값을 비교해서 다시 result 에 담음
        }

        System.out.println("result : " + result);
    }
}

// 시간을 들어오는 시간과 나가는 시간으로 쪼개서 2개로 구분해서 Friend 변수에 담음
// 또한 Status 라는 변수를 하나 만들어서 들어오는 시각이면 S, 나가는 시각이면 E 로 구분함
class Friend implements Comparable<Friend>{
    int time;
    char status;

    Friend(int time, char status) {
        this.time = time;
        this.status = status;
    }

    //
    @Override
    public int compareTo(Friend o) {
        if(this.time == o.time){ // 만일 시간이 같다면
            return this.status - o.status; // 알파벳으로 내림차순 ==> E 와 S 를 비교해서 E 가 먼저 오도록
        }else{
            return this.time - o.time;
        }

    }
}