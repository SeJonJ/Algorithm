package programmers;

public class LV2_2_틀림 {
    public static void main(String[] args) {
        findStr("for the last week");
    }

    static String findStr(String s) {

        char[] ch = s.toCharArray();

        String answer = "";

        for (int j = 0; j < ch.length; j++) {
            if (ch[j] == ' ') {
                answer += ch[j];
                continue;
            } else if (j == 0 && 'a' <= ch[j + 1] && ch[j + 1] <= 'z') {
                ch[j] = (char) (ch[j] - 32);
                answer += ch[j];
                continue;
            }

            if ('a' <= ch[j] && ch[j] <= 'z' && ch[j-1] == ' ') {

                ch[j] = (char) (ch[j] - 32);
                answer += ch[j];

            } else if ('0' <= ch[j] && ch[j] <= '9' && 'A' <= ch[j + 1] && ch[j + 1] <= 'Z') {
                ch[j + 1] = (char) (ch[j + 1] + 32);
                answer += ch[j + 1];

            } else if ('A' <= ch[j] && ch[j] <= 'Z') {
                ch[j] = (char) (ch[j] + 32);
                answer += ch[j];
            } else {
                answer += ch[j];
            }


        }
        System.out.println(answer);

        return answer;
    }
}
