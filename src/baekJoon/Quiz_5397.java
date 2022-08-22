package baekJoon;

import java.io.*;
import java.util.*;

public class Quiz_5397 {
    static int T;
    // https://www.acmicpc.net/problem/5397
    // https://rays-space.tistory.com/44
    // https://godzz.tistory.com/11


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            keyLogger(str);
        }

    }

    static void keyLogger(String str) throws IOException {

        List<Character> chArr = new LinkedList<Character>();
        ListIterator<Character> iter = chArr.listIterator();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '>':
                    // ListIterator 로 조사했을 때 만약 hasPrevious가 true 라면
                    // iter(커서) 를 한칸 뒤로 이동
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;

                case '<':
                    // ListIterator 로 조사했을 때 만약 hasPrevious가 true 라면
                    // iter(커서) 를 한칸 뒤로 이동
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;

                case '-':
                    // 만약 - 를 만난다면 뒤로 갈 수 있는지 확인후
                    // 뒤로 이동한 뒤 previous() 로 반환된 가장 최근 데이터 삭제
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;

                default:
                    iter.add(str.charAt(i));
                    break;
            }
        }

        for (char c : chArr) {
            bw.write(c);
        }
        bw.write("\n");
        bw.flush();
    }
}
