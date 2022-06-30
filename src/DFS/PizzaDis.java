package DFS;

import java.util.ArrayList;
import java.util.Scanner;


// 이 문제의 포인트는 도시의 피자 배달 거리 = (하나의 피자집에서 모든 가정집까지의 피자 배달 거리)
// 1. 즉 4가지 조합으로 구성되는 피자집 중 하나씩 뽑아서 각 피자집으로부터 여러 가정집까지의 피자 배달 거리를 계산 후
// 2. 해당 피자집을 모두 더한 값을 도시 피자 배달 거리라는 변수에 저장해 둔다.
// 이후 모든 피자집의 조합을 계싼해서 1~2 에서 계산한 각 조합별 도시의 피자배달 거리 중 최소값을 찾는것
// 어렵다...

public class PizzaDis {
    static int n, m; // 도시의 크기, 영업하는 피자집
    static int[][] city; // 도시 배열
    static int[] combi; // 살아남는 피자집의 갯수 => 최소거리 조합 계산하기 위함
    static int result = Integer.MAX_VALUE; // 최소값을 정하기위한 최대값 배정
    static ArrayList<WayPoint> house = new ArrayList<WayPoint>(); // 가정집 배열
    static ArrayList<WayPoint> shop = new ArrayList<WayPoint>(); // 가게 배열

    static void getMinDis(int num, int startNum) {

        if (num == m) { //
            int sum = 0;

            for (int h = 0; h < house.size(); h++) {
                WayPoint hWay = house.get(h); // 도시에서 집 하나의 좌표 계산
                int dis = Integer.MAX_VALUE;

                for (int c : combi) { // 피자집 조합에서 하나를 꺼내옴
                    WayPoint sWay = shop.get(c); // 피자집 하나의 좌표 계산
                    System.out.println("dis ; " + dis);

//                    System.out.println(sWay.x + " : " + sWay.y);
                    dis = Math.min(dis, Math.abs(hWay.x - sWay.x) + Math.abs(hWay.y - sWay.y));

//                    System.out.println("sum : " + sum);
//                    System.out.println("result : " + result);
                }
                sum+=dis;

            }
//            System.out.println("sum : " + sum);
            result = Math.min(sum, result);


        } else {
            // 여기는 전체 피자집 갯수 중에서 피자집 m 개를 쁍는 조합을 구하는 코드
            for (int i = num; i < shop.size(); i++) {
                combi[num] = i;
                getMinDis(num + 1, startNum + 1);
            }
        }


    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();
        
        city = new int[n][n]; // 도시 배열
        combi = new int[m]; // 조합 배열

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                city[i][j] = scan.nextInt(); 

                if (city[i][j] == 1) { // 도시 배열 중에서 1인 값은 가정집임으로
                    house.add(new WayPoint(i, j)); // 집의 좌표 저장
                } else if (city[i][j] == 2) { // 도시 배열중에서 2인 값은 가게임으로
                    shop.add(new WayPoint(i, j)); // 가게의 좌표 저장
                }
            }
        }

        getMinDis(0, 0);
        System.out.println("result : " + result);
    }


    static class WayPoint {
        int x, y;

        WayPoint() {
        }

        public WayPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
