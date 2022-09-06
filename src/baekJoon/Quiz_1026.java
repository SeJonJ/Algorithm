package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1026
// 이 문제의 포인트는 주어진 배열 2개를 i 번째 인덱스 끼리 곱하고
// 그 수를 다 더했을 때 최소값을 만들어내는 것이다.

// 최소값을 만들기 위해서는 가장 큰 숫자를 가장 작은 숫자를 곱하고, 가장 작은 숫자는 가장 큰 숫자를 곱한다.
// 즉 배열 2개를 하나는 오름차순 배열, 하나는 내림차순 배열 한 후 곱해서 더하면 된다.

public class Quiz_1026 {
    static int n;
    static ArrayList<Integer> a = new ArrayList<>();
    static ArrayList<Integer> b = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // A 배열 입력받고, 넣기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            a.add(Integer.parseInt(st.nextToken()));

        }

        // B 배열 입력받고, 넣기
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            b.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(leastNum());
    }

    // a 배열은 오름차순 배열,
    // b 배열은 내림차순 배열
    // 두 배열의 i 번째 인덱스끼리 곱하고 그 값을 result 에 계속 더해놓는다.
    static int leastNum(){
        int result = 0;
        Collections.sort(a);
        Collections.sort(b, Collections.reverseOrder());

        for(int i=0; i<n; i++){
            result += a.get(i)*b.get(i);
        }

        return result;
    }
}
