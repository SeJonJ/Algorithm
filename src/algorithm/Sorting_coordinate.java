package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11650
public class Sorting_coordinate {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        ArrayList<Point> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();

            list.add(new Point(x, y));
        }

        Collections.sort(list);
        for(Point p : list){
            System.out.println(p.x + " " + p.y);
        }
    }
}

// comparable 인터페이스의 구현체
// 이 comparable 인터페이스를 구현한 구현 클래스는 아래의 compareTo 메소드를 통해 객체간 순서를 비교할 수 있다
// 즉 Comparable 인터페이스를 구현한 클래스는 해당 객체들에게 순서가 존재하게 된다.
// 또한 이 인터페이스의 구현체 클래스의 객체는 Collection.sort 를 통해 아주 쉽게 정렬이 가능하다

// sort 매서드의 기본은 오름차순 => 즉 앞에 오는 수에서 뒤에 오는 수를 뺐을 때 음수가 나오면 그대로, 양수가 오면 자리변경
// reverseOrder() 를 사용할 경우 내림차순 => 즉 앞에 오는 수에서 뒤에 오는 수를 뺐을 때 양수가 나오면 그대로, 음수가 나오면 자리변경
class Point implements Comparable<Point> {
    public int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // 객체를 비교해주는 compareTo 메서드 => 이 메서드는 int 를 return 함
    // 대상 객체와 넘어오는 객체를 비교해서 int 양수면 정렬, 0 이면 그대로, 음수면 정렬 의 형태를 취한다
    // 더 자세하게 정리하자면 다음과 같다. 기본은 오름차순 정렬
//     대상 객체 x 와 넘어오는 객체 o 를 비교해서 x - o 가 양수라면 x > o 임을 알 수 있고 이로인해 x-> o 순서가 된다
//     대상 객체 x 와 넘어오는 객체 o 를 비교해서 x - o 가 음수라면 x < o 임을 알 수 있고 이로인해 o->x 순서가 된다
//     최종 정리를 하자면 음수값이 return 되면 오름차순 정렬, 양수값이 return 되면 내림차순 정렬

    // 여기서 중요한 점은 오름차순의 경우 당연하게도 앞에있는 숫자가 뒤에잇는 숫자보다 작다.
    // 때문에 앞에오는 숫자 - 대상 객체, 작은 숫자 - 에서 뒤에 오는 숫자 - 넘어오는 객체, 큰 숫자 - 를 빼서 음수값을 만들어서 오름차순 정렬을 하는 것이다.

    // 반대로 내림차순의 경우 당연하게도 앞에 있는 숫자가 뒤에 있는 숫자보다 크다.
    // 때문에 앞에 오는 숫자 - 대상 객체, 큰 숫자 - 에서 뒤에 오는 숫자 - 넘어오는 객체, 작은 숫자 - 를 빼서 양수값을 넘기면 sort 의 기본은 내림차순 정렬이기 때문에 양수값이 넘어오면
    // 앞의 값이 뒤의 값이 크다고 간주하고 sort 매서드가 내림차순 정렬을 하기위해 앞과 뒤의 숫자를 교환해버리게 된다.
    // 즉 오름차순 정렬로 바뀌어 버리는 것이다.
    // 이를 해결하기 위해서는 두 가지 방법이 있을 수 있다.
    // 1. -(앞의 값 - 뒤의 값)
    // 2. 뒤의 값- 앞의 값


    // 기본 기준은 음수

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return o.y-this.y;
        }else{
            return this.x-o.x;
        }
    }

}
