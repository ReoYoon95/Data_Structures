package idusw.dsa.Reo261001;

public class ArrayTest {
    public static void main() {
        String[] teams = {"a", "b", "c",};
        String[] names = {"김", "이", "윤"};

        for(int i = 0; i < teams.length; i++) {
            System.out.println(teams[i] + " : " + names[i]);
        }

        for(String team : teams) {
            System.out.println(team);
        }

        int cnt = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0) {
                System.out.print(i + ", ");
                cnt++;
                if(cnt >= 10) {
                    break;
                }
            }

        }
    }

}
