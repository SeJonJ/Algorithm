package baekJoon;

import java.io.*;
import java.util.HashMap;

public class Quiz_11652 {
    // 카드의 숫자와 갯수를 저장하기 위한 map
    static HashMap<Long, Integer> map = new HashMap<Long, Integer>();

    // 최종 결과를 저장하기 위한 result
    static long result = 0;

    // 최대값을 저장하기 위한 max
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long d = Long.parseLong(br.readLine());
            // 하나의 카드를 입력받을 때마다 map.getOrDefault 메서드를 실행해서 해당 값이 있으면 해당 값을 가져오고, 아니면 0 을 가져온다
            // 그리고 +1 => 이를 통해서 map 에 없었던 카드는 1 로 들어가고 있었던 카드는 기존값+1
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        // map 의 forEach 메서드 : 람다식을 사용해서 구현한다.
        // 일종의 향상된 for 문으로 생각하면 될듯?
        // 여기서 l 은 key, i 는 value 를 의미한다.
        map.forEach((l, i) -> {

            // 현재 max 가 i 보다 작으면 => 즉 현재 value 가 max 보다 크다면
            if (max < i) {
                // result 에 현재 l(key)을 저장하고
               result = l;
               // max 에 현재 i 를 저장한다.
               max = i;
            } else if (max == i) {
                // 만약 현재 max 와 i 가 일치한다면
                // result 에는 더 작은 값을 비교해서 넣는다.
                result = Math.min(result, l);
            }
        });

        // 그리고 출력하면 끝!!
        bw.write(result + "\n");
        bw.flush();

    }
}

