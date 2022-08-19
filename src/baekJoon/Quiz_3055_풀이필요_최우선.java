package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz_3055_풀이필요_최우선 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static int[][] water;
    static int min = Integer.MAX_VALUE;
    static int r, c;

    static PriorityQueue<Move> q = new PriorityQueue<>();

    // 비버굴 D : 5
    // 고슴도치 S : 4
    // 빈칸 . : 0
    // 물 * : 1
    // 돌 X : 9
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        water = new int[r][c];


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

        if (min == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        }else{
            System.out.println(min);
        }

    }

    static void findViVo() {


        while (!q.isEmpty()) {
            Move now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }

                if (now.name.equals("S")) {
                    if (map[nx][ny] == 0 || (map[nx][ny] ==1 && water[nx][ny] > now.cnt+1)) {
                        map[nx][ny] = 4;
                        q.offer(new Move("S", nx, ny, now.cnt + 1));

                    } else if (map[nx][ny] == 5 ) {
//                        System.out.println("now.x : " + now.x);
//                        System.out.println("now.y : " + now.y);
                        min = Math.min(min, now.cnt + 1);

                    }

                } else if (now.name.equals("*")) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        water[nx][ny] = now.cnt+1;
                        q.offer(new Move("*", nx, ny, now.cnt+1));

                    }
                }
            }
        }
    }
}


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
