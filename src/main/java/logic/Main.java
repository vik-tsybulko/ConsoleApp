package logic;

import java.io.FileNotFoundException;

/**
 * Created by viktor on 06.07.17.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String input = null;
        String output = null;
        if (args != null && args.length == 2) {
            input = args[0];
            output = args[1];
        }
        Logic logic = new Logic(input, output);
        logic.createThreads();



    }

}

