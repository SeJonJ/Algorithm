package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardCheck {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();


        checkAll(str);

    }

    public static void checkAll(String str){
        char[] ch = str.toCharArray();
        System.out.println(ch.length);

        if(ch.length == 14){ // 길이가 14자리일때는 6번째 자리를 체크해야함
            if(!(ch[6] == ' ' || ch[6] == '-')){
                System.out.println("잘못된 정보입니다");
                return;
            }
        }else if(ch.length == 19){ // 길이가 16자리일 때는 각각 6, 9 14 번째 자리를 체크해야함
            if(!(ch[4] == ' ' || ch[4] == '-' || ch[9] == ' ' || ch[9] == '-'  || ch[14] == ' ' || ch[14] == '-' )){
                System.out.println("잘못된 정보입니다");
                return;
            }
        }else if(ch.length > 16){ // 길이가 16 이상인 번호는 잘못된 정보
            System.out.println("잘못된 정보입니다");
            return;
        }

        for(int i=0; i<ch.length; i++){
            int check = ch[i];

            if(ch[i]==' ' || ch[i]=='-'){ // - 나 공백은 무시
                continue;
            }
//            System.out.println("check : " + check);
            if(!(48 <= check && check <=57)){ // 근데 48 보다 크거나 57 미만이 아닌경우 체크
                // int 형들의 아스키 코드 값은 48 이상 57 이하
                System.out.println("잘못된 정보입니다");
                return;
            }
        }

        System.out.println(str+" 는 올바른 정보입니다");
    }

}
