package output;

import logic.CounterFiles;
import logic.Logic;

/**
 * Created by viktor on 10.07.17.
 */
public class View {
    static {
        System.out.println("Press ESC to cancel search");
        System.out.println("Press Q to exit");
        System.out.println("-----------------------------------------------------");
        System.out.printf("|%-3s| %-12s| %s%n", "№", "Count Files", "Path");
        System.out.println("-----------------------------------------------------");
    }

    public void showResults(long countFiles) {
        int numberOfThread = CounterFiles.getNumberOfThread();
        long count = countFiles;
        String path = CounterFiles.getPath();
        if (Logic.isInterrupt() == false) {
            if (countFiles == -1) {
                System.out.printf("|%-3d| %-12d| %s %s%n", numberOfThread, 0, path, " - INVALID PATH");
                return;
            }
            System.out.printf("|%-3d| %-12d| %s%n", numberOfThread, count, path);
        } else {
            System.out.printf("|%-3d| %-12d| %s %s%n", numberOfThread, count, path, " - Cancelled");
        }


    }
}
