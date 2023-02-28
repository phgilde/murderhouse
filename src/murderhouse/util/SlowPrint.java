package murderhouse.util;

public class SlowPrint {
    public static void slowPrint(String s) {
        for (char c : s.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
