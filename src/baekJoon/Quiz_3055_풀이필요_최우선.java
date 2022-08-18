package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz_3055_풀이필요_최우선 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static int[][] map;

    // 고슴도치 D : 4
    // 빈칸 . : 0
    // 물 * : 1
    // 돌 X : 9
    // 탈출구 S : 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for(int i=0; i<r; i++){
            String str = br.readLine();
//            System.out.println("st : "+st.nextToken());

            for(int j=0; j<c; j++){
                char[] ch = str.toCharArray();

//                System.out.println(Arrays.toString(ch));
                if (ch[j] == 'D') {
                    map[i][j] = 4;
                } else if (ch[j] == 'S') {
                    map[i][j] = 5;
                } else if (ch[j] == '*') {
                    map[i][j] = 1;
                } else if (ch[j] == 'X') {
                    map[i][j] = 9;
                } else if (ch[j] == '.') {
                    map[i][j] = 0;
                }
                System.out.print(map[i][j]);
            }

            System.out.println();
        }


    }
}
