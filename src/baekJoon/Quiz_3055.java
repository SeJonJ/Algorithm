package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz_3055 {
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

                // 물에 대해서 queue 가 끝나면 이제 고슴도치가 움직이기 시작한다.
                if (now.name.equals("S")) {

                    // 고슴도치가 다음 방문하는 곳이 5 라면
                    // map 에서 5는 비버굴을 의미함으로 도착한 것으로 취급한다
                    if (map[nx][ny] == 5) {

                        // 도착지까지의 움직인 시간을 min 에 저장한다.
                        // 이때 현재 min 과 비교해서 최소값을 저장한다.
                        min = Math.min(min, now.cnt + 1);

                    }

                    // 만약 다음 방문하는 곳이 0 인 경우 해당 좌표에 방문한다.
                    // 만약 다음 방문하는 곳이 1인 경우 물 배열에서 해당 좌표의 값을 조사한다.
                    // 물 배열은 해당 좌표까지의 시간을 저장함으로
                    // 고슴도치가 도착하는 시간 즉 now.cnt+1 보다 물이 해당 좌표에 도착하는 시간이 작은 경우에만
                    // 해당 좌표를 방문한다.
                    // 이는 조건 3을 만족하기 위함으로 동일한 좌표에 도착하더라도 물이 3초만에 도착하고, 고슴도치도 3초만에 도착한다면
                    // 고슴도치는 해당 좌표에 갈 수 없기 때문에 고슴도치는 항상 물보다 먼저 해당 좌표에 도착해야한다.
                    if (map[nx][ny] == 0 || (map[nx][ny] == 1 && water[nx][ny] > now.cnt + 1)) {
                        map[nx][ny] = 4;

                        // animal 배열에는 고슴도치가 해당 좌표에 방문한 시간을 저장한다.
                        animal[nx][ny] = now.cnt + 1;

                        // 그리고 queue 에 넣는다.
                        q.offer(new Move("S", nx, ny, now.cnt + 1));

                        // map 에서 고슴도치가 이미 방문한 곳도 다시 확인한다.
                        // 이는 물 배열과 마찬가지로 해당 좌표에 고슴도치가 도착하는 최솟값을 확인하기 위해서이다.
                    } else if (map[nx][ny] == 4) {
                        if (now.cnt + 1 < animal[nx][ny]) {
                            animal[nx][ny] = now.cnt + 1;
                            q.offer(new Move("S", nx, ny, now.cnt + 1));
                        }
                    }

                    // name 이 * 인 애들 즉 물은 아래 if 문을 실행한다
                } else if (now.name.equals("*")) {
                    // 만약 map 에서 탐색했을 때 다음 방문할 곳이 0(빈칸)이라면
                    if (map[nx][ny] == 0) {
                        // 방문 후 1로 변경
                        map[nx][ny] = 1;

                        // 물 배열에는 현재 cnt 값 +1 을 한다.
                        water[nx][ny] = now.cnt + 1;

                        // 그리고 queue 에 넣는다.
                        q.offer(new Move("*", nx, ny, now.cnt + 1));

                        // 만약 다음 방문할 곳이 이미 물이 이미 방문한 곳이라면
                    } else if (map[nx][ny] == 1) {
                        // 물 배열에서 해당 좌표의 값을 확인한다.
                        // 이때 확인한 값이 현재 now.cnt+1 보다 큰 수라면
                        // 물 배열의 값을 현재 now.cnt+1 로 바꾼다.
                        // 이는 물 배열에서 해당 좌표에 도착했을 때 최소값을 저장하기 위해서이다.
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
    int cnt; // 움직힌 횟수(시간)

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
