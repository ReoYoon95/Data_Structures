package idusw.dsa.Reo260924;

public class GugudanTest {
    static void main(String[] args) {
        Gugudan gugu = new Gugudan();

        gugu.printBase();

        for (int i =1; i < 9; i++){
            System.out.println("cols 값은 : "+ i);
            gugu.printByCols(i);
        }

    }
}
