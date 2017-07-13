package logic;

import output.OutputFile;
import output.View;

import java.io.File;


public class CounterFiles implements Runnable {
    private static String path;
    private static String outFile;
    private long countFiles;
    private static int numberOfThread;

    public static String getPath() {
        return path;
    }
    public static int getNumberOfThread() {
        return numberOfThread;
    }

    CounterFiles(String path, int numberOfThread, String outFile) {
        CounterFiles.path = path;
        CounterFiles.numberOfThread = numberOfThread;
        CounterFiles.outFile = outFile;
    }

    public Long numberOfFiles(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        if (files == null) {
            return -1L;
        }
        for (File localPath : files) {
            if (Logic.isInterrupt() == true) {
                break;
            }
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
        OutputFile.writeFile(outFile, path, countFiles);

    }
}
