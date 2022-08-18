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

        // 확장자만 저장하는 배열 => 확장자를 정렬하기 위한 배열
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            String str = br.readLine().split("\\.")[1];
//            System.out.println("str : " + str.toString());
            // map 의 getOrDefault 메서드를 이용해서 str 이라는 키로 map 을 조회했을 때 value 가 이미 있다면
            // 해당 값을 가져오고, 아니면 0 을 return 한다.
            // 이후 +1 을한다.
            map.put(str, map.getOrDefault(str, 0)+1);

        }

        // map 에서 key 들만 가져와서 ArrayList 에 저장
        for(String s : map.keySet()) {
            arr.add(s);
        }

        // 확장자 정렬 => 기본 오름차순 정렬
        Collections.sort(arr);

        // 정렬한 arr 에서 하나의 값을 꺼내온 후 해당 값을 key 로 두고
        // 다시 map 에서 해당 key 에 맞는 value 를 꺼내온다
        for (String str : arr) {
            bw.write(str + " " + map.get(str)+"\n");
        }
        bw.flush();
    }
}
