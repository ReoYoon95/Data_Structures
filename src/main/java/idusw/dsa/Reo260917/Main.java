package idusw.dsa.Reo260917;

public class Main {
    static void main() {
        IO.println(String.format("Hello and welcome!"));

//        클래스 ( 객체에 대한 정의, 설계) 로 부터 객체를 생성하고 (메모리 영역 중 힙에 생성)
//        calculator 라는 참조 변수에 배정


        Calculator calculator = new Calculator(30.0, 5.0);
        IO.println("덧셈 계산 결과 : " + calculator.sum());
        IO.println("뺄셈 계산 결과 : " + calculator.substract());
        IO.println("곱셈   계산 결과 : " + calculator.multiply());
        IO.println("나눗셈 계산 결과 : " + calculator.divide());

//        calculator에 새로운 객체를 재할당
        calculator = new Calculator(45.0, 3.0);
        for (int i = 1; i <= 5; i++) {
            IO.println("i = " + i);
        }
    }
}
