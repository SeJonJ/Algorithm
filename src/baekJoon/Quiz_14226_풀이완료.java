package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// view 는 현재 화면에 표시되는 이모티콘의 갯수
// list 는 클립보드에 저장된 이모티콘의 갯수
public class Quiz_14226_풀이완료 {
    // https://www.acmicpc.net/problem/14226

    static int n;


    // viewAndList 는 각각의 인덱스 번호가 view 의 이모티콘 갯수, list 의 이모티콘 갯수이다.
    // 예를 들어 viewAndList[1][2] 라면 view 의 이모티콘 갯수는 1, list 의 이모티콘 갯수는 2 를 의미한다
    // 해당 배열은 BFS 가 돌면서 view 와 list 가 똑같은 값을 방문하지 않도록 하기 위한 배열이다.
    static boolean[][] viewAndList = new boolean[1001][1001];

    // queue 에는 Emoticon 클래스 객체를 넣는다.
    // Emoticon 클래스에는 현재 view 이모티콘 갯수, list 이모티콘 갯수, 시간(time) 의 값이 들어간다
    static Queue<Emoticon> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 처음에 있는 view 의 이모티콘 갯수는 0, 클립보드도 0, 시간도 0 초!
        q.offer(new Emoticon(1, 0, 0));

        System.out.println(makeEmo());
    }

    static int makeEmo() {

        while (!q.isEmpty()) {
            Emoticon e = q.poll();
            int view = e.view;
            int list = e.list;
            int time = e.time;

            // view 에 있는 이모티콘의 갯수가 n 과 동일하다면 끝!
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
