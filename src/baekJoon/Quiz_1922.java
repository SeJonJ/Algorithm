package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Quiz_1922 {
    static int n, m;
    static int[] parent; // 부모 노드
    static ArrayList<Computer> arr = new ArrayList<Computer>();

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 부모 노드 : 기본값을 자기 자신을 초기화
        parent = new int[n + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr.add(new Computer(from, to, cost));
        }

        Collections.sort(arr, new Comparator<Computer>() {

            // Compartor 를 사용해 cost 오름차순으로 정렬
            @Override
            public int compare(Computer o1, Computer o2) {
                return o1.cost - o2.cost;
            }
        });

        // 정렬된 arr 에서 하나씩 꺼내서 find 와 union 을 실행한다.
        for (Computer c : arr) {

            // find 에서 부모 노드가 다르게 나온 경우만 => 사이클이 없는 경우만
            // result 에 + 한다 => 최소 신장 트리에 추가한다.
            if (find(c.from) != find(c.to)) {
                union(c.from, c.to);
                result += c.cost;
            }
        }

        System.out.println(result);

    }


    // 부모 노드 찾기 메서드 => find
    static int find(int index) {
        // parent[index] == index 인 경우는 어떤 노드와도 연결되어있지 않은 상태임으로
        // 자기 자신 index 를 return
        if (parent[index] == index) {
            return index;
        }
        // 아니면 find 를 통해서 부모 노드를 return
        return parent[index] = find(parent[index]);
    }

    // 합치기(병합) 메서드 => union
    static void union(int from, int to) {
        // from 과 to 의 부모 노드 확인
        from = find(from);
        to = find(to);

        // find 메서드 실행 후 더 높은 값으로 부모 노드 설정
        // 즉, 작은쪽의 부모 노드 값을 큰 쪽의 부모 노드 값으로 변경
        // 예를 들어 1 - 3 이 있다면
        // 1 의 부모노드는 3, 3의 부모노드는 3 이 되는 것이다.
        if (from > to) {
            parent[to] = from;
        } else {
            parent[from] = to;
        }
    }
}

class Computer {
    int from;
    int to;
    int cost;

    Computer(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }


}