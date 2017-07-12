package output;

import java.io.*;
import com.csvreader.*;

public class OutputFile {
    public static void clearCSVFile(String outFile) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            File file = isSCV(outFile);
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            if (file.exists()) {
                bw.write("");
            } else {
                file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeFile(String outFile,String path, long countFiles) {

            File file = isSCV(outFile);
        CsvWriter csvOutput = null;
        try {
            csvOutput = new CsvWriter(new FileWriter(file, true), ';');
            csvOutput.write(path);
            csvOutput.write(Long.toString(countFiles));
            csvOutput.endRecord();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            csvOutput.close();
        }
    }

    public static File isSCV(String outFile) {
        if (outFile.matches("^\\w+\\.[cC][sS][vV]$") == true) {
            return new File(outFile);
        } else {
            return new File(outFile + ".csv");
        }
    }
}
