package logic;

import input.InputFile;
import output.OutputFile;

public class Logic {
    private InputFile inputFile;
    private String path;
    private String outFile;
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
        OutputFile.clearCSVFile(outFile);
        for (String path : inputFile.parseInputFile(this.path)) {
            numberOfThread++;
            new Thread(new CounterFiles(path, numberOfThread, outFile), "Thread #" + numberOfThread).run();
        }

    }
}
