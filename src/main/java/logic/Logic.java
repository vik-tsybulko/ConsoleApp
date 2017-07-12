package logic;

import input.InputFile;
import output.View;

import java.util.ArrayList;
import java.util.List;


public class Logic {
    private InputFile inputFile;
    private String path;
    private String outFile;
    private List<Thread> counterThreads = new ArrayList<Thread>();
    private int numberOfThread = 0;
    Logic(String inFile, String outFile) {
        inputFile = new InputFile();
        path = inFile;
        this.outFile = outFile;
    }

    public void createThreads() {
        if (inputFile.parseInputFile(this.path).size() == 0) {
            System.out.println("No path");
            return;
        }
        for (String path : inputFile.parseInputFile(this.path)) {
            numberOfThread++;
            new Thread(new CounterFiles(path, numberOfThread), "Thread #" + numberOfThread).run();
            //counterThreads.add(new Thread(new CounterFiles(path, numberOfThread), path));
        }
//        for (Thread thread : counterThreads) {
//            thread.run();
//        }
    }
}
