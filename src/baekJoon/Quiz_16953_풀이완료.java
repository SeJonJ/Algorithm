package baekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Quiz_16953_풀이완료 {
    static long a, b; // int 타입으로 설정하면 틀림!! => 문제가 int 가 아닌 long 으로 받기 때문인듯?
    static int result = Integer.MAX_VALUE; // 결과값 -> 처음은 최대값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); // 입력

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        // 만약 아래 dfs 메서드가 돌고 끝난 후 result 를 출력하는데
        // 이때 result 가 변화가 없이 처음과 동일한 Integer.Max_val 이라면 -1 출력
        // 아니라면 현재 result+1 출력
        if( findNumber(a, 0) == Integer.MAX_VALUE){
            bw.append("-1");
        }else{
            bw.write((result+1)+"\n");
        }
        bw.flush();
        bw.close();
    }

    // sum 을 기준으로 dfs 가 돌기 시작
    // 만약 sum 이 b 보다 커지면 그냥 result 를 return => b 보다 커졌다라는건 b 에 도달할 수 없다는 의미임으로 그냥 패스하기위해
    // 변화가 없는 result 를 그대로 출력
    // 만약 sum 이 b 와 동일하다면 즉 a 가 b 가 될 수 있다면 a 가 b 로 바뀔때마다 cnt 값을 계산한 후
    // result 와 cnt 값을 비교해서 더 작은 최소값을 result 에 담음

    // else 구문은 sum 에서 2 를 곱하거나
    // sum 에서 10 을 곱하고 1을 더하는 연산을 함
    // ==> 맨 뒤에 1을 추가한다는 건 결국 현재 있는 값이 10의 자리의 수가 된다는 것이고,
    // 그 후 1의 자리에 1이 들어간다는 의미임으로 sum*10+1
    static int findNumber(long sum, int cnt){
        if (sum > b) {
            return result;
        }
        if (sum == b) {
            result = Math.min(result, cnt);
//            System.out.println("result : " + result);

        } else{
            findNumber(sum * 2, cnt+1);
            findNumber(sum * 10 + 1, cnt + 1);
        }

        return result;
    }
}
