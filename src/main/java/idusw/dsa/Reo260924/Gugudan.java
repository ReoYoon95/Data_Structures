package idusw.dsa.Reo260924;

public class Gugudan {
    void printByCols(int cols) {
//        지정한 cols 수에 따라 구구단 출력
        System.out.println("printByCols 결과: ");

//        열 단위로 포문 반복
        for (int start =2; start < 10; start += cols) {

            int end = Math.min(start + cols -1, 9); //연 단위의 마지막 단, 9단을 넘지 않도록 예외사황 체크

//            각 줄에 행별로 곱이 1씩 늘어나면서 곱해줘야 하기에 곱->단 으로 2중 포문
            for (int gop = 1; gop < 10; gop++) {
                for (int dan = start; dan <= end; dan++) {
                    System.out.printf("%d * %d = %2d\t", dan, gop, dan * gop);
                }
                System.out.println();
            }
//            행 끝날때마다 구분자
            System.out.println("=====================================================");

        }

    }

    void printBase() {
//        2~9단을 한행에 한단씩 출력
        System.out.println("printBase 결과: ");
        for (int dan = 2; dan < 10; dan++) {
            for (int gop = 1; gop <= 9; gop++) {
                System.out.printf("%d * %d = %2d\n", dan, gop, dan * gop);
            }
            System.out.println();
        }
    }
}
