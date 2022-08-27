package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1647
public class Quiz_1647 {
    static int n, m;
    static int[] parent;
    static ArrayList<City> arr = new ArrayList<City>();
    static int result = 0;
    static int max = Integer.MIN_VALUE;

    // 이 문제의 포인트는 마을을 2개로 나눈 후 간선 유지비의 최소값을 구하는 것
    // 마을을 2개로 나눈다는 것은 결국 최소 스패닝 트리를 구한 후 임의의 간선 하나만 잘라도
    // 하나의 집 == 하나의 마을이 된다는 점을 이용하면 된다.

    // 즉, 최소 스패닝 트리를 구하는 크루스칼 알고리즘을 이용해서 최소 간선수에 따른 최소 유지비만 구하고,
    // 거기서 가장 유지비가 많이 드는 간선만 잘라내면....
    // 하나의 집 == 하나의 마을 && 크루스칼 알고리즘을 통해서 만들어진 마을
    // 2개의 마을이 만들어진다.
    // 미친 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 부모 노드 초기화
        parent = new int[n+1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr.add(new City(from, to, cost));
        }

        // cost 오름차순으로 정렬
        Collections.sort(arr, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.cost - o2.cost;
            }
        });

        // 정렬된 arr 에 대해서 union - find 를 이용해서 최소값을 찾는다.
        for (City c : arr) {
            if (find(c.from) != find(c.to)) {
                union(c.from, c.to);
                result +=c.cost;

                // 동시에 MST 에서 사용되는 가장 큰 유지비를 찾아서 max 에 저장한다.
                max = Math.max(c.cost, max);
            }
        }

        // 다시 말하지만 하나의 집 == 하나의 마을
        // 때문에 가장 큰 유지비가 드는 도로(간선) max 를 현재 최소 유지비에서 빼주면
        // 2개의 마을과 이에 따른 최소 유지비가 나온다.
        System.out.println(result-max);

    }

    // find 를 이용해서 매개변수로 들어온 index 의 부모 노드를 찾는다.
    static int find(int index){
        // 만약 parent[index] 가 매개변수의 값과 동일하다면(어떤 노드와도 연결되지 않은 상태)
        // 그대로 index return
        if (parent[index] == index) {
            return index;
        }
        // 아니면 find 를 계속 돌려서 해당 인덱스에 대해 부모 노드를 찾아낸다.
        return parent[index] = find(parent[index]);
    }

    // from, to 를 매개변수로 받는다.
    // find 를 통해 찾아낸 부모 노드에 대해서 비교!!
    // 만약 f > t 라면 from 의 부모노드가 to 보다 크다 => t 의 부모노드를 f 의 부모노드 값으로 변경
    static void union(int from, int to){
        int f = find(from);
        int t = find(to);

        if (f > t) {
            parent[t] = f;
        }else{
            parent[f] = t;
        }
    }
}

class City{
    int from;
    int to;
    int cost;

    City(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
