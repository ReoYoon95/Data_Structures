package idusw.dsa.Reo260917;

public class Calculator {
    double result = 0.0;
    double op1, op2;

    public Calculator() {

    }

    public Calculator(double op1, double op2) {
        this.op1 = op1;
        this.op2 = op2;

    }

    public double sum() {
        result = op1 + op2;
        return result;
    }

    public double substract() {
        result = op1 - op2;
        return result;
    }
    public double multiply() {
        result = op1 * op2;
        return result;
    }
    public double divide() {
        if (op2 != 0) {
            result = op1 / op2;
            return result;
        }
        else return 0.0;
    }

//
//    // 1. 숫자 클래스(Number)를 상속받은 모든 타입(T)을 파라미터로 받는 제네릭 메서드
//    public <T extends Number> double sum(T op1, T op2) {
//        // 2. 전달된 숫자의 종류에 상관없이 실수값으로 추출하여 더한 후 반환
//        return op1.doubleValue() + op2.doubleValue();
//    }
//
//    // 3. 제네릭 나눗셈 메서드
//    public <T extends Number> double divide(T op1, T op2) {
//        // 4. 분모가 0인지 체크
//        if (op2.doubleValue() != 0.0) {
//            // 5. 두 값을 실수로 추출하여 나눈 몫을 반환
//            return op1.doubleValue() / op2.doubleValue();
//        } else {
//            // 6. 0으로 나누려 할 경우 0.0 반환
//            return 0.0;
//        }
//    }
}