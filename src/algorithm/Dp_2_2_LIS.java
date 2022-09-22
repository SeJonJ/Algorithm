package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 가장 높은 탑 쌓기 LIS
/*
 첫째줄에 벽돌의 수가 주어지고
 둘째줄부터 각 줄에 한 개의 벽돌에 관한 정보인 벽돌의 밑면의 넓이, 벽돌의 높이, 무게가 차례대로 주어진다

  이때 가장 높이 쌓을 수 잇는 벽돌의 높이는?

*
* */
public class Dp_2_2_LIS {
    // i 번째 벽돌을 가장 위에 놓았을 때 벽돌의 최대 높이
    static int[] dy;

    // 벽돌에 대한 정보를 저장하기 위한 list
    static ArrayList<Stone> list = new ArrayList<Stone>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dy = new int[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Stone(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 벽돌을 넓이 기준 내림차순 정렬
        // 이 정렬을 통해 넓이는 이미 계산되었고, 높이만 계산하면 됨
        Collections.sort(list , (o1, o2)->{
            return o2.s - o1.s;
        });

        list.forEach((o)->{
            System.out.println(o.s+" "+o.w);
        });

        System.out.println(sol());
    }

    static int sol(){
        // dy 의 가장 첫번째에는 list 의 0번째 벽돌이 위치하게 됨
        dy[0] = list.get(0).h;

        // answer 은 dy[0] 으로 초기화해야하는데
        // 이는 맨 처음의 높이가 가장 큰 높이가 될 수 있기 때문임
        int answer = dy[0];

        // list 가 돌기 시작
        // 이때 list i 번째 값이 탑의 가장 위에 위치하게 됨
        // 즉 밑의 작업은 i 번째 벽돌의 밑에 올 수 있는 벽돌을 찾고,
        // 동시에 최대 높이로 만들 수 있는 값을 찾는 것
        for(int i=1; i<list.size(); i++){
            int maxH = 0;

            for(int j=i-1; j>=0; j--){

                // i 번째의 벽돌이 가장 위에 잇고, 아래에는 i 번째 벽돌보다 무거운 벽돌이 와야한다
                // dy 에는 i 번째 벽돌을 가장위에 올려두었을 때 구할수 잇는 최대 높이가 저장됨

                // 이때 i 번째 벽돌 아래에 j 번째 벽돌이 올 수 있다면 결국 j 번째 벽돌까지의 최대 높이가
                // i 번째 벽돌을 맨 위에 두는 최대값이 된다.
               if(list.get(j).w > list.get(i).w && dy[j]>maxH){
                    maxH = dy[j];
                }
            }

            // 최종적으로 i 번째 벽돌의 높이는 i-1 에서 계산된 최대 높이값 + i 번째 벽돌의 높이
            dy[i] = maxH + list.get(i).h;

            // dy[i] 에서도 최대값을 찾는다
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }
}

class Stone{
    int s;
    int h, w;

    Stone(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }
}
