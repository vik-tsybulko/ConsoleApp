package logic;

import output.View;

import java.io.File;


public class CounterFiles implements Runnable {
    private static String path;
    private long countFiles;
    private static int numberOfThread;

    public static String getPath() {
        return path;
    }
    public static int getNumberOfThread() {
        return numberOfThread;
    }

    CounterFiles(String path, int numberOfThread) {
        CounterFiles.path = path;
        CounterFiles.numberOfThread = numberOfThread;


    }

    public Long numberOfFiles(String path) {

        File file = new File(path);
        File[] files = file.listFiles();
        if (files == null) {
            return -1L;
        }
        for (File localPath : files) {
            if (localPath.isDirectory()) {
                numberOfFiles(localPath.getPath());
            }
            if (localPath.isFile()) {
                countFiles++;
            }
        }
        return countFiles;
    }
    public void run() {
        View view = new View();
        view.showResults(numberOfFiles(path));


    }
}
