package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Formatter {
    public void formatted(ArrayList<String> usersList, ArrayList<String> timestampsList) {
        int count = 0;
        for (String user : usersList) {
            System.out.printf("%s\s%s\n", user, timestampsList.get(count));
            count += 1;
        }
    }
}
