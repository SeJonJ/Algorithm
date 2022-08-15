package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz_14226_풀이완료 {
    // https://www.acmicpc.net/problem/14226

    static int n;
    static boolean[][] viewAndList = new boolean[1001][1001];

    static Queue<Emoticon> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        q.offer(new Emoticon(1, 0, 0));

        System.out.println(makeEmo());
    }

    static int makeEmo() {

        while (!q.isEmpty()) {
            Emoticon e = q.poll();
            int view = e.view;
            int list = e.list;
            int time = e.time;

            if (view == n) {
                return time;

            } else {

                // 복사 : 복사는 view 와 list 가 동일한 값이 된다 => view = list
                if (!viewAndList[view][view]) {
                    viewAndList[view][view] = true;
                    q.offer(new Emoticon(view, view, time + 1));
                }

                // 붙여넣기 : 붙여넣기는 현재 view 에서 클립보드(list) 에 있는 이모티콘 갯수를 추가한다
                // view = view + list
                if (view + list <= 1000 && !viewAndList[view + list][list]) {
                    viewAndList[view + list][list] = true;
                    q.offer(new Emoticon(view+list, list, time + 1));
                }

                // 삭제 : 삭제는 현재 view 에서 -1 했을 때 0 과 같거나 0보다 큰 값이 나와야한다.
                if (view - 1 >= 0 && !viewAndList[view - 1][list]) {
                    viewAndList[view - 1][list] = true;
                    q.offer(new Emoticon(view - 1, list, time + 1));

                }
            }


        }
        return -1;

    }
}


class Emoticon {
    int view;
    int list;
    int time;

    Emoticon(int view, int list, int time) {
        this.view = view;
        this.list = list;
        this.time = time;
    }
}
