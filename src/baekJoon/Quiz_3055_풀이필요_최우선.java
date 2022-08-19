package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz_3055_풀이필요_최우선 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 입력받는 지도 배열
    static int[][] map;

    // 물의 방문 배열
    static int[][] water;

    // 고슴도치 방문 배열
    static int[][] animal;
    static int r, c;
    static int min = Integer.MAX_VALUE;
    static PriorityQueue<Move> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        water = new int[r][c];
        animal = new int[r][c];

        // D 나 C *, X 등 모두 char 값을 입력받는다
        // 이러면 추후 계산하기 귀찮아서...
        // 내가 임의로 int 형으로 바꿔서 map 에 넣어두었다.
        // 비버굴 D : 5
        // 고슴도치 S : 4
        // 빈칸 . : 0
        // 물 * : 1
        // 돌 X : 9
        for (int i = 0; i < r; i++) {
            String str = br.readLine();

            for (int j = 0; j < c; j++) {
                char[] ch = str.toCharArray();

                if (ch[j] == 'D') {
                    map[i][j] = 5;
                } else if (ch[j] == 'S') {
                    map[i][j] = 4;
                    q.offer(new Move("S", i, j, 0));

                } else if (ch[j] == '*') {
                    map[i][j] = 1;
                    q.offer(new Move("*", i, j, 0));

                } else if (ch[j] == 'X') {
                    map[i][j] = 9;
                } else if (ch[j] == '.') {
                    map[i][j] = 0;
                }
            }

        }

        findViVo();
        // min 값이 변화가 없다면(그대로 Integer.MAX_VALUE 라면 KAKTUS 출력, 아니면 MIN 출력
        System.out.println(min == Integer.MAX_VALUE ? "KAKTUS" : min);

    }

    static int findViVo() {


        while (!q.isEmpty()) {
            // PriorityQueue 임으로 당연히 name 이 * 인 애들만 먼저 튀어나오게 된다.
            // 즉 map 에서 물만 먼저 나오게 된다.
            Move now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == 9) {
                    continue;
                }

                if (now.name.equals("S")) {


                    if (map[nx][ny] == 5) {

                        min = Math.min(min, now.cnt + 1);

                    }

                    if (map[nx][ny] == 0 || (map[nx][ny] == 1 && water[nx][ny] > now.cnt + 1)) {
                        map[nx][ny] = 4;

                        animal[nx][ny] = now.cnt + 1;

                        q.offer(new Move("S", nx, ny, now.cnt + 1));

                    } else if (map[nx][ny] == 4) {
                        if (now.cnt + 1 < animal[nx][ny]) {
                            animal[nx][ny] = now.cnt + 1;
                            q.offer(new Move("S", nx, ny, now.cnt + 1));
                        }
                    }

                    // name 이
                } else if (now.name.equals("*")) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;

                        water[nx][ny] = now.cnt + 1;

                        q.offer(new Move("*", nx, ny, now.cnt + 1));

                    } else if (map[nx][ny] == 1) {
                        if (water[nx][ny] > now.cnt + 1) {
                            water[nx][ny] = now.cnt + 1;
                            q.offer(new Move("*", nx, ny, now.cnt + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }
}

// 물이 먼저 map 을 탐색해야함으로
// Comparable 를 사용해서 this.name 과 o.name 을 비교후 * 가 먼저 출력되도록 한다.
class Move implements Comparable<Move> {
    String name;
    int x;
    int y;
    int cnt;

    Move(String name, int x, int y, int cnt) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Move o) {
        return this.name.compareTo(o.name);
    }
}
