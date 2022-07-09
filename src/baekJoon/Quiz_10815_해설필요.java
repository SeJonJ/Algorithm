package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Quiz_10815_해설필요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
//            System.out.print(st.nextToken() + " ");
            map.put(Integer.parseInt(st.nextToken()), 0);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)){
                sb.append(1 + " ");
            }else{
                sb.append(0 + " ");
            }
        }

        System.out.println(sb.toString());

    }
}
