package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz_10250 {
    // 6층 : 12방 => X
    // 12층 : 6방 => O

    // 더 높은 층이라도 뒷자리가 더 작은 방으로 간다는 점을 이용해서
    // 그림을 거꾸로 생각한다.
    // 즉 6층에 12개의 방이 아닌 12층에 6개로 구성된 방으로 생각한다.

    // 이러면 앞에있는 두자리는 방번호가 되고, 뒤에 있는 두자리는 층번호가 된다.
    // 기존 : YYXX -> XXYY
    // 이를 통해서 사람이 들어왔을 때 1층 101, 102, 103 ----- 처럼 생각하게 되고
    // 문제 자체가 훨씬 쉬워진다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(findRoom(h, w, n));

        }

    }

    static String findRoom(int h, int w, int n){
        // n 번째 사람의 방번호가 몇층에 속하는지 계산
        int floor = 1;

        // 한층의 총 방의 수(h) * 층수 가 n 보다 작으면 n 번째 사람은 floor 층에 속하게 된다.
        while (h*floor<=n) {
            floor++;
        }

        // 이를 통해서 방번호를 계산한다.
        // n 을 한층에 들어가는 총 방의 수로 나눈 나머지를 생각하면 된다.
        // 예를들어 n = 10 인 경우
        // 사람이면 1층에 6명이 들어간 후 2층에 4번째 번에 속하게 된다.
        // 즉 10%6 했을 때의 값이다.
        int num = n%h;

        // 만약 n%h 가 0 일때는
        // n 의 값은 현재 층-1, num 은 한층의 가장 마지막 방번호로 변경
        if(n%h == 0){
            floor-=1;
            num = h;
        }

//        System.out.println("num : " + num);
//        System.out.println("floor : " + floor);


        // 층수가 10보다 작은 경우 0 을 붙이고
        if (floor < 10) {
            return num+"0"+floor;
        }else{ // 아닌 경우 그대로
            return num+""+floor;
        }

    }
}
