package murderhouse.util;

public class SlowPrint {
    static private int lineSize = 50;
    static private int delay = 0;

    public static void slowPrint(String s) {
        int i = 0;
        boolean newlineDue = false;
        for (char c : s.toCharArray()) {

            System.out.print(c);
            i++;
            if (i % lineSize == 0) {
                newlineDue = true;
            }
            if (newlineDue && c == ' ') {
                System.out.println();
                newlineDue = false;
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
