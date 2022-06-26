package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz_2178_dfs_시간초과 {
    static int[][] maze;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = Integer.MAX_VALUE;

    static int n, m;

    public static void findExit(int x, int y, int count){
//        System.out.println(x + " : " + y);
//        System.out.println("count : " + count);
//        System.out.println("n : " + n + "  :: m : " + m);
        if(x == n && y == m){
            result = Math.min(count, result);
        }else{
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx > 0 && ny > 0 && nx<=n && ny<=m && maze[nx][ny] == 1){

                    maze[nx][ny] = 0;
                    findExit(nx, ny, count+1);
                    maze[nx][ny] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //System.out.println(n + " : " + m);

        maze = new int[n+1][m+1];

        for(int i=1; i<=n; i++){

            char[] ch = br.readLine().toCharArray();
            //System.out.println(Arrays.toString(ch));
            //System.out.println(maze.length);
            //System.out.println(maze[i].length);

            for(int j=0; j<ch.length; j++){
                maze[i][j+1] = (int)ch[j] - 48;
                //maze[i][j] = 1;
            }
//            System.out.println("");
//            System.out.println(Arrays.toString(maze[i]));
        }


        maze[1][1] = 0;
        findExit(1, 1, 1);
       System.out.println("count : " + result);
    }
}
