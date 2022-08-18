package baekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Quiz_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 확장자와 갯수를 저장하는 map
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // 확장자만 저장하는 배열
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            String str = br.readLine().split("\\.")[1];
//            System.out.println("str : " + str.toString());
            map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);

        }

        for(String s : map.keySet()) {
            arr.add(s);
        }

        Collections.sort(arr);

        for (String str : arr) {
            bw.write(str + " " + map.get(str)+"\n");
        }
        bw.flush();
    }
}
