package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129
// 이진변환 반복하기
public class LV2_3 {
    public static void main(String[] args) {
        sol("110010101001");
    }

    static int[] sol(String s) {
        int[] answer;
        int cnt = 0;
        int zero = 0;

        while (!s.equals("1")) {
            cnt++;
            char[] chArr = s.toCharArray();
            s = "";
            for (int i = 0; i < chArr.length; i++) {
                if (chArr[i] == '0') {
                    zero++;
                    s += "";
                }else{
                    s += chArr[i]+"";
                }
            }
//            String str = s.replace("0", "");
            s = Integer.toBinaryString(s.length());


        }

        System.out.println(cnt + " : " + zero);
        answer = new int[]{cnt, zero};

        return answer;
    }
}
