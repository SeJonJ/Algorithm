package baekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Quiz_4796_study {


    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int cnt = 0;

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(l==0 && p==0 && v==0){
                break;
            }
//            System.out.println(l+" "+p+" "+v);

            int n = v/p;
            int m = v%p;
//            System.out.println(n + " " + m);

            if(m>l){
                n = n+1;
                m = 0;
            }

            result = l*n+m;
            list.add(result);

        }

        // 3 8 20

        for(int i : list){
            cnt++;
            System.out.println("Case "+cnt+": "+i);
        }
    }
}
