import java.io.*;
import java.util.ArrayList;


public class InputFile {
    public ArrayList<String> parseInputFile( String inputFile){
        BufferedReader br = null;
        ArrayList<String> listOfPath = new ArrayList<String>();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
            String line;
            int indexOfArray = 0;
            while ((line = br.readLine()) != null) {
                listOfPath.add(indexOfArray, line);
                indexOfArray++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listOfPath;

    }
}
