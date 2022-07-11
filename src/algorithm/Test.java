package algorithm;

public class Test {
    public static void main(String[] args)  {

        Student a = new Student(1, 97);	// 1등급 97점
        Student b = new Student(1, 92);	// 1등급 92점
        Student c = new Student(2, 87); // 2등급 87점

		/*
		   뭘 기준으로 어떻게 비교할까? 그것이 객체 비교의 시작
            마치 SQL 문의 order by 와 비슷하다는 생각도 든다.
            결국 order by 도 특정 컬럼끼리 '비교'해서 '정렬' 하는 것이니까.
		 */

        /*
        4
        0 99
        1 97
        1 92
        2 85


        4
        2 85
        1 92
        1 97
        0 99
        */
    }
}

class Student {

    int grade;	// 등급
    int score;	// 점수

    Student(int grade, int score) {
        this.grade = grade;
        this.score = score;
    }
}