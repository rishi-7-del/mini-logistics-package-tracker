package tracker.util;

import tracker.model.Package;

import java.io.*;
import java.util.*;

public class FileHandler {

    public static List<Package> loadPackages(String file) {
        List<Package> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                list.add(new Package(parts[0], parts[1], parts[2], parts[3]));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return list;
    }
}