import java.io.File;


public class CounterFiles implements Runnable {
    private String path;
    private long countFiles;

    CounterFiles(String path) {
        this.path = path;

    }

    public long getCountFiles() {
        return countFiles;
    }

    public Long numberOfFiles(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

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
        System.out.println(numberOfFiles(path));

    }
}
