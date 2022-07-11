package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1931
public class Quiz_1931 {
    static int n;
    static ArrayList<Time> list = new ArrayList<Time>();
    static int result = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 회의의 수 입력받기

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 시작 시간과 끝나는 시간 구분
            list.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list); // Comparable 인터페이스에 정의된 ComparableTo 메서드에 따라 정렬

        result = Math.max(sol(0, list), result);


        System.out.println(result);

    }

    static int sol(int cnt, ArrayList<Time> list) {

        int nowEnd = 0; // 현재 끝나는 시간 세팅 초기값은 0

        for (Time o : list) { // list 에서 하나 꺼내기
            // for 문이 돌면서 하나의 Time 객체 꺼내옴
            // 그 객체의 시작 시간을 저장
            int nStart = o.start;

            // 꺼내온 객체의 시작시간이 현재 끝나는 시간보다 크거나 같다면
            // 해당 회의 사용 가능 ====> 회의수 증가 ===> cnt++
            if (nowEnd <= nStart) {
                cnt++;
                nowEnd = o.end; // 그리고 끝나는 시간을 꺼내온 time 객체의 끝나는 시간으로 변경
            }
        }

        return cnt; // for 문이 끝나면 cnt return
    }

}


// 여기가 가장 중요함
// 최대 가능한 회의 수를 가장 쉽게 구하는 방법은 끝나는 시간을 기준으로 다음으로 가능한 회의를 찾는 것
// 시작하는 시간으로 찾는 경우 반례도 많이 나오고 최대 값이 이상하게 나옴
// 나는 처음에 시작하는 시간으로 찾았는데...결국 메모리 초과, 시간 초과 등 다양한 실패에 시달렸음ㅠㅠㅠㅠ

// 때문에 ComparableTo 메서드를 통해서 정렬하는 기준은 끝나는 시간을 기준으로 오름차순으로 정렬하며,
// 만약 끝나는 시간이 같다면 시작 시간도 오름차순으로 정렬한다.
class Time implements Comparable<Time> {
    int start;
    int end;

    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end == o.end) {
            return this.start - o.start;
        } else {
            return this.end - o.end;
        }
    }
}
