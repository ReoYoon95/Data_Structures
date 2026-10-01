package idusw.dsa.Reo261001.gugudan;

public class Gugu {

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

    public void printUsingRows() {
        // 2 * 1 = 2  3 * 1 = 3 ..... 9 * 1 = 9
        // 2 * 2 = 4 ................ 9 * 2 = 18
        for (int dan = 2; dan <= 9; dan++) {
            System.out.printf("=== %d단 ===\t\t", dan);
        }
        System.out.println();

        // 2. 구구단 내용 출력 (1~9 곱하기)
        for (int i = 1; i <= 9; i++) { // 행이 증가
            for (int dan = 2; dan <= 9; dan++) {
                // \t(탭)을 사용하여 열 간격을 맞춥니다.
                System.out.printf("%d * %d = %2d\t\t", dan, i, dan * i);
            }
            System.out.println(); // 한 줄(1~9 중 하나) 출력이 끝나면 줄바꿈
        }
    }
}
