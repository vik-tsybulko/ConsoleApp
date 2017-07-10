import java.util.ArrayList;
import java.util.List;


public class Logic {
    InputFile inputFile;
    String path;
    String outFile;
    List<Thread> counterThreads = new ArrayList<Thread>();
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
            counterThreads.add(new Thread(new CounterFiles(path), path));
        }
        for (Thread thread : counterThreads) {
            thread.run();
        }
    }
}
